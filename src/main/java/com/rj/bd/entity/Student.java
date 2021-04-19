package com.rj.bd.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @desc 学生的实体类
* 
* @author TianShuo
* 
* @version 2021年4月18日 下午9:23:48
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	public String s_id;
	
	public String s_name;
	
	public Classes classes;
}
