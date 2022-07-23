package com.backend.app.business.coury.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.app.business.coury.service.CouryService;
import com.backend.app.model.Payload;

@Controller
@RequestMapping("/express")
public class CouryController {
    
    @Autowired
    CouryService couryService;

    @ResponseBody
    @PostMapping("/getExpress")
    public ResponseEntity<Payload> getUser(@RequestParam int userSeq) {
    	Payload result = new Payload();
    	
    	Payload request = new Payload();
    	request.set("userSeq", userSeq);
    	
    	result = couryService.getUserCouryResult(request);
    	return ResponseEntity.ok(result);
    }
    
    
}
