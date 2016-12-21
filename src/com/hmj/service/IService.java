package com.hmj.service;

import java.util.Collection;

import com.hmj.util.DBOperation;

public class IService {
	protected DBOperation operation;
	protected String pagestr = ""; // 页面分页信息

	public DBOperation getOperation() {
		return operation;
	}

	public void setOperation(DBOperation operation) {
		this.operation = operation;
	}

	/*
	 * public Collection getAll(String hql){ return operation.getAll(hql); }
	 */
	public String getPagestr() {
		return pagestr;
	}

	public void setPagestr(String pagestr) {
		this.pagestr = pagestr;
	}

	public Collection getAll(String sql) {
		try {
			return operation.getAll(sql);
		} catch (Exception e) {
			return null;
		}
	}

	public Collection getAll(String sql, int iPage) {
		try {
			Collection list = operation.getAll(sql, iPage);
			setPagestr(operation.getPageStr());
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean insert(Object object) {
		try {
			operation.update(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean update(Object object) {
		try {
			operation.update(object);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean delete(Object object) {
		try {
			operation.delete(object);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
