package cn.itcast.core.controller.pay;

import cn.itcast.core.entity.Result;
import cn.itcast.core.service.pay.PayService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/pay")
public class PayController {
    @Reference
    private PayService payService;

    /**
     * 生成支付的二维码
     * @return
     */
    @RequestMapping("/createNative.do")
    public Map<String , String> createNative() throws Exception  {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return payService.createNative(username);
    }

    /**
     * 查询微信支付订单
     * @param out_trade_no
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryPayStatus.do")
    public Result queryPayStatus(String out_trade_no)  {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            int time = 0;
            while (true) {
                Map<String, String> map = payService.queryPayStatus(out_trade_no,username);
                String trade_state = map.get("trade_state");
                if ("SUCCESS".equals(trade_state)) {
                    //交易成功
                    return new Result(true, "微信支付成功");
                }else{
                     // 其他状态
                    Thread.sleep(5000);
                    time ++;
                }
                // 如果超过半小时让二维码失效
                if (time > 360) {
                    return new Result(false, "二维码失效");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "微信支付失败");
        }



    }
}
