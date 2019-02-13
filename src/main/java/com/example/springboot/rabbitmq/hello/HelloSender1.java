/**
 * FileName: HelloSender1
 * Author:   韩旭杰
 * Date:     2019/2/13 10:47
 * Description: 最简单的hello生产和消费实现（单生产者和单消费者）
 */
package com.example.springboot.rabbitmq.hello;

import com.example.springboot.rabbitmq.hello.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 说明：〈rabbit测试〉
 *
 * @author 韩旭杰
 * @date 2019/2/13
 * @since 1.0.0
 */
@Component
public class HelloSender1 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 用于单生产者-》单消费者测试
     */
    public void send() {
        String sendMsg = "hello1 " + new Date();
        System.out.println("Sender1 : " + sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }

    /**
     * 用于单/多生产者-》多消费者测试
     */
    public void send(String msg) {
        String sendMsg = msg + new Date();
        System.out.println("Sender1 : " + sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }

    /**
     * 实体类的传输（springboot完美的支持对象的发送和接收，不需要格外的配置。实体类必须序列化）
     * @param user
     */
    public void send(User user) {
        System.out.println("user send : " + user.getName()+"/"+user.getPass());
        this.rabbitTemplate.convertAndSend("userQueue", user);
    }
}
