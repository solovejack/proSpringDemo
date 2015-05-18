package com.demo.dao;

import java.util.Collection;

import com.demo.dao.entity.Dw;

public interface IDwDAO {
	public Dw findByPK(String dwdm);

	public Collection<Dw> findAllDw();
	
	public Collection<Dw> findDwByDwmc(String dwmc);
}
