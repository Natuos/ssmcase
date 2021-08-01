package com.wuzhao.service;

import com.wuzhao.domain.Student;

import java.util.List;

/**
 * Created with IDEA
 * auther:Natuos
 * Date:2021/7/23
 * Time:18:02
 */


public interface StudentService {
    int addStudent(Student student);
    List<Student> findStudents();
}
