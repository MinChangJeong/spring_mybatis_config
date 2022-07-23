package com.backend.app.business.user.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.app.business.user.service.UserService;
import com.backend.app.model.Payload;

@Controller
@RequestMapping("/user")
public class UserController{
    
    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping("/registerUser")
    public ResponseEntity<Payload> registerUser(@RequestBody Payload request) {
    	Payload result = new Payload();
    	
    	JSONObject request_json =  new JSONObject(request);
    	
    	String user_id = request_json.getString("USER_ID");
    	String password = request_json.getString("PASSOWRD");
    	
	    Payload param_box = new Payload();
	    param_box.set("userId", user_id);
	    param_box.set("password", password);
    	
    	
    	result = userService.registerUser(param_box);	
    	return ResponseEntity.ok(result);
    }
    
    @ResponseBody
    @GetMapping("/getUser")
    public ResponseEntity<Payload> getUser() {
    	Payload result = new Payload();
    	    	
    	Payload request = new Payload();
    	request.set("userSeq", 1);
    	result = userService.selectUserName(request);	
    	return ResponseEntity.ok(result);
    }
}
