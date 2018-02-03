package com.wangxuebing.io;

import java.io.*;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2018-02-03 10:28
 **/
public class IpunDemo {


    public static void main(String[] args) {
       /* try {
            //为了确保文件一定在之前是存在的，将字符串路径封装成File对象

            File file = new File("G:/git/myprojectparent/myproject-sexample/src/main/java/com/wangxuebing/base/javaio.md");
            if (!file.exists()) {
                throw new RuntimeException("要读取的文件不存在");
            }
            InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = new FileOutputStream(new File("G:/git/myprojectparent/myproject-sexample/src/main/java/com/wangxuebing/base/javaio3.md"));
            //1.
           int by = 0;
            while ((by = inputStream.read()) != -1) {
                outputStream.write(by);
            }


            int len = 0;
            byte[] buf = new byte[1024];
            while((len=inputStream.read(buf))!=-1){
                outputStream.write(buf,0,len);
            }

            outputStream.flush();
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
