package com.wuzhao.dao;

import com.wuzhao.domain.Student;

import java.util.List;

/**
 * Created with IDEA
 * auther:Natuos
 * Date:2021/7/23
 * Time:17:39
 */


public interface StudentDao {
    int insertStudent(Student student);
    List<Student> selectStudents();
}
