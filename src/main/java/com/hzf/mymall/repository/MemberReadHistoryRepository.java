package com.hzf.mymall.repository;

import com.hzf.mymall.domain.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author：010980380
 * @date:2020-11-3
 * @verison:1.0.0
 * @description：会员浏览历史记录MongDB操作类
 */

public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {


    /**
     * 根据会员id按时间倒序获取浏览记录
     * @param memberId
     * @return List<MemberReadHistory>
     * @author huangzifan
     * @since 2020-11-3 9:35
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);

}
