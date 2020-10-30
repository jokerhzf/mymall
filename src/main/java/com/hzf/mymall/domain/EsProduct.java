package com.hzf.mymall.domain;

import java.io.Serializable;

/**
 * @author：010980380
 * @date:2020-10-30
 * @verison:1.0.0
 * @description：
 */
@Document(indexName = "pms", type = "product",shards = 1,replicas = 0)
public class EsProduct implements Serializable {


}
