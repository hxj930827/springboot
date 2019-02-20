/**
 * FileName: DirectReceiver1
 * Author:   韩旭杰
 * Date:     2019/2/20 17:30
 * Description:
 */
package com.example.springboot.rabbitmq.direct;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 说明：〈〉
 *
 * @author 韩旭杰
 * @date 2019/2/20
 * @since 1.0.0
 */
@Component
@RabbitListener(queues = "direct")
public class DirectReceiver1 {

    @RabbitHandler
    public void getMessage(String msg, Channel channel) throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("如果上一个消费者没有向mq返回确认信息，mq会认为它没有收到信息，我会把这条信息抢过来");
        try {
            channel.basicAck(1,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
