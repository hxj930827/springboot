package com.example.springboot.city.student.dao;
import com.example.springboot.city.student.model.Student;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface StudentDao {
    //public void addStrudent(Student student);

    public List<Student> getInfo();
}
