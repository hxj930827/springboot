/**
 * FileName: SendMessageServicelmpl
 * Author:   韩旭杰
 * Date:     2019/2/14 11:25
 * Description: 该类注入了RabbitTemplate，RabbitTemplate封装了发送消息的方法，我们直接使用即可。可以看到我们构建了一个回调返回的数据，并使用convertAndSend方法发送了消息。同时实现了confirm回调方法，通过判断isSendSuccess可以知道消息是否发送成功，这样我们就可以进行进一步处理。 ---------------------  作者：weixiaohuai  来源：CSDN  原文：https://blog.csdn.net/weixiaohuai/article/details/82790785  版权声明：本文为博主原创文章，转载请附上博文链接！
 */
package com.example.springboot.rabbitmq.service.serviceimp;

import com.example.springboot.rabbitmq.service.SendMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 说明：〈该类注入了RabbitTemplate，RabbitTemplate封装了发送消息的方法，我们直接使用即可。
 * 可以看到我们构建了一个回调返回的数据，并使用convertAndSend方法发送了消息。同时实现了confirm回调方法，
 * 通过判断isSendSuccess可以知道消息是否发送成功，这样我们就可以进行进一步处理。
 *
 * @author 韩旭杰
 * @date 2019/2/14
 * @since 1.0.0
 */
@Service
public class SendMessageServiceImpl implements SendMessageService{
    private static Logger logger = LoggerFactory.getLogger(SendMessageServiceImpl.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Override
    public void sendMessage(String exchange,String routekey,Object message) {
        //设置回调对象
        //rabbitTemplate.setConfirmCallback(this);
        //rabbitTemplate.setMandatory(true);
        //构建回调返回的数据
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        //rabbitTemplate.convertAndSend(Constants.SAVE_USER_EXCHANGE_NAME, Constants.SAVE_USER_QUEUE_ROUTE_KEY, message, correlationData);
        rabbitTemplate.convertAndSend(exchange, routekey, message, correlationData);
        logger.info("SendMessageServiceImpl() >>> 发送消息到RabbitMQ, 消息内容: " + message);
    }

    /**
     * 消息回调确认方法
     *
     * @param correlationData 回调数据
     * @param isSendSuccess   是否发送成功
     * @param
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean isSendSuccess, String s) {
        logger.info("confirm回调方法>>>>>>>>>>>>>回调消息ID为: " + correlationData.getId());
        if (isSendSuccess) {
            logger.info("confirm回调方法>>>>>>>>>>>>>消息发送成功");
        } else {
            logger.info("confirm回调方法>>>>>>>>>>>>>消息发送失败" + s);
        }
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {

    }
}
