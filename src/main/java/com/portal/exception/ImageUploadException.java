package com.portal.exception;

import java.io.IOException;

public class ImageUploadException extends RuntimeException {

	private static final long serialVersionUID = -6998738881547219939L;

	public ImageUploadException(String message) {
		super(message);
	}

	public ImageUploadException(String string, Exception e) {
		super(string, e);
	}

}
