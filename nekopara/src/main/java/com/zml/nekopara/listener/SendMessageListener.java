package com.zml.nekopara.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.zml.nekopara.model.Article;
import com.zml.nekopara.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
/**
 * 消息监听器
 * @author maylor
 *
 */
@Component
public class SendMessageListener implements MessageListener{

	@Autowired
	private IArticleService articleService;
	@Override
	public void onMessage(Message message) {
		   //这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换
        TextMessage textMsg = (TextMessage) message;
        try {
        	String objString=textMsg.getText();
            Article article = (Article)JSON.parseObject(objString, Article.class);
            article.setSystemMenu(null);
            articleService.save(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

}
