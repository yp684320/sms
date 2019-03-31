package test;


import com.itheima.producer.ProducerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApplication.class)
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //ActiveMQ点对点模式(一对一)   直接模式Direct
    //1 "Hello World!"    The simplest thing that does something
    @Test
    public void test1() {
        //进行消息的发送
        //第一个参数:指定消息发送到哪里(那个队列),需要提前在RabbitMQ管理界面创建队列
        //第二个参数:需要发送的消息内容
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("itcast", "直接模式发送消息" + i);
        }

        //官网上第二种是工作模式
        //Work queues Distributing tasks among workers (the competing consumers pattern)
        //一个生产者发消息,两个(多个)消费者消费消息,轮询(平均分配)方式进行消息消费

        //工作模式的另外一个种,能者多劳模式
        //能者多劳是需要开启消息确认(只有消费者消费完消息并且告诉MQ,MQ才会把新的消息给消费者)
        //效果是消费者消费消息越快,能消费的消息数量越多
        //是用在生产者生产消息速度大于消费者消费消息

    }


    //相当于ActiveMQ的发布/订阅模式(一对多)
    //分列模式（Fanout）
    @Test
    public void test2() {
        //使用分列模式,本质把消息发给交换器,再由交换器把消息发给队列,可以发给对应的所有队列
        //在执行代码之前,需要先在RabbitMQ管理界面创建一个交换机Exchange,类型指定Fanout
        //创建完交换机后,准备两个(多个)队列,再把队列和交换机进行绑定
        //第一个参数:交换机的名字
        //第二个参数:路由键,现在并没有用到,填写为空串""
        //第三个参数:发送的消息内容
        rabbitTemplate.convertAndSend("chuanzhi", "", "消息");
    }


    //主题模式topic    ActiveMQ没有此功能
    @Test
    public void test3() {
        //使用RabbitMQ的管理界面,创建交换机,类型是topic
        //把队列绑定到交换机上,要指定路由键
        //第一个参数:交换机的名字
        //第二个参数:路由键,现在有用到按照需求制定路由键
        //第三个参数:发送的消息内容
        rabbitTemplate.convertAndSend("chuanzhi", "log.def", "log.def主题模式消息消息");
    }

}
