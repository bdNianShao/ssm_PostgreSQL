package com.rj.bd.service;

import java.util.List;

import com.rj.bd.entity.Student;

/**
 * @desc 学生模块的Service接口
 * 
 * @author TianShuo
 * 
 * @version 2021年4月19日 上午8:20:56
 */
public interface IStudentService {
	// 查询全部
	public List<Student> all();

	// 通过主键查询一条
	public Student one(Student student);

	// 修改
	public void edit(Student student);

	// 添加
	public void add(Student student);

	// 删除
	public void delete(Student student);

}
