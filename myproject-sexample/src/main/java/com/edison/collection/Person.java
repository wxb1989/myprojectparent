package com.edison.collection;

import java.util.Arrays;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-17 14:14
 **/
public class Person implements  Comparable<Person> {

    private String name;
    private int age;



    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

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
    public int compareTo(Person o) {
        return this.getAge() - o.getAge();
    }

    public static void main(String[] args) {
        Person[] peoples = new Person[]{new Person("xujian", 20), new Person("xiewei", 10), new Person("xujian", 5)};
        System.out.println("排序前");

        for (Person person : peoples) {
            System.out.print(person.getName() + ":" + person.getAge());
        }

        Arrays.sort(peoples);
        System.out.println("排序后");
        for (Person person : peoples) {
            System.out.print(person.getName() + ":" + person.getAge());
        }

    }
}
