/**
 * FileName: TipicReceiver
 * Author:   韩旭杰
 * Date:     2019/2/13 15:14
 * Description: topic消费者1
 */
package com.example.springboot.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 说明：〈topicMessage消费者〉
 *
 * @author 韩旭杰
 * @date 2019/2/13
 * @since 1.0.0
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicMessageReceiver {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("topicMessageReceiver  : " +msg);
    }
}
