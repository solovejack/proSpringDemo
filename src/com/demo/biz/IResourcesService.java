package com.demo.biz;

import java.util.Collection;

import com.demo.dao.entity.Resources;

public interface IResourcesService {
	public Collection<Resources> findResourcesByResId(String resId);
	
	public Collection<Resources> findAllResources();
	
	public String saveRes(Resources res,String flag);
	
	public String delRes(String resId);
	
	public Resources findByPk(String resId);
}
