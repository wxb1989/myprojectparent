package com.wangxuebing.design.flyweight.dota;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-06 15:21
 **/
public class Ck extends AbstractHero {
    @Override
    protected String getName() {
        return "混顿骑士";
    }

    @Override
    protected void initSkills() {
        skills[0] = "混乱之箭";
        skills[1] = "实相裂隙";
        skills[2] = "混沌一击";
        skills[3] = "混沌之军";
    }

    @Override
    protected String initAttributes() {
        return "力量型英雄";
    }
}
