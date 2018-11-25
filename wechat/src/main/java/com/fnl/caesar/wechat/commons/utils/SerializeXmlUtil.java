package com.fnl.caesar.wechat.commons.utils;

import com.fnl.caesar.wechat.commons.annotations.XStreamCDATA;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

import java.io.Writer;
import java.lang.reflect.Field;

/**
 * @Author dengcheng
 * @Date 2018/11/20
 **/
public class SerializeXmlUtil {
    public static XStream createXstream() {
        return new XStream(new XppDriver() {
            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out) {
                    boolean cdata = false;
                    Class<?> targetClass = null;
                    @Override
                    public void startNode(String name,
                                          @SuppressWarnings("rawtypes") Class clazz) {
                        super.startNode(name, clazz);
                        //业务处理，对于用XStreamCDATA标记的Field，需要加上CDATA标签
                        if(!name.equals("xml")){
                            cdata = needCDATA(targetClass, name);
                        }else{
                            targetClass = clazz;
                        }
                    }

                    @Override
                    protected void writeText(QuickWriter writer, String text) {
                        if (cdata) {
                            writer.write("<![CDATA[");
                            writer.write(text);
                            writer.write("]]>");
                        } else {
                            writer.write(text);
                        }
                    }
                };
            }
        });
    }
    private static boolean needCDATA(Class<?> targetClass, String fieldAlias){
        boolean cdata = false;
        //首先,判断自己的属性是否存在XStreamCDATA标签
        cdata = existsCDATA(targetClass, fieldAlias);
        if(cdata){return cdata;}
        //如果cdata为false, 则遍历所有的父类直到java.lang.Object
        Class<?> superClass = targetClass.getSuperclass();
        while(!superClass.equals(Object.class)){
            cdata = existsCDATA(superClass, fieldAlias);
            if(cdata){
                return cdata;
            }
            superClass = superClass.getClass().getSuperclass();
        }
        return false;
    }
    private static boolean existsCDATA(Class<?> clazz, String fieldAlias){
        //反射获取所有属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //1.存在标有XStreamCDATA标签的field
            if(field.getAnnotation(XStreamCDATA.class) != null ){
                XStreamAlias xStreamAlias = field.getAnnotation(XStreamAlias.class);
                //2.存在XStreamAlias属性
                if(null != xStreamAlias){
                    if(fieldAlias.equals(xStreamAlias.value())){
                        return true;
                    }
                }else{//不存在XStreamAlias
                    if(fieldAlias.equals(field.getName())){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
