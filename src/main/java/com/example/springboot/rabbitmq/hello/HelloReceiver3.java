/**
 * FileName: HelloReceiver3
 * Author:   韩旭杰
 * Date:     2019/2/13 14:52
 * Description: 消费者3测试（用于测试实体列的传输）
 */
package com.example.springboot.rabbitmq.hello;

import com.example.springboot.rabbitmq.hello.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 说明：〈消费者3测试（用于测试实体列的传输）〉
 *
 * @author 韩旭杰
 * @date 2019/2/13
 * @since 1.0.0
 */
@Component
@RabbitListener(queues = "userQueue")
public class HelloReceiver3 {

    @RabbitHandler
    public void process(User user){
        System.out.println("user receive  : " + user.getName()+"/"+user.getPass());
    }
}
