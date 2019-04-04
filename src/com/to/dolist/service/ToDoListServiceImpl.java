package com.to.dolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.to.dolist.dao.ToDoListDAO;
import com.to.dolist.model.ToDoList;

@Repository
@Service
public class ToDoListServiceImpl implements ToDoListService{

	@Autowired
	ToDoListDAO toDao;
	@Override
	public ToDoList create(ToDoList list) {
		return toDao.create(list);
	}

	@Override
	public ToDoList update(ToDoList list) {
		return toDao.update(list);
	}

	@Override
	public ToDoList read(long id) {
		return toDao.read(id);
	}

	@Override
	public List<ToDoList> readAll() {
		return toDao.readAll();
	}

	@Override
	public void delete(long id) {
		toDao.delete(id);
	}

}
