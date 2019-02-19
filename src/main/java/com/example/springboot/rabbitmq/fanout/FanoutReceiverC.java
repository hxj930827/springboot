/**
 * FileName: FanoutReceiverC
 * Author:   韩旭杰
 * Date:     2019/2/13 15:58
 * Description: 消费者C
 */
package com.example.springboot.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 说明：〈消费者C〉
 *
 * @author 韩旭杰
 * @date 2019/2/13
 * @since 1.0.0
 */
@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiverC {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiverC  : " + msg);
    }
}
