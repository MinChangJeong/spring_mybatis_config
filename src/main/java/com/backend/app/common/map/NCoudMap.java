package com.backend.app.common.map;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.backend.app.model.Payload;
import com.google.gson.JsonObject;

@Component
public class NCoudMap {
	
	final String DRIVIE_REQUEST_URL = "https://naveropenapi.apigw.ntruss.com/map-direction/v1/driving"; // ncloud 네비게이션 사용을 위한 요청 URL
	final String API_KEY_ID = ""; // ncloud api 인증키
	final String API_KEY = ""; // ncloud api 비밀키
	
	// NCldoud Diriving 
	public String navigate(Payload payload) {
		String result = "";
		CloseableHttpClient httpClient = null;
		
		try {
			
			// HTTP 통신 객체 생성 및 헤더 설정
			httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(DRIVIE_REQUEST_URL);
			httpPost.setHeader("content-type", "application/json; charset=utf-8");
			httpPost.setHeader("X-NCP-APIGW-API-KEY-ID", API_KEY_ID);
			httpPost.setHeader("X-NCP-APIGW-API-KEY	", API_KEY);
			
			// 출발점, 목적지 파라미터 세팅
			JsonObject mapObj = new JsonObject();
			mapObj.addProperty("start", payload.getString("start"));
			mapObj.addProperty("goal", payload.getString("goal"));
			
			httpPost.setEntity(new StringEntity(mapObj.toString(), "UTF-8"));
			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
			
			result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
