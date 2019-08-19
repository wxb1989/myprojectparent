package com.edison.design.demoone.flyweight.dota;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-06 15:13
 **/
public class Lion extends AbstractHero {

    @Override
    protected String getName() {
        return "恶魔巫师";
    }

    @Override
    protected void initSkills() {
        skills[0] = "穿刺";
        skills[1] = "妖术";
        skills[2] = "法力汲取";
        skills[3] = "死亡一指";
    }

    @Override
    protected String initAttributes() {
        return "智力型英雄";
    }
}
