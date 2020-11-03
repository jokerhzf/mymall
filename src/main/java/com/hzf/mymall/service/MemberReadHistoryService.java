package com.hzf.mymall.service;

import com.hzf.mymall.domain.MemberReadHistory;

import java.util.List;

/**
 * @author：010980380
 * @date:2020-11-3
 * @verison:1.0.0
 * @description：会员浏览记录管理Service
 */

public interface MemberReadHistoryService {

    /**
     * 创建浏览记录
     * @param memberReadHistory
     * @return int
     * @author huangzifan
     * @since 2020-11-3 9:38
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     * @param id
     * @return int
     * @author huangzifan
     * @since 2020-11-3 9:39
     */
    int delete(List<String> id);

    /**
     * 获取用户浏览记录
     * @param memberId
     * @return java.util.List<com.hzf.mymall.domain.MemberReadHistory>
     * @author huangzifan
     * @since 2020-11-3 9:39
     */
    List<MemberReadHistory> list(Long memberId);


}
