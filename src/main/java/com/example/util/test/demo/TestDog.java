/**
 * FileName: Dog
 * Author:   韩旭杰
 * Date:     2019/2/18 14:45
 * Description:
 */
package com.example.util.test.demo;

/**
 * 说明：〈〉
 *
 * @author 韩旭杰
 * @date 2019/2/18
 * @since 1.0.0
 */
class Animal{

    public void move(){
        System.out.println("动物可以移动");
    }
}

class Dog extends Animal{

    @Override
    public void move(){
        System.out.println("狗可以跑和走");
    }
}

public class TestDog{

    public static void main(String args[]){
        Animal a = new Animal(); // Animal 对象
        Animal b = new Dog(); // Dog 对象

        a.move();// 执行 Animal 类的方法

        b.move();//执行 Dog 类的方法
    }
}
