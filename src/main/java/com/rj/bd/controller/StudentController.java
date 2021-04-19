package com.rj.bd.controller;
/**
* @desc 学生的c层
* 
* @author TianShuo
* 
* @version 2021年4月19日 上午8:19:36
*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rj.bd.entity.Classes;
import com.rj.bd.entity.Student;
import com.rj.bd.service.IStudentService;

@RequestMapping("/student")
@Controller
public class StudentController {

	@Autowired
	private IStudentService studentService;

	/**
	 * 查询全部
	 * 
	 * @return
	 */
	@RequestMapping("query")
	@ResponseBody
	public List<Student> queryAll() {
		System.out.println("查询全部");
		return studentService.all();
	}

	/**
	 * @desc 查询一条
	 * @param student
	 * @return
	 */
	@RequestMapping("toedit")
	@ResponseBody
	public Student toedit(Student student) {
		System.out.println(student + "转到修改");
		return studentService.one(student);
	}

	/**
	 * @desc 修改
	 * @param student
	 * @return
	 */
	@SuppressWarnings("finally")
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> edit(Student student, Classes classes) {
		student.setClasses(classes);
		System.out.println(student + "修改");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			studentService.edit(student);
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
	public Map<String, Object> add(Student student, Classes classes) {
		student.setClasses(classes);
		student.setS_id(UUID.randomUUID().toString());
		System.out.println(student + "添加");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			studentService.add(student);
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
	public Map<String, Object> delete(Student student) {
		System.out.println(student + "删除");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			studentService.delete(student);
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
