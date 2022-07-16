package com.backend.app.business.user.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.app.model.Payload;

@Service
public class UserService{
    
	final String SUCCESS_CD = "success";
	final String SUCCESS_MSG = "성공";
	
	final String DEFAULT_ERROR_CD = "fail";
	final String DEFAULT_ERROR_MSG = "실패";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public Payload select(String key, Payload payload) {
		return sqlSessionTemplate.selectOne(key, payload);
	}
	
//	public Payload registerUser(Payload request) {
//		Payload result = new Payload();
//		
//		try {
//			
//			result.set("REPL_CD", SUCCESS_CD);
//			result.set("REPL_MSG", SUCCESS_MSG);
//			
//		} catch (Exception ex) {
//			result.set("REPL_CD", DEFAULT_ERROR_CD);
//			result.set("REPL_MSG", DEFAULT_ERROR_MSG);
//			ex.printStackTrace();
//		}
//		
//		return result;
//	}
	
	public Payload selectUserName(Payload request) {
		Payload result = new Payload();
		
		try {
			Payload userName = select("mybatis.user.user_mapper.selectUserName", request);
			
			result.set("username", userName);
			
			result.set("REPL_CD", SUCCESS_CD);
			result.set("REPL_MSG", SUCCESS_MSG);
			
		} catch (Exception ex) {
			result.set("REPL_CD", DEFAULT_ERROR_CD);
			result.set("REPL_MSG", DEFAULT_ERROR_MSG);
			ex.printStackTrace();
		}
		
		return result;
	}
}
