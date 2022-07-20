package com.backend.app.business.express.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.app.business.express.service.ExpressService;
import com.backend.app.model.Payload;

@Controller
@RequestMapping("/express")
public class ExpressController {
    
    @Autowired
    ExpressService userService;

    @ResponseBody
    @PostMapping("/getExpress")
    public ResponseEntity<Payload> getUser(@RequestBody Payload request) {
    	Payload result = new Payload();
    	
    	// post 방식 예시
//    	{
//    	    "express" :  {
//    	        "recv_name" : "정민창",
//    	        "recv_addr" : "서울시 마포구 양화로1길"
//    	    }
//    	}    	
    	
    	JSONObject request_json =  new JSONObject(request);
    	JSONObject express = request_json.getJSONObject("express");
    	
    	String recv_name = express.getString("recv_name");
    	String recv_addr = express.getString("recv_addr");
    	
    	return ResponseEntity.ok(result);
    }
}
