package com.wangxuebing.annotation;


@Description(name={"trang","wang","bing"},age = 29,kind = PeopleKind.WHITE)
public class People {

    private String name;

    private int age;

    @Description(name = {"TANG","SHENG","BO"}, age = 18)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
