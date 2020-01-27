package com.bitwise.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bitwise.data.Output;
import com.bitwise.data.User;

public class JsonUtil {
	private static ObjectMapper mapper = new ObjectMapper();

	public static String convertJavaToJson(Output output) {

		try {
			return mapper.writeValueAsString(output);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String convertJavaToJsonString(User user) {

		try {
			return mapper.writeValueAsString(user);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static User convertJsonToJava(String jsonString, Class<User> user) {
		try {
			return mapper.readValue(jsonString, user);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
