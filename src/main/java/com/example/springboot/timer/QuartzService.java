/**
 * FileName: QuartzService
 * Author:   韩旭杰
 * Date:     2018/10/22 22:57
 * Description: 定时器测试
 */
package com.example.springboot.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 说明：〈定时器测试〉，开启定时器的类所在的包（项目名称一样的包），必须是它下级，否则定时器不执行
 * 必须在application类中配置@EnableScheduling ，该注解是 开启定时器
 *
 * @author 韩旭杰
 * @create 2018/10/22
 * @since 1.0.0
 */
@Component
public class QuartzService {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Scheduled(cron="*/5 * * * * ?")
    public void dateTask(){
        LOG.info("SchedulerTask1 : " + new Date().toString());
    }
}
