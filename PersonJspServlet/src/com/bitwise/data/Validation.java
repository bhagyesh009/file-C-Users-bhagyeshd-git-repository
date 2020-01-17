package com.bitwise.data;

public class Validation {

	public boolean mobnoValidation(String mobno) {
		if (mobno.length() == 10) {

			for (char ch : mobno.toCharArray()) {
				if (Character.isLetter(ch)) {
					return false;
				}
			}
			return true;
		} else
			return false;
	}

	public boolean nameValidation(String name) {
		if (name != "" && !name.isEmpty()) {
			for (char ch : name.toCharArray()) {
				if (Character.isDigit(ch)) {
					return false;
				}
			}
			return true;
		} else
			return false;

	}

}
