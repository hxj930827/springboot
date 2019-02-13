/**
 * FileName: HelloReceiver2
 * Author:   韩旭杰
 * Date:     2019/2/13 14:27
 * Description: 用于消费者测试
 */
package com.example.springboot.rabbitmq.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 说明：〈用于消费者2测试〉
 *
 * @author 韩旭杰
 * @date 2019/2/13
 * @since 1.0.0
 */
@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiver2 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver2  : " + hello);
    }

}
