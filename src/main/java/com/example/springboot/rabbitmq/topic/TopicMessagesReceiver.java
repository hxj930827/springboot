/**
 * FileName: TopicMessagesReceiver
 * Author:   韩旭杰
 * Date:     2019/2/13 15:16
 * Description: TopicMessages消费者
 */
package com.example.springboot.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 说明：〈TopicMessages消费者〉
 *
 * @author 韩旭杰
 * @date 2019/2/13
 * @since 1.0.0
 */
@Component
@RabbitListener(queues = "topic.messages")
public class TopicMessagesReceiver {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("topicMessagesReceiver  : " +msg);
    }
}
