package com.smart4j.framework.bean;

import com.smart4j.framework.util.CastUtil;

import java.util.Map;

/**
 * 请求参数对象
 */
public class Param {

    private Map<String, Object> paramap;

    public Param(Map<String, Object> paramap) {
        this.paramap = paramap;
    }

    /**
     * 根据参数名获取 long 型参数
     */
    public long getLong(String name) {
        return CastUtil.castLong(paramap.get(name));
    }

    /**
     * 根据参数名获取 int 型参数
     */
    public int getInt(String name) {
        return CastUtil.castInt(paramap.get(name));
    }

    /**
     * 根据参数名获取 String 型参数
     */
    public String getString(String name) {
        return CastUtil.castString(paramap.get(name));
    }

    /**
     * 根据参数名获取 double 型参数
     */
    public double getDouble(String name) {
        return CastUtil.castDouble(paramap.get(name));
    }

    /**
     * 根据参数名获取 boolean 型参数
     */
    public boolean getBoolean(String name) {
        return CastUtil.castBoolean(paramap.get(name));

    }

    /**
     * 获取所有字段信息
     */
    public Map<String, Object> getMap() {
        return paramap;
    }


}
