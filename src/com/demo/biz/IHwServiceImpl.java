package com.demo.biz;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IHwDAO;
import com.demo.dao.entity.Hw;
import com.demo.dao.entity.HwExt;

@Service
public class IHwServiceImpl implements IHwService {
	@Autowired
	private IHwDAO hwDAO;

	@Override
	public HwExt findByPK(String hwdm) {
		// TODO 自动生成的方法存根
		return hwDAO.findByPK(hwdm);
	}

	@Override
	public Collection<HwExt> findAllList() {
		// TODO 自动生成的方法存根
		return hwDAO.findAllList();
	}

	@Override
	public Collection<HwExt> findListByPk(String hwdm) {
		// TODO 自动生成的方法存根
		return hwDAO.findListByPk(hwdm);
	}

	@Override
	public String saveHw(Hw hw, String flag) {
		if("u".equals(flag)){
			//保存
			return hwDAO.updByPK(hw);
		}else{
			//新增
			return hwDAO.insByPK(hw);
		}
	}

	@Override
	public String delByPK(String hwdm) {
		// TODO 自动生成的方法存根
		return hwDAO.delByPK(hwdm);
	}

	@Override
	public Collection<HwExt> findListByHwmc(String hwmc) {
		// TODO 自动生成的方法存根
		return hwDAO.findListByHwmc(hwmc);
	}
}
