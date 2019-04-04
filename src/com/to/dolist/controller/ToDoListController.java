package com.to.dolist.controller;

import java.sql.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.to.dolist.model.ToDoList;
import com.to.dolist.service.ToDoListServiceImpl;

@Controller
public class ToDoListController {

	@Autowired
	ToDoListServiceImpl service;
	ToDoList list = getObj();
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Locale locale, Model model,
			@RequestParam String title,
			@RequestParam String message,
			@RequestParam int estimation,
			@RequestParam String status,
			@RequestParam Date startdate,
			@RequestParam Date duedate
			) {
		list.setDuedate(duedate);
		list.setEstimation(estimation);
		list.setMessgae(message);
		list.setStartdate(startdate);
		list.setStatus(status);
		list.setTitle(title);
		list = service.create(list);
		model.addAttribute("serverTime", list.toString());
		return "home";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update (Locale locale, Model model,
			@RequestParam long id,
			@RequestParam String title,
			@RequestParam String message,
			@RequestParam int estimation,
			@RequestParam String status,
			@RequestParam Date startdate,
			@RequestParam Date duedate
	) {
		list.setId(id);
		list.setDuedate(duedate);
		list.setEstimation(estimation);
		list.setMessgae(message);
		list.setStartdate(startdate);
		list.setStatus(status);
		list.setTitle(title);
		list = service.update(list);
		model.addAttribute("serverTime", list.toString());
		return "home";
	}
	
	@RequestMapping(value="/read", method =  RequestMethod.GET)
	public String read(Locale locale, Model model, @RequestParam long id) {
		list = service.read(id);
		model.addAttribute("serverTime", list.toString());
		return "home";
	}
	
	@RequestMapping(value="/", method =  RequestMethod.GET)
	public String readAll(Locale locale, Model model) {
		List<ToDoList> list = service.readAll();
		model.addAttribute("serverTime", list.toString());
		return "home";
	}
	
	@RequestMapping(value="/delete", method =  RequestMethod.GET)
	public String delete(Locale locale, Model model, @RequestParam long id) {
		service.delete(id);
		model.addAttribute("serverTime", id+" Deleted");
		return "home";
	}

	@Bean
	public ToDoList getObj() {
		return new ToDoList();
	}
}