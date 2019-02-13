/**
 * FileName: FanoutReceiverB
 * Author:   韩旭杰
 * Date:     2019/2/13 15:57
 * Description: 消费者B
 */
package com.example.springboot.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 说明：〈消费者B〉
 *
 * @author 韩旭杰
 * @date 2019/2/13
 * @since 1.0.0
 */
@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiverB {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiverB  : " + msg);
    }

}
