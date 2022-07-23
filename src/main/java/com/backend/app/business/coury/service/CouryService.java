package com.backend.app.business.coury.service;

import org.springframework.stereotype.Service;

import com.backend.app.business.common.SuperService;
import com.backend.app.model.Payload;
import com.backend.app.model.PayloadList;

@Service
public class CouryService extends SuperService{
    
	// 사용자 배송 결과 데이터 가져오기 
	public Payload getUserCouryResult(Payload request) {
		Payload result = new Payload();
		
		try {
			PayloadList<Payload> total_coury_list = selectList("mybatis.coury.coury_mapper.getUserCouryResult", request);
			result.set("totalCouryList", total_coury_list);
			
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
