package cn.itcast.core.service.seller;

import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.seller.Seller;

public interface SellerService {
    /**
     * 商家入驻申请
     * @param seller
     */
    public void add(Seller seller);
//商家审核:
    //1, 查询待审核的商家列表  默认查询待审核
    //2, 查询该商家的详情(对该商家进行审核)

    /**
     * 查询待审核的商家列表
     * @param page
     * @param rows
     * @param seller
     * @return
     */
    public PageResult search(Integer page,Integer rows,Seller seller);

    /**
     * 待审核的商家详情
     * @param sellerId
     * @return
     */
    public Seller findOne(String sellerId);

    /**
     * 商家审核
     * @param sellerId
     * @param status
     */
    public void updateStatus(String sellerId,String status);
}
