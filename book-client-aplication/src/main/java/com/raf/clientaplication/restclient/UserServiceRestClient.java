package com.raf.clientaplication.restclient;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raf.clientaplication.restclient.dto.TokenRequestDto;
import com.raf.clientaplication.restclient.dto.TokenResponseDto;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserServiceRestClient {
	
	public static final String URL = "http://localhost:8084/api";
	
	public static MediaType JSON =
			MediaType.get("application/json; charset=utf-8");

	
	OkHttpClient client = new OkHttpClient();
	ObjectMapper objectMapper = new ObjectMapper();
	
	public String login(String username, String password) throws IOException {
	
		TokenRequestDto tokenRequestDto = new TokenRequestDto(username, password);
		
		RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(tokenRequestDto));
		
		Request request = new Request.Builder()
				.url(URL + "/user/login").post(body).build();
		System.out.println(request);
		
		Call call = client.newCall(request);
		
		Response response = call.execute();
		
		if(response.code() == 200 || response.code() == 201) {
			String json = response.body().string();
			TokenResponseDto dto = objectMapper.readValue(json, TokenResponseDto.class);
			
			return dto.getToken();
		}
		
		throw new RuntimeException("Invalid username or password");
		
	}
	
	

	
}
