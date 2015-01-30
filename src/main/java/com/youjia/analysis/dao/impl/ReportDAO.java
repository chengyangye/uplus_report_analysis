package com.youjia.analysis.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.youjia.analysis.util.CommonUtil;

@Repository
public class ReportDAO {
	private JdbcTemplate jdbcTemplate = null; 
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { 
	    this.jdbcTemplate = jdbcTemplate; 
	}
	
	 public void testLogSQL(ResultSet res) throws SQLException{
		 String sql = "insert into s_test(test_key,test_value)"
					+ " VALUES(?, ?)";
	        
            while (res.next()) {
    			Object[] params = {
    					res.getInt(1),res.getString(2)
    			};
    			jdbcTemplate.update(sql, params);
            }
	 }
	 
		public Integer getDailyResCountByMod(String date, Integer[] mods, boolean bAll) {
			String inSql = CommonUtil.createInSql(mods);
			StringBuffer sql = new StringBuffer();
			if(bAll){
				sql.append("select count(id) from report where report.mod in ("+inSql+") and date_format(create_time,'%Y-%m-%d')=? ");
			}else{//返回不通过数量
				sql.append("select count(id) from report where report.mod in ("+inSql+") and report.pass in (0,2) and date_format(create_time,'%Y-%m-%d')=? ");
			}
			
			int count = jdbcTemplate.queryForInt(sql.toString(),new Object[]{date});		
			return count;
		}

		public Integer getDailyLockCount(String date) {
			
			StringBuffer sql = new StringBuffer("select count(id) from uniform_disposal_record where disposal_type=104 and date_format(create_time,'%Y-%m-%d') = ? ");
			int count = jdbcTemplate.queryForInt(sql.toString(),new Object[]{date});		
			return count;
		}
		
		 public void saveEveryDayPermitConut(Object[] params) throws DataAccessException, SQLException{		 
				String sql = "insert into daily_report(`date`,`video_p`,`video_r`,`audio_p`,`audio_r`,`text_p`,`text_r`,`image_p`,`image_r`,`punish`)"
						+ " VALUES(?, ?, ?, ?, ? , ?, ?, ?, ?, ?)";
	 			jdbcTemplate.update(sql, params);
		 }
}



