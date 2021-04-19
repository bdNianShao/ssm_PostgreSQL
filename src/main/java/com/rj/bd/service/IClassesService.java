package com.rj.bd.service;
/**
* @desc 教室的Service
* 
* @author TianShuo
* 
* @version 2021年4月19日 下午2:34:34
*/

import java.util.List;

import com.rj.bd.entity.Classes;

public interface IClassesService {
	// 查询全部
	public List<Classes> queryAll();

	// 查询一条
	public Classes queryOne(Classes classes);

	// 修改
	public void edit(Classes classes);

	// 添加
	public void add(Classes classes);

	// 删除
	public void delete(Classes classes);

}
