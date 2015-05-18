package com.demo.dao;

import java.util.Collection;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.demo.base.BaseDAO;
import com.demo.dao.entity.OaSendMail;
import com.demo.dao.entity.OaSendMailExt;
import com.demo.util.AssertUtil;
import com.demo.util.UtilMethod;

@Repository
public class IOaSendMailDAOImpl extends BaseDAO implements IOaSendMailDAO {

	/**
	 * 草稿箱
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<OaSendMailExt> findDraftMailByUserId(String userId) {
		StringBuffer str = new StringBuffer();
		str.append("select t1.postId,t1.senderId,t1.accepterId,t1.title,t1.content,to_char(t1.sendDate,'YYYY-MM-DD') sendDate,t1.fileId,t1.readFlag,to_char(t1.readDate,'YYYY-MM-DD') readDate,t1.sendFlag,t1.showFlag,t2.username senderName,t3.username accepterName  from t_oasendmail t1 left join t_users t2 on t1.senderid = t2.userid left join t_users t3 on t1.accepterId = t3.userid ");
		str.append(" where t1.sendflag='"+UtilMethod.SENDFLAG_A+"'");
		str.append(" and t1.senderId='"+userId+"'");
		return this.getJdbcTemplate().query(str.toString(),
				new BeanPropertyRowMapper(OaSendMailExt.class));
	}
	
	/**
	 * 已发件箱
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<OaSendMailExt> findSendMailByUserId(String userId) {
		StringBuffer str = new StringBuffer();
		str.append("select t1.postId,t1.senderId,t1.accepterId,t1.title,t1.content,to_char(t1.sendDate,'YYYY-MM-DD') sendDate,t1.fileId,t1.readFlag,to_char(t1.readDate,'YYYY-MM-DD') readDate,t1.sendFlag,t1.showFlag,t2.username senderName,t3.username accepterName  from t_oasendmail t1 left join t_users t2 on t1.senderid = t2.userid left join t_users t3 on t1.accepterId = t3.userid ");
		str.append(" where sendflag='"+UtilMethod.SENDFLAG_B+"'");
		str.append(" and senderId='"+userId+"'");
		return this.getJdbcTemplate().query(str.toString(),
				new BeanPropertyRowMapper(OaSendMailExt.class));
	}

	/**
	 * 已收件箱
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<OaSendMailExt> findAcceptMailByUserId(String userId) {
		StringBuffer str = new StringBuffer();
		str.append("select t1.postId,t1.senderId,t1.accepterId,t1.title,t1.content,to_char(t1.sendDate,'YYYY-MM-DD') sendDate,t1.fileId,t1.readFlag,to_char(t1.readDate,'YYYY-MM-DD') readDate,t1.sendFlag,t1.showFlag,t2.username senderName,t3.username accepterName  from t_oasendmail t1 left join t_users t2 on t1.senderid = t2.userid left join t_users t3 on t1.accepterId = t3.userid ");
		str.append(" where sendflag='"+UtilMethod.SENDFLAG_B+"'");
		str.append(" and accepterId='"+userId+"'");
		return this.getJdbcTemplate().query(str.toString(),
				new BeanPropertyRowMapper(OaSendMailExt.class));
	}

	/**
	 * 保存发件信息
	 */
//	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String saveOaSendMail(OaSendMail oaSendMail) {
		return this.insByPK(oaSendMail);
	}

	/**
	 * 发送信息
	 */
//	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String sendOaSendMail(OaSendMail oaSendMail) {
		// TODO 自动生成的方法存根
		return null;
	}

	/**
	 * 根据主键查询数据
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public OaSendMail findByPK(String postId) {
		String strSQL = "select postId,senderId,accepterId,title,content,to_char(sendDate,'YYYY-MM-DD'),fileId,readFlag,to_char(readDate,'YYYY-MM-DD'),sendFlag,showFlag from t_oasendmail where postId='"+postId+"'";
		try {
			System.out.println(strSQL);
			   return this.getJdbcTemplate().queryForObject(strSQL,
					new BeanPropertyRowMapper(OaSendMail.class));
			} catch (EmptyResultDataAccessException erdae) {
				System.out.println(erdae);
			   return new OaSendMail();
		}
	}
	
	/**
	 * 新增数据
	 */
