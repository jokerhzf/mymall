package com.hzf.mymall.service;

import com.hzf.mymall.common.CommonResult;
import com.hzf.mymall.domain.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author：010980380
 * @date:2020-11-3
 * @verison:1.0.0
 * @description：前台订单管理Service
 */

public interface OmsPortalOrderService {
    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}
