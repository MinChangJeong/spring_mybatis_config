package com.backend.app.business.coury.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.app.business.coury.service.CouryService;
import com.backend.app.model.Payload;

@Controller
@RequestMapping("/coury")
public class CouryController {
    
    @Autowired
    CouryService couryService;

//    @ResponseBody
//    @GetMapping("/getCouryResult")
//    public ResponseEntity<Payload> getCouryListByDate(@RequestParam int userSeq) {
//    	Payload result = new Payload();
//    	
//    	result = couryService.getCouryListByDate(userSeq);
//    	return ResponseEntity.ok(result);
//    }
   
    @ResponseBody
    @PostMapping("/getDistance")
    public ResponseEntity<Payload> getDistance(@RequestBody Payload request) {
    	Payload result = new Payload();
    	
    	JSONObject request_json =  new JSONObject(request);
    	
    	String start = request_json.getString("start");
    	String goal = request_json.getString("goal");
    	
    	Payload param_box = new Payload();
    	param_box.set("start", start);
    	param_box.set("goal", goal);
    	
    	result = couryService.getDistance(param_box);
    	
    	return ResponseEntity.ok(result);
    }
    
    // @Scheduled(cron="0 0 19 * * *")    
    @ResponseBody
    @PostMapping("/autoAssignmentCoury")
    public ResponseEntity<Payload> autoAssignmentCoury(@RequestBody Payload request) {
    	Payload result = new Payload();

    	// param -> area : "연남동", priority : "무게 or size", count : 갯수, workTime : 주간/새벽
    	result = couryService.autoAssignmentCoury(request);
    	
    	return ResponseEntity.ok(result);
    }
    
    @ResponseBody
    @PostMapping("/confirmCouryList")
    public ResponseEntity<Payload> confirmCouryList(@RequestBody Payload request) {
    	Payload result = new Payload();

    	result = couryService.confirmCouryList(request);
    	return ResponseEntity.ok(result);
    }
    
    @ResponseBody
    @PostMapping("/updateCompletedCoury")
    public ResponseEntity<Payload> updateCompletedCoury(@RequestBody Payload request) {
    	Payload result = new Payload();

    	result = couryService.updateCompletedCoury(request);
    	return ResponseEntity.ok(result);
    }
    
    @ResponseBody
    @PostMapping("/getAssignmentedCouryList")
    public ResponseEntity<Payload> getAssignmentedCouryList(@RequestBody Payload request) {
    	Payload result = new Payload();

    	result = couryService.getAssignmentedCouryList(request);
    	return ResponseEntity.ok(result);
    }
}
