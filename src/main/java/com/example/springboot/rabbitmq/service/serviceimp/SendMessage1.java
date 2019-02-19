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
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
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

    public void sendMessage(String exchange, String routekey, Object message) {
//        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
//            @Override
//            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//                if(ack){
//                    log.info("消息发送成功:correlationData({}),ack({}),cause({})",correlationData,ack,cause);
//                }else{
//                    log.info("消息发送失败:correlationData({}),ack({}),cause({})",correlationData,ack,cause);
//                }
//            }
//        });
//        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
//            @Override
//            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
//                log.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}",exchange,routingKey,replyCode,replyText,message);
//            }
//        });
        //构建回调返回的数据
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        //rabbitTemplate.convertAndSend(Constants.SAVE_USER_EXCHANGE_NAME, Constants.SAVE_USER_QUEUE_ROUTE_KEY, message, correlationData);
        //rabbitTemplate.convertAndSend(exchange, routekey, message, correlationData);

        // 将 CorrelationData的id 与 Message的correlationId绑定，然后关系保存起来,例如放到缓存中,然后人工处理
        // 当confirm或return回调时,根据ack类别等,分别处理. 例如return或者ack=false则说明有问题,报警, 如果ack=true则删除关系
        // (因为return在confirm前,所以一条消息在return后又ack=true的情况也是按return处理)
        Message message1 = MessageBuilder.withBody(message.toString().getBytes()).setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN).setCorrelationId(correlationData.getId()).build();
        rabbitTemplate.send(exchange, routekey, message1, correlationData);
        log.info("SendMessage() >>> 发送消息到RabbitMQ, 消息内容: " + message);
    }
}
