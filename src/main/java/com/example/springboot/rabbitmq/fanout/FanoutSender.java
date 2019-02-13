/**
 * FileName: FanoutSender
 * Author:   韩旭杰
 * Date:     2019/2/13 15:52
 * Description: 生产者
 */
package com.example.springboot.rabbitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 说明：〈生产者〉
 *
 * @author 韩旭杰
 * @date 2019/2/13
 * @since 1.0.0
 */
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send() {
        String msgString="fanoutSender :hello i am hzb";
        System.out.println(msgString);
        // 参数2被忽略
        this.rabbitTemplate.convertAndSend("fanoutExchange","", msgString);
    }
}
