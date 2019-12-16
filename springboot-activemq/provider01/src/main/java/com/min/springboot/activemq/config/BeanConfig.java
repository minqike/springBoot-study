package com.min.springboot.activemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class BeanConfig {
    //如果要使用topic类型的消息，则需要配置该bean
    @Bean("jmsTopicListenerContainerFactory")
    public JmsListenerContainerFactory jmsTopicListenerContainerFactory(
            ConnectionFactory connectionFactory
    ){
        DefaultJmsListenerContainerFactory factory
                = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true); //这里必须设置为true，false则表示是queue类型
        return factory;
    }

    //定义存放消息的队列
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("ActiveMQQueue");
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic("ActiveMQTopic");
    }

//    @Bean
//    ConnectionFactory connectionFactory() {
//        return new ActiveMQConnectionFactory();
//    }
//
//    @Bean
//    JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
//        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
//        jmsTemplate.setPriority(999);
//        return jmsTemplate;
//    }
//
//    @Bean(value="jmsMessagingTemplate")
//    JmsMessagingTemplate jmsMessagingTemplate(JmsTemplate jmsTemplate) {
//        JmsMessagingTemplate messagingTemplate = new JmsMessagingTemplate(jmsTemplate);
//        return messagingTemplate;
//    }

}
