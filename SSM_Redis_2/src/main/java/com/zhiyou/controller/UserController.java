package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping("show")
	public  String show(HttpServletRequest req,HttpServletResponse rep){
//	
		req.setAttribute("list", service.select(1));
		return "show";
	}
	
	@RequestMapping("add")
	public  String add(User user,HttpServletRequest req,HttpServletResponse rep){
		service.add(user);
		return "forward:show";
	}
	
	@RequestMapping("delete")
	public  String delete(int id,HttpServletRequest req,HttpServletResponse rep){
		service.delete(id);
		return "forward:show";
	}
	@RequestMapping("selectByID")
	public  String selectByID(int id,HttpServletRequest req,HttpServletResponse rep){
		req.setAttribute("user", service.selectById(id));
		return "update";
	}
	
	@RequestMapping("update")
	public  String update(User user,HttpServletRequest req,HttpServletResponse rep){
		service.update(user);
		return "forward:show";
	}
}
