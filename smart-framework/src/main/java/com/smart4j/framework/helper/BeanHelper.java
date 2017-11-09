package com.smart4j.framework.helper;

import com.smart4j.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bean 助手类
 */
public final class BeanHelper {

    /**
     * 定义 Bean 映射（用于存放 Bean 类与 Bean 实例的映射关系）
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object instance = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, instance);
        }
    }

    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> tClass) {
        if (!BEAN_MAP.containsKey(tClass)) {
            throw new RuntimeException("can not get bean by class" + tClass);
        }
        return (T) BEAN_MAP.get(tClass);
    }


}
