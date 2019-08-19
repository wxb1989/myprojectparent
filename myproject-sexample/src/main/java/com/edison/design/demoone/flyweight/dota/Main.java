package com.edison.design.demoone.flyweight.dota;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-06 15:41
 **/
public class Main {

    public static void main(String[] args) {
        HeroManager heroManager =HeroManager.getInstance();
        Role role1 = new Role(heroManager.getHero("恶魔巫师"));
        Role role2 = new Role(heroManager.getHero("影魔"));

        Role role3 = new Role(heroManager.getHero("恶魔巫师"));
        Role role4 = new Role(heroManager.getHero("混顿骑士"));


        System.out.println(role1);
        System.out.println(role3);
    }
}
