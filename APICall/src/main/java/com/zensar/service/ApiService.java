package com.zensar.service;

import org.springframework.beans.factory.annotation.Autowired;

//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//
//
//
//@Service
//public class ApiService {
//
//    public List<String> fetchDeviceDropdownValues() {
//        RestTemplate restTemplate = new RestTemplate();
//        // Replace the URL with the actual API endpoint
//        String apiUrl = "https://api.example.com/devices"; // Example API URL
//        ResponseEntity<String[]> response = restTemplate.getForEntity(apiUrl, String[].class);
//        String[] devicesArray = response.getBody();
//        return Arrays.asList(devicesArray);
//    }
//}

//ApiService.java
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ApiService {

	private final ObjectMapper objectMapper;

	@Autowired
	public ApiService(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public List<String> fetchDeviceDropdownValues() {
		WebClient webClient = WebClient.create();
		String apiUrl = "https://jsonplaceholder.typicode.com/posts"; // Example API URL

		Mono<String> responseMono = webClient.get().uri(apiUrl).retrieve().bodyToMono(String.class);

		String response = responseMono.block();
		List<String> devices = parseDevicesFromApiResponse(response);

		return devices;
	}

	private List<String> parseDevicesFromApiResponse(String response) {
		try {
			List<String> devices = new ArrayList<>();
			JsonNode responseNode = objectMapper.readTree(response);

			for (JsonNode deviceNode : responseNode) {
				JsonNode deviceName = deviceNode.get("title"); // Adjust the field name as per your API
				if (deviceName != null && !deviceName.isNull()) {
                    String deviceName1 = deviceName.asText();
				
				devices.add(deviceName1);
			}
			}
			return devices;
		} catch (IOException e) {
			// Handle parsing errors here
			return Collections.emptyList();
		}
		}
	
}

