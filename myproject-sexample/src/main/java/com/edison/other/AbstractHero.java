package com.edison.other;

/**
 * @author ${Administrator}
 * @package com.wangxuebing.other
 * @description
 * @create 2018-11-07 11:47
 **/
public abstract class AbstractHero {

    protected final String name;//名字
    protected final String heroAttributes;//属性
    protected String[] skills = new String[4];//技能


    public AbstractHero() {
        super();
        this.name = getName();
        initSkills();
        this.heroAttributes = initAttributes();
    }

    //物理攻击
    public void commonAttack() {
        System.out.println(name + "进行物理攻击");
    }

    //
    protected  void checkSkills() {
        if (this.skills.length > 4 || this.skills.length < 0) {
            throw new IllegalArgumentException();
        }
        for (String skill : this.skills) {
            if (skill == null) {
                throw new NullPointerException();
            }
        }

    }

    protected void release(int index) {
        if (index < 0 || index > 3) {

        }
        System.out.println(name + "释放" + skills[index]);
    }

    protected abstract String getName();

    protected abstract void initSkills();

    protected abstract String initAttributes();
}
