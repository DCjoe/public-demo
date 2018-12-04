package com.fnl.caesar.sso.service.impl;

import com.fnl.caesar.sso.commons.utils.CacheHashCode;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.lang.Nullable;


/**
 * @ClassName CacheKeyConversionService
 * @Description TODO
 * @Author dengcheng
 * @Date 2018/12/4 0004 下午 14:05
 **/
public class CacheKeyConversionService implements ConversionService {
    @Override
    public boolean canConvert(@Nullable Class<?> aClass, Class<?> aClass1) {
        return true;
    }

    @Override
    public boolean canConvert(@Nullable TypeDescriptor typeDescriptor, TypeDescriptor typeDescriptor1) {
        return true;
    }

    @Nullable
    @Override
    public <T> T convert(@Nullable Object o, Class<T> aClass) {
        return (T) convert(o);
    }

    @Nullable
    @Override
    public Object convert(@Nullable Object o,@Nullable TypeDescriptor typeDescriptor, TypeDescriptor typeDescriptor1) {
        return convert(o);
    }

    private Object convert(Object source) {
        if (source instanceof CacheHashCode) {
            return ((CacheHashCode) source).hashString();
        }
        return CacheHashCode.of(source).hashString();
    }
}
