package com.demo.biz;

import java.util.Collection;

import com.demo.dao.entity.Bz;

public interface IBzService {

	public Collection<Bz> findAllBz();
	
	public Collection<Bz> findBzByBzmc(String bzmc);
}
