package com.hzf.mymall.controller;

import com.hzf.mymall.domain.OrderParam;
import com.hzf.mymall.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author：010980380
 * @date:2020-11-3
 * @verison:1.0.0
 * @description：订单管理Controller
 */
@Api(tags = "OmsPortalOrderController",description = "订单管理")
@Controller
@RequestMapping("/order")
public class OmsPortalOrderController {
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @ApiOperation("根据购物车信息生成订单")
    @RequestMapping(value = "/generateOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object generateOrder(@RequestBody OrderParam orderParam){
        return portalOrderService.generateOrder(orderParam);
    }
}
