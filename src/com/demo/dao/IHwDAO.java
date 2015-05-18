package com.demo.dao;

import java.util.Collection;

import com.demo.dao.entity.Hw;
import com.demo.dao.entity.HwExt;

public interface IHwDAO {
	public HwExt findByPK(String hwdm);
	
	public Collection<HwExt> findAllList();
	
	public Collection<HwExt> findListByPk(String hwdm);
	
	Collection<HwExt> findListByHwmc(String hwmc);
	
	public String delByPK(String hwdm);
	
	public String insByPK(Hw hw);
	
	public String updByPK(Hw hw);
	
}
