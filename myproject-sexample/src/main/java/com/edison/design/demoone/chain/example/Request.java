package com.edison.design.demoone.chain.example;

import java.util.Date;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-20 16:42
 **/
public class Request {

    private String type;

    private String content;

    private int num;

    private Date date;


    public Request() {

    }

    public Request(String type, String content, int num, Date date) {
        this.type = type;
        this.content = content;
        this.num = num;
        this.date = date;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
