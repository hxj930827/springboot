/**
 * FileName: DirectReceiver
 * Author:   韩旭杰
 * Date:     2019/2/14 10:53
 * Description:
 */
package com.example.springboot.rabbitmq.direct;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 说明：〈〉
 *
 * @author 韩旭杰
 * @date 2019/2/14
 * @since 1.0.0
 */
@Component
@RabbitListener(queues = "direct")
public class DirectReceiver {
    private static final Logger logger = LoggerFactory.getLogger(DirectReceiver.class);
    // Tag是消息传送的次数
    @RabbitHandler
    public void process(String msg,Channel channel,@Header(AmqpHeaders.DELIVERY_TAG) long tag) throws InterruptedException {
        Thread.sleep(20000);
        System.out.println("directReceiver  : " + msg+"  tag:"+tag);
        try {
            /**
             * basicAck(long var1, boolean var3)：正确处理了消息，
             * var1：该消息的次数(发送的次数，每重发一次，次数+1，重发是由basicNack或basicReject重发)，
             * var3：是否批量，true：确认所有消息 false：只确认当前消息
             *
             * basicNack(long var1, boolean var3, boolean var4)：错误的处理了消息
             * var1：该消息的次数
             * var3：是否批量，true：确认所有消息 false：只确认当前消息
             * var4：是否重新入队列
             *
             * basicReject(long var1, boolean var3)
             * var1：该消息的次数，
             * var3：是否批量，true：确认所有消息 false：只确认当前消息
             */
            //channel.basicNack(tag, false,true);
        } catch (Exception e) {
            logger.error("RabbitMQ，IO异常，异常原因为：{}", e.getMessage());
        }
    }

}
