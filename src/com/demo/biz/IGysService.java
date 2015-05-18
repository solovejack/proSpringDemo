package com.demo.biz;

import java.util.Collection;

import com.demo.dao.entity.Gys;

public interface IGysService {
	public Gys findByPK(String gysdm);

	public Collection<Gys> findAllGys();
	
	public Collection<Gys> findGysByGysmc(String gysmc);
}
