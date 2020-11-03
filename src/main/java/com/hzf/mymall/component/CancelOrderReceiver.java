package com.hzf.mymall.component;

import com.hzf.mymall.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author：010980380
 * @date:2020-11-3
 * @verison:1.0.0
 * @description：取消订单消息的处理者
 */
@Component
@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiver.class);

    @Autowired
    private OmsPortalOrderService portalOrderService;

    @RabbitHandler
    public void handle(Long orderId){
        LOGGER.info("receive delay message orderId:{}",orderId);
        portalOrderService.cancelOrder(orderId);
    }

}
