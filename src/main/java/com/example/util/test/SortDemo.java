/**
 * FileName: SortDemo
 * Author:   韩旭杰
 * Date:     2019/1/14 15:11
 * Description: list集合排序
 */
package com.example.util.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 说明：〈list集合排序〉
 * 比较集合的排序方法sort和stream
 *
 * @author 韩旭杰
 * @date 2019/1/14
 * @since 1.0.0
 */
public class SortDemo {
    public static void main(String[] args) {
        Person person1 = new Person("1", "韩旭杰", 20);
        Person person2 = new Person("2", "庞振兴", 50);
        Person person3 = new Person("3", "赵海智", 30);
        List<Person> list = new ArrayList<>();

        list.add(person2);
        list.add(person1);
        list.add(person3);
        List<Person> newList = listStreamSort(list);
        newList.stream().forEach(value -> {
            System.out.println(value.toString());
        });

//        listSort(list);
//        list.stream().forEach(value -> {
//            System.out.println(value.toString());
//        });
    }

    /**
     * 按照Person的年龄进行升序排列
     * 该方法直接修改的是原集合，没有生成新的集合
     *
     * @param list
     * @return
     */
    public static List<Person> listSort(List<Person> list) {
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                // 按照Person的年龄进行升序排列;  也可以通过compareTo进行比较
                if (p1.getAge() > p2.getAge()) {
                    return 1;
                }
                if (p1.getAge() == p2.getAge()) {
                    return 0;
                }
                return -1;
            }
        });
        return list;
    }

    /**
     * 根据Stream（）的sorted方法进行排列
     * 该方法将排序号的内容生成一个新的集合，原集合不变
     *
     * @param list
     * @return
     */
    public static List<Person> listStreamSort(List<Person> list) {
        List<Person> newList = list.stream().sorted((p1, p2) -> {
            // 从小到大排序
            // return s1.getId().compareTo(s2.getId());
            // 从大到小排序
            //return s2.getId().compareTo(s1.getId());
            // 按照Person的年龄进行升序排列
            if (p1.getAge() > p2.getAge()) {
                return 1;
            }
            if (p1.getAge() == p2.getAge()) {
                return 0;
            }
            return -1;
        }).collect(Collectors.toList());
        return newList;
    }
}
