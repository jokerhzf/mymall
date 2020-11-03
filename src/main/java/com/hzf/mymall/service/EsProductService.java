package com.hzf.mymall.service;

import com.hzf.mymall.domain.EsProduct;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author：010980380
 * @date:2020-11-2
 * @verison:1.0.0
 * @description：商品搜索管理Service
 */

public interface EsProductService {

    /**
     * 从数据库中导入所有商品到ES
     * @return
     */
    int importAll();

    /**
     * 根据id删除商品
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id创建商品
     * @param id
     * @return
     */
    EsProduct create(Long id);

    /**
     * 批量删除商品
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 根据关键字搜索名称或者副标题
     * @param keyword 关键字
     * @param pageNum 页码
     * @param pageSize 分页大小
     * @return
     */
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);
}
