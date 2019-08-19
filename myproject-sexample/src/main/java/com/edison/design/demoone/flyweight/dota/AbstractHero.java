package com.edison.design.demoone.flyweight.dota;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-11-06 15:05
 **/
public abstract class AbstractHero {

    protected final String name;//英雄名称

    protected final String[] skills = new String[4];//每个英雄都有四个技能


    protected final String heroAttributes;//属性

    public AbstractHero() {
        super();
        this.name=getName();
        initSkills();
        this.heroAttributes=initAttributes();
    }

    /**
     * 每个英雄只能有4个技能
     */
    protected void  checkSkills(){
        for (int i = 0; i < skills.length; i++) {
            if (skills[i] == null) {
                throw new NullPointerException();
            }
        }
    }

    /**
     * 释放技能
     * @param index
     */
    protected  void release(int index){
        if(index<0){
            index=0;
        }else if(index>3){
            index=3;
        }
        System.out.println(name + "释放" + skills[index]);
    }

    //物理攻击
    public void commonAttack(){
        System.out.println(name + "进行物理攻击");
    }

    protected abstract String getName();
    protected abstract void initSkills();
    protected abstract String initAttributes();

}
