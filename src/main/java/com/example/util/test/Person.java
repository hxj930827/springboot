/**
 * FileName: Person
 * Author:   韩旭杰
 * Date:     2019/1/14 15:11
 * Description:
 */
package com.example.util.test;

/**
 * 说明：〈〉
 *
 * @author 韩旭杰
 * @date 2019/1/14
 * @since 1.0.0
 */
public class Person {
    private String id;
    private String name;
    private int age;

    public Person(String id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
