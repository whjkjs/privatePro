package com.ipeercloud.com.model;

/**
 * @author 673391138@qq.com
 * @since 17/4/18
 * 主要功能:
 */

public class GsSimpleResponse extends GsResponse {
    public GsSimpleResponse(boolean result) {
        this.result = result;
    }

    public boolean result;
}
