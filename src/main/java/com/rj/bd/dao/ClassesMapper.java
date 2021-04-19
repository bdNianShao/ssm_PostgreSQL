package com.rj.bd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rj.bd.entity.Classes;

/**
 * @desc 教室的dao层
 * 
 * @author TianShuo
 * 
 * @version 2021年4月19日 上午11:13:02
 */
public interface ClassesMapper {
	/**
	 * 查询一条
	 * 
	 * @return
	 */
	@Select("select * from classes where c_id = #{c_id}")
	@Results({ @Result(column = "c_id", property = "c_id"), @Result(column = "c_name", property = "c_name") })
	Classes queryOneById(Classes classes);
	/**
	 * 查询全部
	 * 
	 * @return
	 */
	@Select("select * from classes")
	@Results({ @Result(column = "c_id", property = "c_id"), @Result(column = "c_name", property = "c_name") })
	List<Classes> queryAll();

	/**
	 * 修改
	 * 
	 * @param classes
	 */
	@Update("update classes set c_name = #{c_name} where c_id=#{c_id}")
	void edit(Classes classes);

	/**
	 * 添加
	 * 
	 * @param classes
	 */
	@Insert("INSERT INTO classes(c_id, c_name) VALUES (#{c_id},#{c_name});")
	void add(Classes classes);

	/**
	 * 删除
	 * 
	 * @param classes
	 */
	@Delete("Delete from classes where c_id = #{c_id}")
	void delete(Classes classes);
}
