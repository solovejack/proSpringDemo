package com.demo.dao;

import java.util.Collection;

import com.demo.dao.entity.Gys;

public interface IGysDAO {
	public Gys findByPK(String gysdm);

	public Collection<Gys> findAllGys();
	
	public Collection<Gys> findGysByGysmc(String gysmc);
}
