
package com.rj.bd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rj.bd.entity.Student;

/**
 * @desc 学生模块的dao
 * 
 * @author TianShuo
 * 
 * @version 2021年4月19日 上午8:17:41
 */
public interface StudentMapper {
	/**
	 * 查询全部
	 * 
	 * @return
	 */
	@Select("select * from student")
	@Results({ @Result(column = "s_id", property = "s_id"), @Result(column = "s_name", property = "s_name"),
			@Result(column = "c_id", property = "classes", one = @One(select = "com.rj.bd.dao.ClassesMapper.queryOneById")), })
	List<Student> queryAll();

	/**
	 * @desc 查询一条
	 * @param student
	 * @return
	 */
	@Select("select * from student where s_id = #{s_id}")
	@Results({ @Result(column = "s_id", property = "s_id"), @Result(column = "s_name", property = "s_name"),
			@Result(column = "c_id", property = "classes", one = @One(select = "com.rj.bd.dao.ClassesMapper.queryOneById")), })
	Student queryOne(Student student);

	/**
	 * 修改
	 * 
	 * @param student
	 */
	@Update("update student set s_name = #{s_name} , c_id = #{classes.c_id} where s_id=#{s_id}")
	void edit(Student student);

	/**
	 * 添加
	 * 
	 * @param student
	 */
	@Insert("INSERT INTO student(s_id, s_name, c_id) VALUES (#{s_id},#{s_name},#{classes.c_id});")
	void add(Student student);

	/**
	 * 删除
	 * 
	 * @param student
	 */
	@Delete("Delete from student where s_id = #{s_id}")
	void delete(Student student);
}
