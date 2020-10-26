package com.hzf.mymall.service;

import com.hzf.mymall.model.PmsBrand;

import java.util.List;

/**
 * @author：010980380
 * @date:2020-10-26
 * @verison:1.0.0
 * @description：PmsBrand Service接口
 */

public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id,PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum,int pageSize);

    PmsBrand getBrand(Long id);

}
