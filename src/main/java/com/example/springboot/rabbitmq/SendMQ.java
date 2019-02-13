/**
 * FileName: SendMQ
 * Author:   韩旭杰
 * Date:     2019/2/13 9:04
 * Description: MQ发送端
 */
package com.example.springboot.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * 说明：〈MQ发送端〉
 *
 * @author 韩旭杰
 * @date 2019/2/13
 * @since 1.0.0
 */
public class SendMQ {
    private final static String QUEUE_NAME = "Hello";

    public static void main(String[] args) throws IOException, Exception {
        // connection是socket连接的抽象，并且为我们管理协议版本协商（protocol version negotiation），
        // 认证（authentication ）等等事情。这里我们要连接的消息代理在本地，因此我们将host设为“localhost”。
        // 如果我们想连接其他机器上的代理，只需要将这里改为特定的主机名或IP地址。
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //默认端口号
        factory.setPort(5672);
        //默认用户名
        factory.setUsername("guest");
        //默认密码
        factory.setPassword("guest");
        // 网络连接，比如一个TCP连接。
        Connection connection = factory.newConnection();
        // 信道，多路复用连接中的一条独立的双向数据流通道。信道是建立在真实的TCP连接内地虚拟连接，
        // AMQP 命令都是通过信道发出去的，不管是发布消息、订阅队列还是接收消息，这些动作都是通过信道完成。
        // 因为对于操作系统来说建立和销毁 TCP 都是非常昂贵的开销，所以引入了信道的概念，以复用一条 TCP 连接。
        Channel channel = connection.createChannel();
        // 接下来，我们创建一个channel，绝大部分API方法需要通过调用它来完成。
        // 发送之前，我们必须声明消息要发往哪个队列，然后我们可以向队列发一条消息：
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello world";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();
    }
}
