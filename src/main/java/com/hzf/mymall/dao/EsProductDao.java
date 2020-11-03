package com.hzf.mymall.dao;

import com.hzf.mymall.domain.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author：010980380
 * @date:2020-11-2
 * @verison:1.0.0
 * @description：搜索系统中的商品管理自定义Dao
 */

public interface EsProductDao {
    /**
     * 获取指定ID的搜索商品
     * @param id
     * @return
     */
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
