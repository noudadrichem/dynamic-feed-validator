package models;


public class PostUrlObj {

	private String url;
	private String validationId;
	private String socketSessionId;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getValidationId() {
		return validationId;
	}

	public void setValidationId(String validationId) {
		this.validationId = validationId;
	}

	public String getSocketSessionId() {
		return socketSessionId;
	}

	public void setSocketSessionId(String socketSessionId) {
		this.socketSessionId = socketSessionId;
	}


	@Override
	public String toString() {
		return "UploadedObject [url=" + url + ", validationId=" + validationId + "]";
	}

}