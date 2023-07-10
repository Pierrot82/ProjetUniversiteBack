package com.inti.response;

public class UploadResponse {
	
	private String message;

    public UploadResponse() {
    }

    public UploadResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
