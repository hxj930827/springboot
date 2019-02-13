/**
 * FileName: HelloSender1
 * Author:   韩旭杰
 * Date:     2019/2/13 10:47
 * Description: 最简单的hello生产和消费实现（单生产者和单消费者）
 */
package com.example.springboot.rabbitmq.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 说明：〈最简单的hello生产和消费实现（单生产者和单消费者）〉
 *
 * @author 韩旭杰
 * @date 2019/2/13
 * @since 1.0.0
 */
@Component
public class HelloSender1 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String sendMsg = "hello1 " + new Date();
        System.out.println("Sender1 : " + sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }
}
