package cn.itcast.core.service.seller;

import cn.itcast.core.dao.seller.SellerDao;
import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.seller.Seller;
import cn.itcast.core.pojo.seller.SellerQuery;
import cn.itcast.core.service.seller.SellerService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class SellerServiceImpl implements SellerService {
    @Resource
    private SellerDao sellerDao;

    /**
     * 商家入驻申请
     * @param seller
     */
    @Override
    public void add(Seller seller) {
        // 设置商家审核状态
        seller.setStatus("0"); // 未审核
        seller.setCreateTime(new Date()); // 提交日期
        // 密码加密：md5、BCrypt（加盐）
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode(seller.getPassword());
        seller.setPassword(password);
        //保存商家
        sellerDao.insertSelective(seller);

    }

    /**
     * 查询待审核的商家列表
     * @param page
     * @param rows
     * @param seller
     * @return
     */
    @Override
    public PageResult search(Integer page, Integer rows, Seller seller) {
        //设置分页条件
        PageHelper.startPage(page,rows);
        //设置查询条件
        SellerQuery sellerQuery = new SellerQuery();
        if (seller.getStatus()!=null && !"".equals(seller.getStatus().trim())){
            sellerQuery.createCriteria().andStatusEqualTo(seller.getStatus().trim());
        }
        //查询数据
        Page<Seller> p = (Page<Seller>) sellerDao.selectByExample(sellerQuery);
        //返回数据
        return new PageResult(p.getResult(),p.getTotal());

    }

    /**
     * 待审核的商家详情
     * @param sellerId
     * @return
     */
    @Override
    public Seller findOne(String sellerId) {
        return sellerDao.selectByPrimaryKey(sellerId);
    }

    /**
     * 商家审核
     * @param sellerId
     * @param status
     */
    @Transactional
    @Override
    public void updateStatus(String sellerId, String status) {
        Seller seller = new Seller();
        seller.setSellerId(sellerId);
        seller.setStatus(status);
        sellerDao.updateByPrimaryKeySelective(seller);
    }
}
