/**
 * FileName: Demo1
 * Author:   韩旭杰
 * Date:     2019/1/24 11:21
 * Description: 判断Java 是值传递还是引用传递
 */
package com.example.util.test.demo;

import com.example.util.test.Person;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * 说明：〈判断Java 是值传递还是引用传递〉  java是值传递
 * 值传递是对基本型变量而言的,传递的是该变量的一个副本,改变副本不影响原变量。
 * 引用传递一般是对于对象型变量而言的,传递的是该对象地址的一个副本, 并不是原对象本身 。
 *
 * @author 韩旭杰
 * @date 2019/1/24
 * @since 1.0.0
 */
public class Demo1 {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        swap(a, b);
        System.out.println("a:" + a + "\nb:" + b);
        HashMap hm=new HashMap();
        Hashtable ht=new Hashtable();
        Person p = new Person("1", "hxj", 22);
        uptPerson(p);
        System.out.println(p.getAge());

        // 单独使用""引号创建的字符串都是直接量,编译期就已经确定存储到常量池中；
        //使用new String("")创建的对象会存储到堆内存中,是运行期才创建；
        //使用只包含直接量的字符串连接符如"aa" + "bb"创建的也是直接量编译期就能确定,已经确定存储到常量池中(str2和str3)；
        //使用包含String直接量(无final修饰符)的字符串表达式(如"aa" + s1)创建的对象是运行期才创建的,存储在堆中；
        //通过变量/调用方法去连接字符串,都只能在运行时期才能确定变量的值和方法的返回值,不存在编译优化操作.
        String str1="abcd";
        String str2=new String("abcd");
        String str3="ab"+"cd";
        System.out.println(str1==str2);
        System.out.println(str1==str3);
    }

    /**
     * 这就是因为 Java 是值传递的，也就是说，我们在调用一个需要传递参数的函数时，传递给函数的参数并不是我们传递进去的参数本身，
     * 而是它的一个副本，我们改变了数据其实只是改变了副本的数据而已，并不会对原来的参数有任何的改变。
     *
     * @param a
     * @param b
     */
    private static void swap(Integer a, Integer b) {
        Integer tem = a;
        a = b;
        b = tem;
    }

    /**
     * 你依然可以理解为，主函数将 person 复制了一份到 changeAge 函数中去，最终还是只改变了 changeAge 中复制的那一份参数的值，
     * 而原本的参数并没有改变，但 changeAge 中的那一份和原本的参数指向了同一个内存区域！
     *
     * @param p
     */
    private static void uptPerson(Person p) {
        p.setAge(10);
    }

}
