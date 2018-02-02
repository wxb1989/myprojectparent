package com.wangxuebing.base;

/**
 * @author ${Administrator}
 * @description String的一些操作api
 * @create 2018-02-01 16:53
 **/
public class StringDemo {

    /*

    1．字符串常量
　　字符串常量是用双引号括住的一串字符。
　　　　"Hello World!"
　2．String 表示字符串常量
　　用String表示字符串：
　　String( char chars[ ] );
　　String( char chars[ ], int startIndex, int numChars );
　　String( byte ascii[ ], int hiByte );
　　String( byte ascii[ ], int hiByte, int startIndex, int numChars );
　　String 使用示例：
　　String s=new String() ; 生成一个空串
　　下面用不同方法生成字符串"abc"：
　　char chars1[]={'a','b','c'};
　　char chars2[]={'a','b','c','d','e'};
　　String s1=new String(chars1);
　　String s2=new String(chars2,0,3);
　　byte ascii1[]={97,98,99};
　　byte ascii2[]={97,98,99,100,101};
　　String s3=new String(ascii1,0);
　　String s4=new String(ascii2,0,0,3);
　3．用 StringBuffer 表示字符串
　　StringBuffer( ); /*分配16个字符的缓冲区
　　StringBuffer( int len ); 分配 len 个字符的缓冲区
　　StringBuffer( String s ); 除了按照s的大小分配空间外,再分配16个字符的缓冲区



*/

    /**
     *
      ◇ public int length() 此方法返回字符串的字符个数
     　　◇ public char charAt(int index) 此方法返回字符串中 index 位置上的字符，其中index 值的 范围是 0~length-1
     　　◇ public int indexOf(int ch)
     　　 　public lastIndexOf(in ch)
            返回字符 ch 在字符串中出现的第一个和最后一个的位置
     　　◇ public int indexOf(String str)
     　　　 public int lastIndexOf(String str)
     　　返回子串 str 中第一个字符在字符串中出现的第一个和最后一个的位置
     　　◇ public int indexOf(int ch,int fromIndex)
     　　　 public lastIndexOf(in ch ,int fromIndex)
     　　返回字符 ch 在字符串中位置 fromIndex 以后出现的第一个和最后一个的位置
     　　◇ public int indexOf(String str,int fromIndex)
     　　　 public int lastIndexOf(String str,int fromIndex)
     　　返回子串 str 中的第一个字符在字符串中位置 fromIndex 后出现的第一个和最后一个的位置。
     　　◇ public void getchars(int srcbegin,int end ,char buf[],int dstbegin)
     　　 srcbegin 为要提取的第一个字符在源串中的位置， end 为要提取的最后一个字符在源串中的位置，
        字符数组 buf[]存放目的字符串，　　
     　 dstbegin 为提取的字符串在目的串中的起始位置。
     　　◇public void getBytes(int srcBegin, int srcEnd,byte[] dst, int dstBegin)
     　　参数及用法同上，只是串中的字符均用8位表示。

     */



    public static void main(String[] args) {
        String ab="aaasdfacxvagafdad";
        char[] c=new char[ab.length()];
        ab.getChars(0,ab.length(),c,0);
        System.out.println(ab);
        for (char c1 : c) {
            System.out.print(c1);
        }
    }
}
