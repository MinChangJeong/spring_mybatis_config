package com.backend.app.business.express.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.app.business.common.SuperService;
import com.backend.app.common.map.GoogleMap;
import com.backend.app.model.Payload;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Service
public class ExpressService extends SuperService{
    
	@Autowired
	GoogleMap googleMap;
	
	// 배송주소 위치좌표값 얻어오기
	public Payload getLocation(Payload payload) {
		Payload result = new Payload();
		
		// response 결과 매핑
		String jsonResult = googleMap.getLocation(payload);;
		JsonObject jsonObj = new Gson().fromJson(jsonResult, new JsonObject().getClass());
				
		return result;
	}
}
