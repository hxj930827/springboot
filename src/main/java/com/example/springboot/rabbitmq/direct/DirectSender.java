/**
 * FileName: DirectSender
 * Author:   韩旭杰
 * Date:     2019/2/14 10:51
 * Description:
 */
package com.example.springboot.rabbitmq.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 说明：〈〉
 *
 * @author 韩旭杰
 * @date 2019/2/14
 * @since 1.0.0
 */
@Component
public class DirectSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send() {
        String msgString="directSender :hello i am hzb";
        System.out.println(msgString);
        this.rabbitTemplate.convertAndSend("direct", msgString);
    }
}
