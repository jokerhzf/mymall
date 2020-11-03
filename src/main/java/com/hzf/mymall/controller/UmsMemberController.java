package com.hzf.mymall.controller;

import com.hzf.mymall.common.CommonResult;
import com.hzf.mymall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author：010980380
 * @date:2020-10-27
 * @verison:1.0.0
 * @description：会员登录注册管理Controller
 */

@Api(tags = "UmsMemberController",description = "会员登录注册管理")
@Controller
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService memberService;


    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone){
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatepassword(@RequestParam String telephone,@RequestParam String authCode){
        return memberService.verifyAuthCode(telephone,authCode);
    }

}
