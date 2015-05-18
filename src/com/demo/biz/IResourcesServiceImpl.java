package com.demo.biz;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IResourcesDAO;
import com.demo.dao.entity.Resources;

@Service
public class IResourcesServiceImpl implements IResourcesService {
	@Autowired
	private IResourcesDAO resourcesDAO;

	@Override
	public Collection<Resources> findAllResources() {
		return resourcesDAO.findAllResources();
	}
	
	@Override
	public Collection<Resources> findResourcesByResId(String resId) {
		return resourcesDAO.findResourcesByResId(resId);
	}
	
	@Override
	public String saveRes(Resources res,String flag){		
		return resourcesDAO.saveRes(res, flag);
	}
	
	@Override
	public String delRes(String resId){
		return resourcesDAO.delRes(resId);
	}

	@Override
	public Resources findByPk(String resId) {
		return resourcesDAO.findByPK(resId);
	}
}
