package com.demo.dao;

import java.util.Collection;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.demo.base.BaseDAO;
import com.demo.dao.entity.Dw;

@Repository
public class IDwDAOImpl extends BaseDAO implements IDwDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Dw findByPK(String dwdm) {
		String strSQL = "select * from t_dw where dwdm='"
				+ dwdm + "'";
		try {
			System.out.println(strSQL);
			   return this.getJdbcTemplate().queryForObject(strSQL,
					new BeanPropertyRowMapper(Dw.class));
			} catch (EmptyResultDataAccessException erdae) {
			   return new Dw();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<Dw> findAllDw() {
		// TODO 自动生成的方法存根
		String strSQL = "select * from t_dw";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(Dw.class));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<Dw> findDwByDwmc(String dwmc) {
		// TODO 自动生成的方法存根
		String strSQL = "select * from t_dw where dwmc like '%"
				+ dwmc + "%'";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(Dw.class));
	}
}
