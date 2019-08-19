package com.edison.collection;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ${Administrator}
 * @description ${DESCRIPTION}
 * @create 2017-10-17 14:29
 **/
public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge()-o2.getAge();
    }

    public static void main(String[] args) {
        List<Person> persons = Lists.newArrayList();
        persons.add(new Person("wangxj",112));
        persons.add(new Person("wsgxj",21));
        persons.add(new Person("wsaj",26));
        persons.add(new Person("waj",56));

        persons.remove(1);
        System.out.println("排序前");
        for (Person person : persons) {
            System.out.print(person.getName() + ":" + person.getAge());
        }

        Collections.sort(persons,new PersonComparator());

        System.out.println("------------------------------");
        System.out.println("排序后");
        for (Person person : persons) {
            System.out.print(person.getName() + ":" + person.getAge());
        }
    }
}
