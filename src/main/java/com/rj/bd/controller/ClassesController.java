package com.rj.bd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rj.bd.entity.Classes;
import com.rj.bd.service.IClassesService;

/**
 * @desc 教室的c层
 * 
 * @author TianShuo
 * 
 * @version 2021年4月19日 下午2:38:00
 */

@RequestMapping("/classes")
@Controller
public class ClassesController {
	@Autowired
	private IClassesService classesService;

	/**
	 * @desc 查询全部
	 * @return
	 */
	@RequestMapping("query")
	@ResponseBody
	public List<Classes> queryAll() {
		System.out.println("查询全部");
		return classesService.queryAll();
	}

	/**
	 * @desc 查询一条
	 * @param classes
	 * @return
	 */
	@RequestMapping("toedit")
	@ResponseBody
	public Classes queryOne(Classes classes) {
		System.out.println("查询一条");
		return classesService.queryOne(classes);
	}

	/**
	 * @desc 修改
	 * @param student
	 * @return
	 */
	@SuppressWarnings("finally")
	@RequestMapping("edit")
	@ResponseBody

	public Map<String, Object> edit(Classes classes) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			classesService.edit(classes);
			map.put("msc", 200);
			map.put("text", "修改成功");
		} catch (Exception e) {
			map.put("msc", -2);
			map.put("text", "修改失败");
		} finally {
			return map;
		}
	}

	/**
	 * @desc 添加
	 * @param student
	 * @param classes
	 * @return
	 */
	@SuppressWarnings("finally")
	@RequestMapping("add")
	@ResponseBody
	public Map<String, Object> add(Classes classes) {
		classes.setC_id(UUID.randomUUID().toString());
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			classesService.add(classes);
			map.put("msc", 200);
			map.put("text", "添加成功");
		} catch (Exception e) {
			map.put("msc", -2);
			map.put("text", "添加失败");
		} finally {
			return map;
		}

	}

	/**
	 * @desc 删除
	 * @param student
	 * @param classes
	 * @return
	 */
	@SuppressWarnings("finally")
	@RequestMapping("delete")
	@ResponseBody
	public Map<String, Object> delete(Classes classes) {
		System.out.println(classes + "删除");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			classesService.delete(classes);
			map.put("msc", 200);
			map.put("text", "删除成功");
		} catch (Exception e) {
			map.put("msc", -2);
			map.put("text", "删除失败");
		} finally {
			return map;
		}

	}

}
