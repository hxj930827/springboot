/**
 * FileName: DirectReceiver
 * Author:   韩旭杰
 * Date:     2019/2/14 10:53
 * Description:
 */
package com.example.springboot.rabbitmq.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

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
    @RabbitHandler
    public void process(String msg) {
        System.out.println("directReceiver  : " + msg);
    }
}
