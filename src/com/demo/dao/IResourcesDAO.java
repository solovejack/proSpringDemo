package com.demo.dao;

import java.util.Collection;

import com.demo.dao.entity.Resources;

public interface IResourcesDAO {
	
	public Collection<Resources> findResourcesByResId(String resId);

	public Collection<Resources> findAllResources();
	
	public String saveRes(Resources res,String flag);
	
	public String delRes(Resources res);
	
	public String delRes(String resId);
	
	public Resources findByPK(String resId);
}
