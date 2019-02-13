/**
 * FileName: RevcMQ
 * Author:   韩旭杰
 * Date:     2019/2/13 9:06
 * Description: MQ接收端
 */
package com.example.springboot.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 说明：〈MQ接收端〉
 *
 * @author 韩旭杰
 * @date 2019/2/13
 * @since 1.0.0
 */
public class RevcMQ {
    private final static String QUEUE_NAME = "Hello";

    public static void main(String[] args) throws IOException, Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        // 网络连接，比如一个TCP连接。
        Connection connection = factory.newConnection();
        // 信道，多路复用连接中的一条独立的双向数据流通道。信道是建立在真实的TCP连接内地虚拟连接，
        // AMQP 命令都是通过信道发出去的，不管是发布消息、订阅队列还是接收消息，这些动作都是通过信道完成。
        // 因为对于操作系统来说建立和销毁 TCP 都是非常昂贵的开销，所以引入了信道的概念，以复用一条 TCP 连接。
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
