package com.abc.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class GenericDAO
{
	private static Logger logger = LoggerFactory.getLogger(GenericDAO.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String getJSONData(String sSQL) throws SQLException, JsonProcessingException
	{
		String json = "[]";

		try
		{
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sSQL);
			json = new ObjectMapper().writeValueAsString(rows);

		} catch (Exception  e)
		{
			logger.error("SQL Exception in Query: "+e.toString());
			logger.error("SQL Query with Error: "+sSQL.toString());
		}
		return json;
	}
/*	public String getJSONData(String sSQL) throws SQLException, JsonProcessingException
	{
		String json = "";
		try
		{
			System.out.println(sSQL);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sSQL);
			json = new ObjectMapper().writeValueAsString(rows);
		} catch (SQLException e)
		{
			logger.error("Generic DAO Error: "+e.toString());
			JSONObject errorObject = new JSONObject();
			JSONObject blankResponse = new JSONObject();
			try
			{
				//errorObject.put("ErrorMessage", e.getMessage());
				errorObject.put("Status", ABGCONSTANT.FAIL);
				errorObject.put("response", blankResponse);
				return errorObject.toString();
			} catch (JSONException e1)
			{
				logger.error("Generic DAO Error: "+e1.toString());
			}
			throw e;
		}
		return json;
	} */
	public int RunProcedure(String PROC_NAME, Object[] param)
	{
		//jdbcTemplate.update("call SOME_PROC (?, ?)", param1, param2);
		logger.info("Procedure "+PROC_NAME+" called with "+param);
		 int i=jdbcTemplate.update(PROC_NAME, param);
		//jdbcTemplate.update("exec TYMS_ALERTS ", param);
		//jdbcTemplate.update("call SOME_PROC (?, ?)", param1, param2);
		return i;
	}
	public int ExecuteUpdate(String sSQL)
	{
		return jdbcTemplate.update(sSQL);
	}    
	public List<Map<String, Object>> getDataMap(String sSQL)
	{
		System.out.println("Query: "+sSQL);
		return jdbcTemplate.queryForList(sSQL);
	}

	public Map<String, Object> getJSONObject(String sSQL)
	{
		return jdbcTemplate.queryForList(sSQL).get(0);
	}

	public List<Object[]> getListData(String sSQL)
	{
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sSQL);
		List<Object[]> lst = new ArrayList<Object[]>();
		for (Map<String, Object> map : list)
		{
			Object[] P = new Object[map.size()];
			int i = 0;
			for (Map.Entry<String, Object> entry : map.entrySet())
			{
				P[i] = entry.getValue();
				i++;
			}
			lst.add(P);
		}
		return lst;

	}

}
