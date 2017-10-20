package com.wangxuebing.csv;

/**
 * @author ${Administrator}
 * @description 用来存储Excel标题的对象，通过该对象可以获取标题和方法的对应关系
 * @create 2017-10-19 14:25
 **/
public class CsvHeader implements  Comparable<CsvHeader> {

    /**
     * excel的标题名称
     */
    private String title;
    /**
     * 每一个标题的顺序
     */
    private int order;
    /**
     * 说对应方法名称
     */
    private String fieldName;

    /**
     * 字段对应的类型
     */
    private String type;

    public CsvHeader(String title, int order, String fieldName,String type) {
        super();
        this.title = title;
        this.order = order;
        this.fieldName = fieldName;
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public int getOrder() {
        return order;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getType() {
        return type;
    }

    @Override
    public int compareTo(CsvHeader o) {
        return order>o.order?1:(order<o.order?-1:0);
    }
}
