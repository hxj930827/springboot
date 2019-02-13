/**
 * FileName: RabbitTest
 * Author:   韩旭杰
 * Date:     2019/2/13 10:51
 * Description: 最简单的hello生产和消费实现（单生产者和单消费者）
 */
package com.example.springboot.rabbitmq.hello.controller;

import com.example.springboot.rabbitmq.hello.HelloSender1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明：〈最简单的hello生产和消费实现（单生产者和单消费者）〉
 *
 * @author 韩旭杰
 * @date 2019/2/13
 * @since 1.0.0
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private HelloSender1 helloSender2;

    @RequestMapping("/hello")
    public void hello() {
        helloSender1.send();
    }
}
