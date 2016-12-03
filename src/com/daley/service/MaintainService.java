package com.daley.service;

import java.util.ArrayList;
import java.util.List;
import com.daley.dao.MessageDao;

/**
 * @author Daley Date 2016-11-30 project_name MicroMessage
 */
// ά����ص�ҵ��
public class MaintainService {
	// ����ɾ��
	public void deleteOne(String id) {
		if (id != null && !"".equals(id.trim())) {
			MessageDao messageDao = new MessageDao();
			messageDao.deleteOne(Integer.valueOf(id));
		}
	}

	public void deleteBatch(String[] ids) {
		MessageDao messageDao = new MessageDao();
		List<Integer> idList = new ArrayList<Integer>();
		try {
			for (String id : ids) {
				idList.add(Integer.valueOf(id));
			}
			messageDao.deleteBatch(idList);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
