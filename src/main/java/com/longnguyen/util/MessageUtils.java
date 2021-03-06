package com.longnguyen.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MessageUtils {

	public Map<String, String> getMessage(String message) {
		Map<String, String> result = new HashMap<String, String>();
			if (message.equals("insert_success")) {
				result.put("message", "Insert success");
				result.put("alert", "success");
			} else if (message.equals("updata_success")) {
				result.put("message", "Updata success");
				result.put("alert", "success");
			} else if (message.equals("error_system")) {
				result.put("message", "Error system");
				result.put("alert", "danger");
			}
		return result;
	}
}
