package com.mvc;

public class TestMethod {
    public TestMethod() { ///xx/weblogic60b2_win.exe
        try {
            SiteInfoBean bean = new SiteInfoBean("http://localhost/xx/weblogic60b2_win.exe",
                    "d:\\temp", "weblogic60b2_win.exe", 5);
            SiteFileFetch fileFetch = new SiteFileFetch(bean);
            fileFetch.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TestMethod();
    }
}
