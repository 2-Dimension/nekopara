package com.zml.nekopara.service;

import javax.jms.Destination;

public interface ISendMessageService {

	void sendMessage(Destination destination, final String message);
}
