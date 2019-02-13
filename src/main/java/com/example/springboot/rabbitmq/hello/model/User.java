/**
 * FileName: User
 * Author:   韩旭杰
 * Date:     2019/2/13 14:43
 * Description: 创建一个实体列，用于rabbit实体类的传输
 */
package com.example.springboot.rabbitmq.hello.model;

import java.io.Serializable;

/**
 * 说明：〈创建一个实体列，用于rabbit实体类的传输〉
 * springboot完美的支持对象的发送和接收，不需要格外的配置。
 * 实体类（必须实现序列化接口）：
 *
 * @author 韩旭杰
 * @date 2019/2/13
 * @since 1.0.0
 */
public class User implements Serializable {
    private String name;
    private String pass;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
