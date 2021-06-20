package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.external.IICCScoreComp;

@Service("cbservice")
public class CBScoreMgmtServiceImpl implements ICBScoreMgmtService {
	@Autowired
	private IICCScoreComp extComp;
	@Override
	public String findScore(int mid) {
		//use external com
		String score = extComp.getScore(mid);
		
		return score;
	}

}
