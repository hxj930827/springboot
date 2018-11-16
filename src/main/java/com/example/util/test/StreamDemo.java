/**
 * FileName: StreamDemo
 * Author:   韩旭杰
 * Date:     2018/10/24 11:03
 * Description: 练习stream
 */
package com.example.util.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 说明：〈练习stream〉
 *
 * @author 韩旭杰
 * @create 2018/10/24
 * @since 1.0.0
 */
public class StreamDemo {
    public static void main(String[] args) {
        filter();
    }

    public static void getLimit(){
        List<Integer> list=Arrays.asList(0,1,2,3,4,5);
        Stream<Integer> stream=null;
        // 获取前两个集合 0，1
        // stream=list.stream().limit(2);
        // 跳过前两个集合
        stream=list.stream().skip(2);
        List<Integer> resultList=stream.collect(Collectors.toList());
        resultList.forEach(System.out::println);
    }
    // 求最大值最小值
    public static void maxAndMin() {
        List<Integer> list = Arrays.asList(0, 1, 2, 3);
        Comparator<Integer> comparator = (o1, o2) -> o1.compareTo(o2);
        System.out.println(list.stream().min(comparator).get());
        System.out.println(list.stream().max(comparator).get());
    }

    // filter 方法的作用是过滤 Stream 中的元素，filter 方法是一个高阶函数，
    // 接收一个函数接口作为参数，此高阶函数返回一个 boolean 值，返回 true 的元素会保留下来；
    // 高阶函数：接收或返回一个函数接口的函数称为高阶函数。
    // 函数接口：只包含一个函数的接口成为函数接口。
    public static void filter() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        Stream<Integer> stream = list.stream().filter((value) -> {
//            if (value > 2) {
//                return false;
//            } else {
//                return true;
//            }
//        });
        Stream<Integer> stream = list.stream().filter(Test::getFlat);
        List<Integer> result = stream.collect(Collectors.toList());
        result.forEach(System.out::println);
    }
    public static boolean getFlat(int a){
        if(a>2){
            return false;
        }else{
            return true;
        }
    }

    // map 函数的作用是将流中的一个值转换成一个新的值，举个例子，我们要将一个 List 转换成 List ，那么就可以使用 map 方法
    public static void map() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<String> result = list.stream().map((value) -> {
            if(value>2){
                return String.valueOf(value);
            }else{
                return String.valueOf(value);
            }

        }).collect(Collectors.toList());
//        Stream stream=list.stream().map(value->{
//           return String.valueOf(value);
//        });
        result.forEach(System.out::print);
    }

    // 从一组值中生成一个新的值，reduce 函数其实用途非常广泛，作用也比较大
    public static void reduce() {
        List<Integer> list = Arrays.asList(0, 1, 2, 3);
        Stream<Integer> stream = list.stream();
        // reduce 函数的一个参数为循环的初始值，这里计算累加时初始值为 0，acc 代表已经计算的结果，item 表示循环的每个元素。
        int sum = stream.reduce(0, (acc, item) -> acc + item).intValue();
        System.out.println(sum);
    }
}
