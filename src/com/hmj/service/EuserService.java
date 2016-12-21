package com.hmj.service;

import com.hmj.obj.Euser;

public class EuserService extends IService{
	public Object getInfo(Integer key) throws Exception {
		return operation.getInfo(Euser.class, key);
	}
}
