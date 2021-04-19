package com.rj.bd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rj.bd.dao.ClassesMapper;
import com.rj.bd.dao.StudentMapper;
import com.rj.bd.entity.Classes;

/**
 * @desc 教室模块Service的实现类
 * 
 * @author TianShuo
 * 
 * @version 2021年4月19日 下午2:35:48
 */

@Service
class ClassesServicempl implements IClassesService {
	@Autowired
	public ClassesMapper classesMapper;

	public List<Classes> queryAll() {
		return classesMapper.queryAll();
	}

	public Classes queryOne(Classes classes) {
		return classesMapper.queryOneById(classes);
	}

	public void edit(Classes classes) {
		classesMapper.edit(classes);

	}

	public void add(Classes classes) {
		classesMapper.add(classes);

	}

	public void delete(Classes classes) {
		classesMapper.delete(classes);

	}

}
