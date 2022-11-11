package com.brody.billing.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "token")
public class MyConsulConfig {
	
	private long accessTokenTimeout;
    private long refreshTokenTimeout;
    
	public long getAccessTokenTimeout() {
		return accessTokenTimeout;
	}
	public void setAccessTokenTimeout(long accessTokenTimeout) {
		this.accessTokenTimeout = accessTokenTimeout;
	}
	public long getRefreshTokenTimeout() {
		return refreshTokenTimeout;
	}
	public void setRefreshTokenTimeout(long refreshTokenTimeout) {
		this.refreshTokenTimeout = refreshTokenTimeout;
	}
    
    

}
