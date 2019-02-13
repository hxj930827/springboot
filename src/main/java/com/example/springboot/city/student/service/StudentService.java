/**
 * FileName: StudentService
 * Author:   韩旭杰
 * Date:     2018/11/14 10:26
 * Description: 学生service层
 */
package com.example.springboot.city.student.service;

import com.example.springboot.city.student.dao.StudentDao;
import com.example.springboot.city.student.model.Student;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author 韩旭杰
 * @date 2018/11/14
 * @since 1.0.0
 */
@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;
//    public void addStudent(Student student){
//        studentDao.addStrudent(student);
//    }

    public PageInfo<Student> getInfo(){
        // 分页插件
        Page<Student> pager = PageHelper.startPage(2, 1);
        // 查询数据并生成集合
        List<Student> list = studentDao.getInfo();
        // 将集合信息保存到pageInfo中
        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        return pageInfo;
    }

}
