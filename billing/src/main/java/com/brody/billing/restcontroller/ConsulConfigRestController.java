package com.brody.billing.restcontroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brody.billing.config.MyConsulConfig;
import com.brody.billing.config.MyVaultConfig;

import java.util.Map;

@RefreshScope
@RestController
public class ConsulConfigRestController {
	
	@Autowired
    private MyConsulConfig myConsulConfig;
    @Autowired
    private MyVaultConfig myVaultConfig;

    @GetMapping("/myConfig")
    public Map<String,Object> myConfig(){
        return Map.of("consulConfig",myConsulConfig, "vaultConfig",myVaultConfig);
    }

}
