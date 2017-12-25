package com.study.service;

import java.sql.SQLException;
import java.util.List;

import com.study.dao.CategoryDao;
import com.study.domain.Category;

public class CategoryService {

	public List<Category> getAllCategory() throws SQLException {
		CategoryDao cd=new CategoryDao();
		List<Category> list=cd.getAllCategory();
		return list;
	}

}
