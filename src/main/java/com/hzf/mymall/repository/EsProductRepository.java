package com.hzf.mymall.repository;

import com.hzf.mymall.domain.EsProduct;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author：010980380
 * @date:2020-11-2
 * @verison:1.0.0
 * @description：商品ES操作类
 */

public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {
    /**
     * 搜索查询
     * @param name 商品名称
     * @param subTitle 商品标题
     * @param keywords 商品关键字
     * @param page  分页信息
     * @return Page<EsProduct>
     * @author huangzifan
     * @since 2020-11-2 8:48
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page);
}
