package com.edison.design.demoone.flyweight.dota;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-06 15:32
 **/
public class HeroManager {


    private Map<String, AbstractHero> heroMap;

    private HeroManager() {
        heroMap = new HashMap<String, AbstractHero>();
    }

    public static HeroManager getInstance() {
        return SingletonBuilder.singleton;
    }

    //该方法提供共享功能
    public AbstractHero getHero(String name){
        AbstractHero hero = null;

        if(!heroMap.containsKey(name)){
            if ("恶魔巫师".equals(name)) {
                hero = new Lion();
            }else if ("影魔".equals(name)) {
                hero = new Sf();
            }else if("混顿骑士".equals(name)){
                hero = new Ck();
            }
            heroMap.put(name, hero);
            System.out.println(name + "---建立对象， 并放置到池中");

        }else{
            hero=  heroMap.get(name);
            System.out.println(name + "---直接从池中取得");
        }

        return hero;
    }


    private static class SingletonBuilder {
        public static HeroManager singleton = new HeroManager();
    }
}
