package com.zml.nekopara.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.user5u.myweb.service.ISendMessageService;
@Component
public class SendMessageServiceImpl implements ISendMessageService{

	@Autowired
	private JmsTemplate jmsTemplate;
	@Override
	public void sendMessage(Destination destination, final String message) {
		System.out.println("---------------生产者发送消息-----------------");
        System.out.println("---------------生产者发了一个消息：" + message);
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
		
	}

}