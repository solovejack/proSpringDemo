package com.demo.biz;

import java.util.Collection;

import com.demo.dao.entity.Dw;

public interface IDwService {

	public Collection<Dw> findAllDw();
	
	public Collection<Dw> findDwByDwmc(String dwmc);
}
