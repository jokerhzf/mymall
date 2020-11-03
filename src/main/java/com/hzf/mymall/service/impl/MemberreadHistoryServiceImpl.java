package com.hzf.mymall.service.impl;

import com.hzf.mymall.domain.MemberReadHistory;
import com.hzf.mymall.repository.MemberReadHistoryRepository;
import com.hzf.mymall.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author：010980380
 * @date:2020-11-3
 * @verison:1.0.0
 * @description：会员浏览记录管理Service
 */
@Service
public class MemberreadHistoryServiceImpl implements MemberReadHistoryService {

    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;


    @Override
    public int create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberReadHistory);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> deleteList = new ArrayList<>();
        for (String id:
             ids) {
            MemberReadHistory memberReadHistory = new MemberReadHistory();
            memberReadHistory.setId(id);
            deleteList.add(memberReadHistory);
        }
        memberReadHistoryRepository.deleteAll(deleteList);
        return ids.size();
    }

    @Override
    public List<MemberReadHistory> list(Long memberId) {
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}
