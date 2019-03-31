package cn.itcast.core.controller.spec;

import cn.itcast.core.service.spec.SpecService;
import cn.itcast.core.entity.PageResult;
import cn.itcast.core.entity.Result;
import cn.itcast.core.pojo.specification.Specification;
import cn.itcast.core.vo.SpecVo;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/specification")
public class SpecController {
    @Reference
    SpecService specService;

    /**
     * 条件分页查询
     */
    @RequestMapping("/search.do")
    public PageResult search(Integer page, Integer rows, @RequestBody Specification specification){
        PageResult search = specService.search(page, rows, specification);
       // System.out.println(search);
        return search;
    }

    /**
     * 批量插入
     * @param specVo
     * @return
     */
    @RequestMapping("/add.do")
    public Result add(@RequestBody SpecVo specVo){
        try {
            specService.add(specVo);
            return new Result(true,"保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"保存失败");
        }

    }

    /**
     * 修改数据回显
     * @param id
     * @return
     */
    @RequestMapping("/findOne.do")
    public SpecVo findOne(Long id){
       return specService.findOne(id);
    }

    /**
     * 修改
     * @param specVo
     * @return
     */
    @RequestMapping("/update.do")
    public Result update(@RequestBody SpecVo specVo){
        try {
            specService.update(specVo);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }

    }
    @RequestMapping("/delete.do")
    public Result delete(Long[] ids){
        try {
            specService.delete(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }

    }
    /**
     * 新增模板时初始化规格
     * @return
     */
    @RequestMapping("/selectOptionList.do")
    public List<Map<String,String>> selectOptionList(){
        return specService.selectOptionList();
    }
}
