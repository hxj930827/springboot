/**
 * FileName: SendMessage
 * Author:   韩旭杰
 * Date:     2019/2/14 16:39
 * Description:
 */
package com.example.springboot.rabbitmq.service.serviceimp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 说明：〈〉
 *
 * @author 韩旭杰
 * @date 2019/2/14
 * @since 1.0.0
 */
@Service
public class SendMessage1 {
    private static Logger log = LoggerFactory.getLogger(SendMessage1.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void sendMessage(String exchange,String routekey,Object message) {
        //构建回调返回的数据
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        //rabbitTemplate.convertAndSend(Constants.SAVE_USER_EXCHANGE_NAME, Constants.SAVE_USER_QUEUE_ROUTE_KEY, message, correlationData);
        rabbitTemplate.convertAndSend(exchange, routekey, message, correlationData);
        log.info("SendMessage() >>> 发送消息到RabbitMQ, 消息内容: " + message);
    }
}
