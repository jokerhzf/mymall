package com.hzf.mymall.mapper;

import com.hzf.mymall.model.SmsFlashPromotion;
import com.hzf.mymall.model.SmsFlashPromotionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsFlashPromotionMapper {
    long countByExample(SmsFlashPromotionExample example);

    int deleteByExample(SmsFlashPromotionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsFlashPromotion record);

    int insertSelective(SmsFlashPromotion record);

    List<SmsFlashPromotion> selectByExample(SmsFlashPromotionExample example);

    SmsFlashPromotion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsFlashPromotion record, @Param("example") SmsFlashPromotionExample example);

    int updateByExample(@Param("record") SmsFlashPromotion record, @Param("example") SmsFlashPromotionExample example);

    int updateByPrimaryKeySelective(SmsFlashPromotion record);

    int updateByPrimaryKey(SmsFlashPromotion record);
}