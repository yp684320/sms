package cn.itcast.core.service.pay;

import cn.itcast.core.dao.log.PayLogDao;
import cn.itcast.core.dao.order.OrderDao;
import cn.itcast.core.pojo.log.PayLog;
import cn.itcast.core.pojo.order.Order;
import cn.itcast.core.pojo.order.OrderQuery;
import cn.itcast.core.utils.http.HttpClient;
import cn.itcast.core.utils.uniquekey.IdWorker;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.*;

@Service
public class PayServiceImpl implements PayService {
    @Value("${appid}")
    private String appid;         // 微信公众账号或开放平台APP的唯一标识
    @Value("${partner}")
    private String partner;       // 财付通平台的商户账号
    @Value("${partnerkey}")
    private String partnerkey;    // 财付通平台的商户秘钥
    @Value("${notifyurl}")
    private String notifyurl;      // 回调地址
    @Resource
    private IdWorker idWorker;
    @Resource
    private RedisTemplate<String , Object> redisTemplate;
    @Resource
    private PayLogDao payLogDao;
    @Resource
    private OrderDao orderDao;
    /**
     * 生成二维码
     * @return
     */
    @Override
    public Map<String, String> createNative(String username) throws Exception {
        // 从redis 中取出日志
        PayLog paylog = (PayLog) redisTemplate.boundHashOps("paylog").get(username);
        Map<String , String> data = new HashMap<>();
        // 交易流失号
        long outTradeNo = idWorker.nextId();
       // data.put("out_trade_no",Long.toString(outTradeNo));
        // 交易金额
        //data.put("total_fee","1");
        // 二维码地址
       // data.put("code_url","https://www.baidu.com/");
        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        // 调用微信统一下单api接口
//        公众账号ID 	appid 	是 	String(32) 	wxd678efh567hg6787 	微信支付分配的公众账号ID（企业号corpid即为此appId）
        data.put("appid",appid);
//        商户号 	mch_id 	是 	String(32) 	1230000109 	微信支付分配的商户号
        data.put("mch_id",partner);
//        随机字符串 	nonce_str 	是 	String(32) 	5K8264ILTKCH16CQ2502SI8ZNMTM67VS 	随机字符串，长度要求在32位以内。推荐随机数生成算法
        data.put("nonce_str", WXPayUtil.generateNonceStr());
//        签名 	sign 	是 	String(32) 	C380BEC2BFD727A4B6845133519F3AD6 	通过签名算法计算得出的签名值，详见签名生成算法
//        商品描述 	body 	是 	String(128) 	腾讯充值中心-QQ会员充值
        data.put("body","品优购订单支付");
//        商户订单号 	out_trade_no 	是 	String(32) 	20150806125346 	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。详见商户订单号
       // data.put("out_trade_no",String.valueOf(outTradeNo));
        data.put("out_trade_no",paylog.getOutTradeNo());
//        标价金额 	total_fee 	是 	Int 	88 	订单总金额，单位为分，详见支付金额
        data.put("total_fee","1");
        //data.put("total_fee",String.valueOf(paylog.getTotalFee())); // 真正支付的金额
//        终端IP 	spbill_create_ip 	是 	String(64) 	123.12.12.123 	支持IPV4和IPV6两种格式的IP地址。调用微信支付API的机器IP
        data.put("spbill_create_ip","192.168.200.128");
//        通知地址 	notify_url 	是 	String(256) 	http://www.weixin.qq.com/wxpay/pay.php 	异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
        data.put("notify_url",notifyurl);
//        交易类型 	trade_type 	是 	String(16) 	JSAPI
        data.put("trade_type","NATIVE");
       String xmlParam = WXPayUtil.generateSignedXml(data,partnerkey);
       // 通过HttpClient发送请求
        HttpClient httpClient = new HttpClient(url);
        httpClient.setHttps(true);  //支持https
        httpClient.setXmlParam(xmlParam); //微信下单接口需要的数据
        httpClient.post();//post请求
        String content = httpClient.getContent();  // 响应结果
       // System.out.println("调用微信统一下单接口 "+ content);
        Map<String, String> map = WXPayUtil.xmlToMap(content);
        map.put("out_trade_no",paylog.getOutTradeNo());
        map.put("total_fee",String.valueOf(paylog.getTotalFee()));
        return map;
    }

    /**
     * 查询微信支付订单
     * @param out_trade_no
     * @return
     */
    @Override
    public Map<String, String> queryPayStatus(String out_trade_no,String username) throws Exception {
        String url = "https://api.mch.weixin.qq.com/pay/orderquery";
        //1、创建map封装接口需要的参数
        Map<String, String> data = new HashMap<>();
//        公众账号ID 	appid 	是 	String(32) 	wxd678efh567hg6787 	微信支付分配的公众账号ID（企业号corpid即为此appId）
        data.put("appid",appid);
//        商户号 	mch_id 	是 	String(32) 	1230000109 	微信支付分配的商户号
        data.put("mch_id",partner);
//        微信订单号 	transaction_id 	二选一 	String(32) 	1009660380201506130728806387 	微信的订单号，建议优先使用
//        商户订单号 	out_trade_no 	String(32) 	20150806125346 	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。 详见商户订单号
        data.put("out_trade_no",out_trade_no);
//        随机字符串 	nonce_str 	是 	String(32) 	C380BEC2BFD727A4B6845133519F3AD6 	随机字符串，不长于32位。推荐随机数生成算法
        data.put("nonce_str",WXPayUtil.generateNonceStr());
//        签名 	sign 	是 	String(32) 	5K8264ILTKCH16CQ2502SI8ZNMTM67VS 	通过签名算法计算得出的签名值，详见签名生成算法
//        签名类型 	sign_type 	否 	String(32) 	HMAC-SHA256
        // 2, 将map转成xml格式的数据
        String xmlParam = WXPayUtil.generateSignedXml(data, partnerkey);
        // 3, 通过httpclient模拟浏览器发送请求
        HttpClient httpClient = new HttpClient(url);
        httpClient.setHttps(true);
        httpClient.setXmlParam(xmlParam);
        httpClient.post();
        // 4, 获取响应的结果：将xml转成map
        String content = httpClient.getContent();
        Map<String, String> map = WXPayUtil.xmlToMap(content);
        // 5 如果支付成功  需要更新日志列表
        String trade_state = map.get("trade_state");
        if ("SUCCESS".equals(trade_state)) {
            PayLog payLog = new PayLog();
            payLog.setOutTradeNo(out_trade_no);
            payLog.setPayTime(new Date());  // 支付日期
            payLog.setTransactionId(map.get("transaction_id")); // 第三方提供的流水号
            payLog.setTradeState("1");  //支付成功
            payLogDao.updateByPrimaryKeySelective(payLog);
            //  更新订单表的数据
            PayLog paylog = (PayLog) redisTemplate.boundHashOps("paylog").get(username);
            // 获取orderList
            String orderList = paylog.getOrderList();
            // System.out.println(orderList);
            List<String> orderIds = Arrays.asList(orderList.split(","));
            for (String orderId : orderIds) {
                String orderid = orderId.trim();  // 取出空格
                // System.out.println(string);
                Order order = new Order();
                order.setOrderId(Long.valueOf(orderid)); // 保存orderId
                order.setStatus("2"); // 更改订单状态
                order.setUpdateTime(new Date()); // 订单更新时间
                orderDao.updateByPrimaryKeySelective(order); // 更新订单
            }
            //  删除缓存中的日志
            redisTemplate.delete("paylog");



        }
        return map;
    }
}
