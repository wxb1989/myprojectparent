package com.wangxuebing.design.flyweight.dota;

/**
 * @author ${Administrator}
 * @description 用于组合英雄内部状态和外部状态的类，假设称为角色
 *              之所以要有这个类是因为每个英雄都的血量和蓝量是不同的，
 *              不能抽象在英雄类里
 * @create 2017-11-06 15:29
 **/

public class Role {

    AbstractHero hero;

    //我们把血量和魔法量这两个外部状态从英雄里剥离出来，放到外部的角色类中
    private long hp;

    private long mp;

    public Role(AbstractHero hero) {
        this.hero = hero;

    }

    //释放技能
    public void release(int index){
        hero.release(index);
    }

    //物理攻击
    public void commonAttack(){
        hero.commonAttack();
    }
    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        this.hp = hp;
    }

    public long getMp() {
        return mp;
    }

    public void setMp(long mp) {
        this.mp = mp;
    }

}
