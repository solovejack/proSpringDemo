package com.demo.dao;

import java.util.Collection;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.demo.base.BaseDAO;
import com.demo.dao.entity.Bz;

@Repository
public class IBzDAOImpl extends BaseDAO implements IBzDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Bz findByPK(String bzdm) {
		String strSQL = "select * from t_bz where bzdm='"
				+ bzdm + "'";
		try {
			System.out.println(strSQL);
			   return this.getJdbcTemplate().queryForObject(strSQL,
					new BeanPropertyRowMapper(Bz.class));
			} catch (EmptyResultDataAccessException erdae) {
			   return new Bz();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<Bz> findAllBz() {
		String strSQL = "select * from t_bz";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(Bz.class));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<Bz> findBzByBzmc(String bzmc) {
		String strSQL = "select * from t_bz where bzmc like '%"
				+ bzmc + "%'";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(Bz.class));
	}
}
