/**
 * FileName: ResourceModel
 * Author:   韩旭杰
 * Date:     2018/10/30 23:31
 * Description: 配置资源变量
 */
package com.example.springboot.resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 说明：〈配置资源变量〉
 * 必须配置spring-boot-configuration-processor依赖
 *
 * @author 韩旭杰
 * @create 2018/10/30
 * @since 1.0.0
 */
@Configuration
@ConfigurationProperties(prefix="com.springboot.opensource")
@PropertySource(value = "classpath:resource.properties")
public class ResourceModel {
    private String name;
    private String webSite;
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "ResourceModel{" +
                "name='" + name + '\'' +
                ", webSite='" + webSite + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
