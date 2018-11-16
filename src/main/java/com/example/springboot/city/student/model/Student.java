/**
 * FileName: Student
 * Author:   韩旭杰
 * Date:     2018/11/14 9:39
 * Description: 学生测试类
 */
package com.example.springboot.city.student.model;

/**
 * 说明：〈学生测试类〉
 *
 * @author 韩旭杰
 * @create 2018/11/14
 * @since 1.0.0
 */
public class Student {
    private String id;
    private String name;
    private String attachmentName;
    private int age;

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

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", attachmentName='" + attachmentName + '\'' +
                ", age=" + age +
                '}';
    }
}
