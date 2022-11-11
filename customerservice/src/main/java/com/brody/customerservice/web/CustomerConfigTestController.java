package com.brody.customerservice.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class CustomerConfigTestController {
	
	
	@Value("${global.params.p1}")
	private String p1;
	
	@Value("${global.params.p2}")
	private String p2;
	

	@Value("${customer.params.x}")
    private String x;
    @Value("${customer.params.y}")
    private String y;
	
	@GetMapping("/params")
	public Map<String, String> params(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("p1", p1);
		map.put("p2", p2);
		map.put("x", x);
		map.put("y", y);
		return map;
		
	}
	
	
}
