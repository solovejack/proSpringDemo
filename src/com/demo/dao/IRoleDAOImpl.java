package com.demo.dao;

import java.util.Collection;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.demo.base.BaseDAO;
import com.demo.dao.entity.Role;

@Repository
public class IRoleDAOImpl extends BaseDAO implements IRoleDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<Role> findAll() {
		String strSQL = "select * from t_roles";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(Role.class));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public Collection<Role> findByRoleId(String roleId){
    	String strSQL = "select * from t_roles where role_id like '%"+roleId+"%'";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(Role.class));
    }
}
