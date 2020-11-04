package com.hzf.mymall.service;

import com.hzf.mymall.dto.OssCallbackResult;
import com.hzf.mymall.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @author：010980380
 * @date:2020-11-4
 * @verison:1.0.0
 * @description：oss上传管理Service
 */
public interface OssService {
    /**
     * oss上传策略生成
     */
    OssPolicyResult policy();
    /**
     * oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
