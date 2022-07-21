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
		
		// jsonObj / jsonResult 객체 확인하기(예시데이터)
//		{
//		    "results": [
//		        {
//		            "address_components": [
//		                {
//		                    "long_name": "1600",
//		                    "short_name": "1600",
//		                    "types": [
//		                        "street_number"
//		                    ]
//		                },
//		                {
//		                    "long_name": "Amphitheatre Parkway",
//		                    "short_name": "Amphitheatre Pkwy",
//		                    "types": [
//		                        "route"
//		                    ]
//		                },
//		                {
//		                    "long_name": "Mountain View",
//		                    "short_name": "Mountain View",
//		                    "types": [
//		                        "locality",
//		                        "political"
//		                    ]
//		                },
//		                {
//		                    "long_name": "Santa Clara County",
//		                    "short_name": "Santa Clara County",
//		                    "types": [
//		                        "administrative_area_level_2",
//		                        "political"
//		                    ]
//		                },
//		                {
//		                    "long_name": "California",
//		                    "short_name": "CA",
//		                    "types": [
//		                        "administrative_area_level_1",
//		                        "political"
//		                    ]
//		                },
//		                {
//		                    "long_name": "United States",
//		                    "short_name": "US",
//		                    "types": [
//		                        "country",
//		                        "political"
//		                    ]
//		                },
//		                {
//		                    "long_name": "94043",
//		                    "short_name": "94043",
//		                    "types": [
//		                        "postal_code"
//		                    ]
//		                }
//		            ],
//		            "formatted_address": "1600 Amphitheatre Pkwy, Mountain View, CA 94043, USA",
//		            "geometry": {
//		                "location": {
//		                    "lat": 37.4224428,
//		                    "lng": -122.0842467
//		                },
//		                "location_type": "ROOFTOP",
//		                "viewport": {
//		                    "northeast": {
//		                        "lat": 37.4239627802915,
//		                        "lng": -122.0829089197085
//		                    },
//		                    "southwest": {
//		                        "lat": 37.4212648197085,
//		                        "lng": -122.0856068802915
//		                    }
//		                }
//		            },
//		            "place_id": "ChIJeRpOeF67j4AR9ydy_PIzPuM",
//		            "plus_code": {
//		                "compound_code": "CWC8+X8 Mountain View, CA",
//		                "global_code": "849VCWC8+X8"
//		            },
//		            "types": [
//		                "street_address"
//		            ]
//		        }
//		    ],
//		    "status": "OK"
//		}
		
		return result;
	}
}
