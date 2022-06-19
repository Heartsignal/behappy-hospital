package org.xiaowu.behappy.hosp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xiaowu.behappy.common.rmq.contant.MqConst;

/**
 * 修改排班并且发送短信通知
 */
@Configuration
@RequiredArgsConstructor
public class MqConfiguration {

    /**
     * 交换机
     * @return
     */
    @Bean
    public Exchange exchange() {
        return new DirectExchange(MqConst.EXCHANGE_DIRECT_ORDER, true, false);
    }

    /**
     * 队列
     * @return
     */
    @Bean
    public Queue queue() {
        Queue queue = new Queue(MqConst.QUEUE_ORDER, true, false, false);
        return queue;
    }

    /**
     * binding,
     */
    @Bean
    public Binding binding() {
        return new Binding(MqConst.QUEUE_ORDER, Binding.DestinationType.QUEUE,
                MqConst.EXCHANGE_DIRECT_ORDER, MqConst.ROUTING_ORDER, null);
    }

}