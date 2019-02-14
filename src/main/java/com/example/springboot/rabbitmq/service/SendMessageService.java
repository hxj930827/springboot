package com.example.springboot.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * 说明：〈定义一个名为SendMessageService 的接口，这个接口继承了RabbitTemplate.ConfirmCallback，
 * ConfirmCallback接口是用来回调消息发送成功后的方法，当一个消息被成功写入到RabbitMQ服务端时，
 * 会自动的回调RabbitTemplate.ConfirmCallback接口内的confirm方法完成通知
 *
 * @author 韩旭杰
 * @date 2019/2/14
 * @since 1.0.0
 */

public interface SendMessageService extends RabbitTemplate.ConfirmCallback{
    void sendMessage(String exchange,String routekey,Object message);
}
