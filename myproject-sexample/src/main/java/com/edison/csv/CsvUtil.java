package com.edison.csv;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-19 14:32
 **/
public class CsvUtil<T> {
    /**
     * 读取指定路径下的csv文件
     * @param path
     * @param cls
     * @param code
     * @return
     */
    public List<T> readCsv(String path, Class<T> cls,String code){
        List<T> objs = new ArrayList<T>();
        try {
            //生成CsvReader对象，以，为分隔符，GBK编码方式
            CsvReader r = new CsvReader(path, ',', Charset.forName(code));
            //读取表头
            r.readHeaders();
            //逐条读取记录，直至读完他
            List<CsvHeader> listHeader = getHeaderList(cls);
            while (r.readRecord()) {
                T obj = cls.newInstance();
                for(int i=0;i<listHeader.size();i++){
                    CsvHeader header = listHeader.get(i);
                    String value = r.get(header.getTitle());
                    if ("String".equals(header.getType())){
                        if(StringUtils.isNotBlank(value)){
                            value = value.substring(2,value.length()-1);
                        }
                    }
                    String field = header.getFieldName();
                    BeanUtils.copyProperty(obj,field, value);
                }
                objs.add(obj);
            }
            r.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return objs;
    }

    /**
     * 通过文件流读取文件
     * @param inputStream
     * @param cls
     * @param code
     * @return
     */
    public List<T> readCsvFromStream(InputStream inputStream, Class<T> cls, String code){
        List<T> objs = new ArrayList<T>();
        try {
            //生成CsvReader对象，以，为分隔符，GBK编码方式
            CsvReader r = new CsvReader(inputStream, ',', Charset.forName(code));
            //读取表头
            r.readHeaders();
            //逐条读取记录，直至读完他
            List<CsvHeader> listHeader = getHeaderList(cls);
            while (r.readRecord()) {
                T obj = cls.newInstance();
                for(int i=0;i<listHeader.size();i++){
                    CsvHeader header = listHeader.get(i);
                    String value = r.get(header.getTitle());
                    if ("String".equals(header.getType())){
                        if(StringUtils.isNotBlank(value)){
                            value = value.substring(2,value.length()-1);
                        }
                    }
                    String field = header.getFieldName();
                    BeanUtils.copyProperty(obj,field, value);
                }
                objs.add(obj);
            }
            r.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return objs;
    }

    private static List<CsvHeader> getHeaderList(Class clz) {
        List<CsvHeader> headers = new ArrayList<>();
        Method[] ms = clz.getDeclaredMethods();
        Field[] fs = clz.getDeclaredFields();
        for(Field f:fs) {
            try {
                String mn = f.getName();
                CsvResources er=null;
                if(f.isAnnotationPresent(CsvResources.class)) {
                    er = f.getAnnotation(CsvResources.class);
                }else{
                    String fieldName=mn.substring(3,4).toLowerCase()+mn.substring(4);
                    Field field=null;
                    try {
                        field = clz.getDeclaredField(fieldName);
                    } catch (Exception e) {
                        e.printStackTrace();
                        field = clz.getDeclaredField(mn.substring(3));
                    }
                    if(field!=null && field.isAnnotationPresent(CsvResources.class)){
                        er=field.getAnnotation(CsvResources.class);
                    }
                }
                if(er!=null) {
                    headers.add(new CsvHeader(er.title(), er.order(), mn, er.type()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return headers;
    }
}
