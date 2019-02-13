/**
 * FileName: HelloReceiver1
 * Author:   韩旭杰
 * Date:     2019/2/13 10:49
 * Description: 最简单的hello生产和消费实现（单生产者和单消费者）
 */
package com.example.springboot.rabbitmq.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 说明：〈最简单的hello生产和消费实现（单生产者和单消费者）〉
 *
 * @author 韩旭杰
 * @date 2019/2/13
 * @since 1.0.0
 */
@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiver1 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }

}
