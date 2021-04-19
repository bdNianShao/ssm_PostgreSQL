package com.rj.bd.service;
/**
* @desc 学生模块的Service接口的实现类
* 
* @author TianShuo
* 
* @version 2021年4月19日 上午8:20:20
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rj.bd.dao.StudentMapper;
import com.rj.bd.entity.Student;

@Service
public class StudentServicempl implements IStudentService {
	@Autowired
	private StudentMapper studentMapper;

	public List<Student> all() {
		System.out.println(studentMapper.queryAll());
		return studentMapper.queryAll();
	}

	public Student one(Student student) {
		return studentMapper.queryOne(student);
	}

	public void edit(Student student) {
		studentMapper.edit(student);
	}

	public void add(Student student) {
		studentMapper.add(student);
	}

	public void delete(Student student) {
		studentMapper.delete(student);
	}

}
