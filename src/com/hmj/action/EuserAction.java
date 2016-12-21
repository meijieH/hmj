package com.hmj.action;

import java.util.Collection;

import com.hmj.obj.Euser;
import com.hmj.service.EuserService;

public class EuserAction extends BaseAction {
	protected EuserService euserService;
	private Integer id;
	private String user;
	private String password;
	private Integer[] ids;

	public EuserService getEuserService() {
		return euserService;
	}

	public void setEuserService(EuserService euserService) {
		this.euserService = euserService;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public String getAll() {
		String hql = "from Euser";
		Collection objects = euserService.getAll(hql, currentPage);
		pageStr = euserService.getPagestr();
		request.setAttribute("C_INFO_LIST", objects);
		request.setAttribute("C_PAGE_INFO", pageStr);
		return "userlist";
	}

	public String preAdd() {
		return "useradd";
	}

	public String add() {
		Euser object = new Euser();
		object.setUser(user);
		object.setPassword(password);
		euserService.insert(object);
		return "refresh";
	}

	public String preUpdate() {
		Euser object = null;
		try {
			object = (Euser) euserService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "userupdate";
	}

	public String update(){
		Euser object = null;
		try {
			object = (Euser) euserService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		object.setUser(user);
		object.setPassword(password);
		euserService.update(object);
		return "refresh";
	}
	
	public String delete(){
		for(int i = 0; i < ids.length; i++){
			try {
				Euser object = (Euser) euserService.getInfo(ids[i]);
				euserService.delete(object);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "refresh";
	}


}
