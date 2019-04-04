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
import org.springframework.web.servlet.ModelAndView;

import com.to.dolist.model.ToDoList;
import com.to.dolist.service.ToDoListServiceImpl;

@Controller
public class ToDoListController {

	@Autowired
	ToDoListServiceImpl service;
	ToDoList list = getObj();
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(Locale locale,
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
		ModelAndView model = new ModelAndView("home");
		model.addObject("lists", service.readAll());
		return model;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public ModelAndView update (Locale locale,
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
		ModelAndView model = new ModelAndView("home");
		model.addObject("lists", service.readAll());
		return model;
	}
	
	@RequestMapping(value="/read", method =  RequestMethod.GET)
	public String read(Locale locale, Model model, @RequestParam long id) {
		list = service.read(id);
		model.addAttribute("id", list.getId());
		model.addAttribute("title", list.getTitle());
		model.addAttribute("estimation", list.getEstimation());
		model.addAttribute("startdate", list.getStartdate());
		model.addAttribute("duedate", list.getDuedate());
		model.addAttribute("message", list.getMessgae());
		model.addAttribute("status", list.getStatus());
		return "edit";
	}
	
	@RequestMapping(value="/", method =  RequestMethod.GET)
	public ModelAndView readAll(){
		ModelAndView model = new ModelAndView("home");
		List<ToDoList> list = service.readAll();
		model.addObject("lists", list);
		return model;
		
	}
	
	@RequestMapping(value="/delete", method =  RequestMethod.GET)
	public ModelAndView delete(Locale locale, @RequestParam long id) {
		service.delete(id);
		ModelAndView model = new ModelAndView("home");
		model.addObject("lists", service.readAll());
		return model;
	}

	@Bean
	public ToDoList getObj() {
		return new ToDoList();
	}
}