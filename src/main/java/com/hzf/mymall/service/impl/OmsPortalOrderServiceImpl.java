package com.hzf.mymall.service.impl;

import com.hzf.mymall.common.CommonResult;
import com.hzf.mymall.component.CancelOrderReceiver;
import com.hzf.mymall.component.CancelOrderSender;
import com.hzf.mymall.domain.OrderParam;
import com.hzf.mymall.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author：010980380
 * @date:2020-11-3
 * @verison:1.0.0
 * @description：前台订单管理Service实现类
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {

    private static Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);

    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        // TO-DO 执行一系列的下单操作
        LOGGER.info("process generateOrder");
        // 下单完成后开启一个延迟消息，用于当用户没有付款时取消订单（orderId应该在下单后生成）
        sendDelayMessageCancelOrder(11L);
        return CommonResult.success(null,"下单成功");
    }

    @Override
    public void cancelOrder(Long orderId) {
        // TO-DO 执行一系列取消订单操作
        LOGGER.info("process cancelOrder orderId:{}",orderId);
    }

    private void sendDelayMessageCancelOrder(Long orderId) {
        //获取订单超时时间，假设为60分钟
        long delayTimes = 30 * 1000;
        //发送延迟消息
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }
}
