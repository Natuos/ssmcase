package com.wuzhao.service.impl;

import com.wuzhao.dao.StudentDao;
import com.wuzhao.domain.Student;
import com.wuzhao.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IDEA
 * auther:Natuos
 * Date:2021/7/23
 * Time:18:04
 */

@Service
public class StudentServiceImpl implements StudentService {
    //引用类型自动注入@Autowired,@Resource
    @Resource
    private StudentDao studentDao;
    @Override
    public int addStudent(Student student) {
        int nums = studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> findStudents() {
        return studentDao.selectStudents();
    }
}
