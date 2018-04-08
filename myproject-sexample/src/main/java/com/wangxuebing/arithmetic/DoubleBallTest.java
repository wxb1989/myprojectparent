package com.wangxuebing.arithmetic;

import java.util.*;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2018-04-04 16:10
 **/
public class DoubleBallTest {

    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        for (int j = 0; j < 10000 ; j++) {
            int[] red = new int[7];
            int blue = 0;
            for (int i = 0; i < 7; i = i + 1) {
                red[i] = getRandom(33);
                //判断重复
                while (true) {
                    boolean needcheck = false;
                    for (int k = 0; k < i; k = k + 1) {
                        if (red[i] == red[k]) {
                            needcheck = true;
                        }
                    }
                    if (needcheck) {
                        red[i] = red[i] + 1;
                        if (red[i] == 34) {
                            red[i] = 1;
                        }
                    } else {
                        break;
                    }
                }
                //判断重复结束
            }
            //红球赋值结束
            blue = getRandom(16);
            list.add( red[0]+"");
            list.add( red[1]+"");
            list.add( red[2]+"");
            list.add( red[3]+"");
            list.add( red[4]+"");
            list.add( red[5]+"");
            list.add( red[6]+"");
            list.add( blue+"");
        }
        count(list);

    }

    private static void count(List<String> list) {
        List<Integer> list_key = new ArrayList<Integer>();
        List<Integer> list_key_8 = new ArrayList<Integer>();
        IdentityHashMap map = new IdentityHashMap<String, String>();
        Collections.sort(list);
        /************************start***************************************/

        for(int i=0;i<list.size();i++) {
            String s= list.get(i);
            int begin = list.indexOf(s);
            int end = list.lastIndexOf(s);
            int key = end - begin + 1;// 计算每个值的数量

            boolean canadd = true;
            if(i>0){
                if(s.equals(list.get(i-1))){
                    canadd = false;
                }
            }
            if(canadd){
                list_key.add(key);
                map.put(String.valueOf(key), s);

            }
            //System.out.println("字母'"+ s + "'有:"+(end - begin + 1)+"个");
        }
        Collections.sort(list_key);
        if(list_key.size()>=8){
            for(int j=list_key.size()-1;j>list_key.size()-9;j--){
                list_key_8.add(list_key.get(j));
            }
        }
        int n = 0;
        for(int m=0;m<list_key_8.size();m++){
            int temp_key = list_key_8.get(m);
            if(m>0){
                if(list_key_8.equals(list_key_8.get(m-1))==false){
                    Set<Map.Entry<String, String>> allSet = map.entrySet();
                    Iterator<Map.Entry<String, String>> iter = allSet.iterator();
                    while (iter.hasNext()) {
                        Map.Entry<String, String> me = iter.next();// 每个对象都是Map.
                        String key = me.getKey();
                        if(key.equals(String.valueOf(temp_key))){
                            System.out.println(me.getKey()  + " --> " + me.getValue());
                            n++;
                            if(n==8){
                                break;
                            }
                        }
                    }
                }
            }
            if(n==8){
                break;
            }
            // 输出key和value
        }

    }

    public static int getRandom(int Max) {
        return (int) (Math.floor(Math.random() * 33) + 1);
    }
}
