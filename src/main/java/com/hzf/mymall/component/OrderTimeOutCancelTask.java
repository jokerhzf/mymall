package com.hzf.mymall.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author：010980380
 * @date:2020-10-30
 * @verison:1.0.0
 * @description：订单超时取消并解锁库存的定时器
 */
@Component
public class OrderTimeOutCancelTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);
    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * 每10分钟扫描一次，扫描设定超时时间之前下的订单，如果没支付则取消该订单
     * @author huangzifan
     * @since 2020-10-30 14:27
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder() {
        // TODO: 2019/5/3 此处应调用取消订单的方法，具体查看mall项目源码
        LOGGER.info("取消订单，并根据sku编号释放锁定库存");
    }
}
