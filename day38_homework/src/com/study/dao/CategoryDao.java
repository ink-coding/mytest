package com.study.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.study.domain.Category;
import com.study.utils.C3P0Utils;

public class CategoryDao {

	public List<Category> getAllCategory() throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from category;";
		List<Category> list = qr.query(sql, new BeanListHandler<Category>(Category.class));
		return list;
	}

}
