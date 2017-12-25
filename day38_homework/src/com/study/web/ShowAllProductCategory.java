package com.study.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.domain.Category;
import com.study.service.CategoryService;

public class ShowAllProductCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码解码方式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//将查询传递给service层
		CategoryService cs=new CategoryService();
		List<Category> list=null;
		try {
			list=cs.getAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("allCategory", list);
		request.getRequestDispatcher("/header.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}