//	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String insByPK(OaSendMail oaSendMail) {
		StringBuffer str = new StringBuffer();
		str.append("insert into t_oasendmail (postId,senderId, accepterId,title,content,sendDate,fileId,readFlag,readDate,sendFlag,showFlag)  VALUES(");
		str.append("'"+oaSendMail.getPostId()+"',");
		str.append("'"+oaSendMail.getSenderId()+"',");
		str.append("'"+oaSendMail.getAccepterId()+"',");
		str.append("'"+oaSendMail.getTitle()+"',");
		str.append("'"+oaSendMail.getContent()+"',");
		str.append("to_date('"+oaSendMail.getSendDate()+"','yyyy-mm-dd'),");
		str.append("'"+oaSendMail.getFileId()+"',");
		str.append("'"+oaSendMail.getReadFlag()+"',");
		str.append("to_date('"+oaSendMail.getReadDate()+"','yyyy-mm-dd'),");
		str.append("'"+oaSendMail.getSendFlag()+"',");
		str.append("'"+oaSendMail.getShowFlag()+"'");
		str.append(")");
		System.out.println("ins-sql=="+str.toString());
		try{
			this.getJdbcTemplate().update(str.toString());
		} catch (Exception e){
			System.out.println(e);
			return "N";
		}	
		return "Y";
	}
	
	/**
	 * 根据主键保存数据
	 */
//	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String updByPK(OaSendMail oaSendMail) {
		StringBuffer str = new StringBuffer();
		str.append("update t_oasendmail set ");
		if(AssertUtil.isVal(oaSendMail.getSenderId())){
			str.append(" senderId='"+oaSendMail.getSenderId()+"',");
		}		
		str.append(" accepterId='"+oaSendMail.getAccepterId()+"',");
		str.append(" title='"+oaSendMail.getTitle()+"',");
		str.append(" content='"+oaSendMail.getContent()+"',");
		str.append(" sendDate=to_date('"+oaSendMail.getSendDate()+"','yyyy-mm-dd'),");
		str.append(" fileId='"+oaSendMail.getFileId()+"',");
		str.append(" readFlag='"+oaSendMail.getReadFlag()+"',");
		str.append(" readDate=to_date('"+oaSendMail.getReadDate()+"','yyyy-mm-dd'),");
		str.append(" sendFlag='"+oaSendMail.getSendFlag()+"'");
//		str.append(" showFlag='"+oaSendMail.getShowFlag()+"'");
		str.append(" where postId='"+oaSendMail.getPostId()+"'");
		System.out.println("upd-sql=="+str.toString());
		try{
			this.getJdbcTemplate().update(str.toString());
		} catch (Exception e){
			System.out.println(e);
			return "N";
		}
		return "Y";
	}
	
	/**
	 * 根据主键删除数据
	 */
//	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String delByPK(String postId) {
		String strSql = "delete from t_oasendmail where postId='"+postId+"'";
		System.out.println("del-sql=="+strSql);
		try{
			this.getJdbcTemplate().update(strSql);
		} catch (Exception e){
			System.out.println(e);
			return "N";
		}
		return "Y";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public OaSendMailExt findExtByPK(String postId) {
		StringBuffer str = new StringBuffer();
		str.append("select t1.postId,t1.senderId,t1.accepterId,t1.title,t1.content,to_char(t1.sendDate,'YYYY-MM-DD') sendDate,t1.fileId,t1.readFlag,to_char(t1.readDate,'YYYY-MM-DD') readDate,t1.sendFlag,t1.showFlag,t2.username senderName,t3.username accepterName  from t_oasendmail t1 left join t_users t2 on t1.senderid = t2.userid left join t_users t3 on t1.accepterId = t3.userid ");
		str.append(" where t1.postId='"+postId+"'");
		try {
			System.out.println("str=="+str.toString());
			   return this.getJdbcTemplate().queryForObject(str.toString(),
					new BeanPropertyRowMapper(OaSendMailExt.class));
			} catch (EmptyResultDataAccessException erdae) {
				System.out.println(erdae);
			   return new OaSendMailExt();
		}
	}
}
