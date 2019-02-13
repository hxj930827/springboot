/**
 * FileName: RabbitTest
 * Author:   韩旭杰
 * Date:     2019/2/13 10:51
 * Description: 最简单的hello生产和消费实现（单生产者和单消费者）
 */
package com.example.springboot.rabbitmq.controller;

import com.example.springboot.rabbitmq.fanout.FanoutSender;
import com.example.springboot.rabbitmq.hello.HelloSender1;
import com.example.springboot.rabbitmq.hello.model.User;
import com.example.springboot.rabbitmq.topic.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明：〈rabbit测试〉
 *
 * @author 韩旭杰
 * @date 2019/2/13
 * @since 1.0.0
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitTest {
    /**
     * 为了方便了解，所以每个对象写了一个，实际上前三个对象可以写成一个
     */
    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private HelloSender1 helloSender2;
    @Autowired
    private HelloSender1 userSender;
    @Autowired
    private TopicSender topicSender;
    @Autowired
    private FanoutSender fanoutSender;

    /**
     * 最简单的hello生产和消费实现（单生产者和单消费者）
     */
    @RequestMapping("/hello")
    public void hello() {
        helloSender1.send();
    }

    /**
     * 单生产者-多消费者
     */
    @RequestMapping("/oneToMany")
    public void oneToMany() {
        for(int i=0;i<10;i++){
            helloSender1.send("hellomsg:"+i);
        }
    }

    /**
     * 多生产者-多消费者
     */
    @RequestMapping("/manyToMany")
    public void manyToMany() {
        for(int i=0;i<10;i++){
            helloSender1.send("hellomsg:"+i);
            helloSender2.send("hellomsg:"+i);
        }
    }

    /**
     * 实体列的传输
     */
    @RequestMapping("/userTest")
    public void userTest(){
        User user=new User();
        user.setName("韩旭杰");
        user.setPass("123456");
        userSender.send(user);
    }

    /**
     * topic exchange类型rabbitmq测试
     */
    @RequestMapping("/topicTest")
    public void topicTest() {
        topicSender.send();
    }

    /**
     * fanout exchange类型rabbitmq测试
     */
    @RequestMapping("/fanoutTest")
    public void fanoutTest() {
        fanoutSender.send();
    }
}
