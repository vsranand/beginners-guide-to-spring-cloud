package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ryan Baxter
 */
@Service
public class NameService {
	private NameFeignClient nameFeignClient;

	public NameService(NameFeignClient nameFeignClient) {
		this.nameFeignClient = nameFeignClient;
	}

	public String getName() {
		return nameFeignClient.getName();
	}

	@FeignClient("name123")
	static interface NameFeignClient {
		@RequestMapping("/")
		public String getName();
	}
}
