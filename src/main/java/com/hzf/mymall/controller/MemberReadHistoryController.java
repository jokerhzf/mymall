package com.hzf.mymall.controller;

import com.hzf.mymall.common.CommonResult;
import com.hzf.mymall.domain.MemberReadHistory;
import com.hzf.mymall.service.MemberReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author：010980380
 * @date:2020-11-3
 * @verison:1.0.0
 * @description：会员浏览记录管理Controller
 */
@Api(tags = "MemberReadHistoryController",description = "会员浏览记录管理")
@Controller
@RequestMapping("member/readHistory")
public class MemberReadHistoryController {

    @Autowired
    private MemberReadHistoryService memberReadHistoryService;


    @ResponseBody
    @ApiOperation("创建浏览记录")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public CommonResult create(@RequestBody MemberReadHistory memberReadHistory){
        int count = memberReadHistoryService.create(memberReadHistory);
        if(count > 0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

    @ResponseBody
    @ApiOperation(value = "删除浏览记录",notes = "可以进行批量删除")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public CommonResult delete(@RequestParam("ids") List<String> ids){
        int count = memberReadHistoryService.delete(ids);
        if(count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ResponseBody
    @ApiOperation("查询浏览记录")
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public CommonResult list(Long memberId){
        List<MemberReadHistory> memberReadHistoryList = memberReadHistoryService.list(memberId);
        return CommonResult.success(memberReadHistoryList);
    }
}
