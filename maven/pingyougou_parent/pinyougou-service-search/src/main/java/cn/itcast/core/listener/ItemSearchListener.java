package cn.itcast.core.listener;

import cn.itcast.core.dao.item.ItemDao;
import cn.itcast.core.service.search.ItemSearchService;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.data.solr.core.SolrTemplate;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * 自定义消息监听器  将商品信息保存到索引库中
 */
public class ItemSearchListener implements MessageListener {
    @Resource
    private ItemSearchService itemSearchService;

    /**
     * 获取容器中的消息
     * @param message
     */
    @Resource
    private ItemDao itemDao;
    @Resource
    private SolrTemplate solrTemplate;
    @Override
    public void onMessage(Message message) {
        try {
            //取出消息
            ActiveMQTextMessage activeMQTextMessage = (ActiveMQTextMessage) message;
            String id = activeMQTextMessage.getText();
            System.out.println("消费者search获取到的id"+id);
            //消费消息
           itemSearchService.updateItemToSolr2(Long.parseLong(id));
          /*  ItemQuery itemQuery = new ItemQuery();
            itemQuery.createCriteria().andGoodsIdEqualTo(Long.parseLong(id)).andIsDefaultEqualTo("1").andStatusEqualTo("1");
            List<Item> items = itemDao.selectByExample(itemQuery);

            if(items != null && items.size() > 0){
                // 处理动态字段
                for (Item item : items) {
                    // 栗子：{"机身内存":"16G","网络":"联通3G"}
                    String spec = item.getSpec();
                    // 拼接的动态字段：item_spec_机身内存 、 item_spec_网络
                    Map<String, String> specMap = JSON.parseObject(spec, Map.class);
                    item.setSpecMap(specMap);
                }
                solrTemplate.saveBeans(items);
                solrTemplate.commit();
            }*/
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
