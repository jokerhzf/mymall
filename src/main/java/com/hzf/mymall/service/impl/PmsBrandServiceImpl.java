package com.hzf.mymall.service.impl;

import com.github.pagehelper.PageHelper;
import com.hzf.mymall.mapper.PmsBrandMapper;
import com.hzf.mymall.model.PmsBrand;
import com.hzf.mymall.model.PmsBrandExample;
import com.hzf.mymall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author：010980380
 * @date:2020-10-26
 * @verison:1.0.0
 * @description：PmsBrand 实现类
 */

public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id,PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}