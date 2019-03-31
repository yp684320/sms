package cn.itcast.core.service.content;

import java.util.List;

import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.ad.ContentQuery;
import cn.itcast.core.dao.ad.ContentDao;
import cn.itcast.core.service.content.ContentService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.itcast.core.pojo.ad.Content;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@Service
public class ContentServiceImpl implements ContentService {
	@Resource
	private RedisTemplate<String ,Object> redisTemplate;

	@Resource
	private ContentDao contentDao;

	@Override
	public List<Content> findAll() {
		List<Content> list = contentDao.selectByExample(null);
		return list;
	}

	@Override
	public PageResult findPage(Content content, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<Content> page = (Page<Content>)contentDao.selectByExample(null);
		return new PageResult(  page.getResult(),page.getTotal());
	}

	@Override
	public void add(Content content) {
		// 新增广告时需要更新缓存，清空之前的缓存
		clearCache(content.getCategoryId());
		contentDao.insertSelective(content);
	}



	@Override
	public void edit(Content content) {
		// 判断广告分类是否发生变化
		Long newCategoryId = content.getCategoryId();
		Long oldCategoryId = contentDao.selectByPrimaryKey(content.getId()).getCategoryId();
		if (newCategoryId!=oldCategoryId) {
			//如果改变
			clearCache(newCategoryId);
			clearCache(oldCategoryId);
		}else{
			//没有改变
            clearCache(newCategoryId);
		}
		contentDao.updateByPrimaryKeySelective(content);
	}

	@Override
	public Content findOne(Long id) {
		Content content = contentDao.selectByPrimaryKey(id);
		return content;
	}

	@Override
	public void delAll(Long[] ids) {
		if(ids != null){
			for(Long id : ids){
				//删除广告时需要更新缓存 清空之前的缓存
				Long categoryId = contentDao.selectByPrimaryKey(id).getCategoryId();
				clearCache(categoryId);
				contentDao.deleteByPrimaryKey(id);
			}
		}
	}
	/**
	 * 首页大广告的轮播图
	 * @param categoryId
	 * @return
	 */
	@Override
	public List<Content> findByCategoryId(Long categoryId) {
		// 查询该分类下的广告列表
		List<Content> list = (List<Content>) redisTemplate.boundHashOps("content").get(categoryId);
		synchronized (this){
			list = (List<Content>) redisTemplate.boundHashOps("content").get(categoryId);
			if (list == null ) {// 根据sort_order排序并且查询可用的广告
				ContentQuery contentQuery = new ContentQuery();
				contentQuery.createCriteria().andCategoryIdEqualTo(categoryId).andStatusEqualTo("1");
				contentQuery.setOrderByClause("sort_order desc");
				 list = contentDao.selectByExample(contentQuery);
				// 将数据放入缓存
				redisTemplate.boundHashOps("content").put(categoryId, list);
			}
		}
		return list;
	}
	/**
	 * 清空缓存
	 * @param categoryId
	 */
	private void clearCache(Long categoryId) {
       redisTemplate.boundHashOps("content").delete(categoryId);
	}
}
