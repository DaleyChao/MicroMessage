package com.daley.service;

import com.daley.dao.MessageDao;

/**
 * @author Daley
 * Date 2016-11-30
 * project_name MicroMessage
 */
//ά����ص�ҵ��
public class MaintainService {
	//����ɾ��
	public void deleteOne(String id){
		if(id!=null&&!"".equals(id.trim())){
			MessageDao messageDao=new MessageDao();
			messageDao.deleteOne(Integer.valueOf(id));
	}
	}
}
