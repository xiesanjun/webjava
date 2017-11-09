package com.smart4j.framework.helper;

import com.smart4j.framework.annotation.Inject;
import com.smart4j.framework.util.ArrayUtil;
import com.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手类
 */
public final class IocHelper {

    static {
        //获取所有的Bean类与Bean实例之间的映射关系（简称Bean Map）
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        for (Map.Entry<Class<?>, Object> bEntry : beanMap.entrySet()) {
            //从 BeanMap 中获取 Bean 类和 Bean 实例
            Class<?> key = bEntry.getKey();
            Object value = bEntry.getValue();
            //获取 Bean 类定义的所有成员变量（简称 Bean Field）
            Field[] keyDeclaredFields = key.getDeclaredFields();
            if (ArrayUtil.isNotEmpty(keyDeclaredFields)) {
                //遍历
                for (Field field : keyDeclaredFields) {
                    //判断当前 field 是否带有 Inject 注解
                    if (field.isAnnotationPresent(Inject.class)) {
                        //在 Bean Map 中获取Bean Field 对应的实例
                        Class<?> aClass = field.getType();
                        Object instance = beanMap.get(aClass);
                        if (instance != null) {
                            //通过反射初始化 filed 的值
                            ReflectionUtil.setField(value, field, instance);
                        }
                    }
                }
            }
        }
    }
}
