package cn.itcast.core.listener;

import cn.itcast.core.service.search.ItemSearchService;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * 自定义监听器  将商品信息从索引库中删除
 */
public class ItemDeleteListener implements MessageListener{
    @Resource
    private ItemSearchService itemSearchService;
    /**
     * 从容器中取出消息
     * @param message
     */
    @Override
    public void onMessage(Message message) {
        try {
            //取出消息
            ActiveMQTextMessage activeMQTextMessage = (ActiveMQTextMessage) message;
            String id = activeMQTextMessage.getText();
            System.out.println("消费者search获取到的id"+id);
            //消费消息
            itemSearchService.deleteItemFromSolr(Long.parseLong(id));
            System.out.println(111);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
