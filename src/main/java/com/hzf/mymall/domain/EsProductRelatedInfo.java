package com.hzf.mymall.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author：010980380
 * @date:2020-11-2
 * @verison:1.0.0
 * @description：
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EsProductRelatedInfo {
    private List<String> brandNames;
    private List<String> productCategoryNames;
    private List<ProductAttr> productAttrs;

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class ProductAttr {
        private Long attrId;
        private String attrName;
        private List<String> attrValues;
    }
}
