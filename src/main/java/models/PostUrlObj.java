package models;


public class PostUrlObj {

	String url;
	String validationId;

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

	@Override
	public String toString() {
		return "UploadedObject [url=" + url + ", validationId=" + validationId + "]";
	}

}