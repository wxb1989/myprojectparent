package com.wangxuebing.design.flyweight.dota;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-06 15:14
 **/
public class Sf extends AbstractHero {
    @Override
    protected String getName() {
        return "影魔";
    }

    @Override
    protected void initSkills() {
        skills[0] = "毁灭阴影";
        skills[1] = "支配死灵";
        skills[2] = "魔王降临";
        skills[3] = "魂之挽歌";
    }

    @Override
    protected String initAttributes() {
        return "敏捷型英雄";
    }
}
