package com.hzf.mymall.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author：010980380
 * @date:2020-11-3
 * @verison:1.0.0
 * @description：用户商品浏览历史记录
 */
@Data
@Document
public class MemberReadHistory {
    @Id
    private String id;

    @Indexed
    private Long memberId;
    private String memberNickname;
    private String memberIcon;

    @Indexed
    private Long productId;
    private String productName;
    private String productPic;
    private String productSubTitle;
    private String productPrice;
    private Date createTime;

}
