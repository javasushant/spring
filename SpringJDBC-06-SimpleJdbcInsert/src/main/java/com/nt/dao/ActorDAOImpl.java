package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.model.ActorDetails;

@Repository("actorDAO")
public class ActorDAOImpl implements IActorDAO {
		@Autowired
	private SimpleJdbcInsert sji;
	/*
	@Override
	public int insert(ActorDetails details) {
		//set db table name
		sji.setTableName("ACTOR");
		//give col names and values
		Map<String, Object> colNamesValues=Map.of("ACTORID",details.getActorId(),
																									"ACTORNAME",details.getActorName(),
																									"ACTORADDRS",details.getActorAddrs(),
																									"PHONE",details.getPhone(),
																									"RENUMERATION",details.getRenumeration());
		//execute the query
		int count=sji.execute(colNamesValues);
		return count;
	}
*/
	@Override
	public int insert(ActorDetails details) {
		//set db table name
				sji.setTableName("ACTOR");
//				execute the query
				int count =sji.execute(new BeanPropertySqlParameterSource(details));
		return count;
	}

}
