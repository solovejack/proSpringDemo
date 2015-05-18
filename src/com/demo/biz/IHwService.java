package com.demo.biz;

import java.util.Collection;

import com.demo.dao.entity.Hw;
import com.demo.dao.entity.HwExt;

public interface IHwService {
	public HwExt findByPK(String hwdm);

	public Collection<HwExt> findAllList();
	
	public Collection<HwExt> findListByPk(String hwdm);
	
	public Collection<HwExt> findListByHwmc(String hwmc);
	
	public String saveHw(Hw hw, String flag);
	
	public String delByPK(String hwdm);
}
