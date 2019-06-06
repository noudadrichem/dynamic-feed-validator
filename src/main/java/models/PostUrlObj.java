package models;

public class PostUrlObj {

	String url;
	String uploadDate;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Override
	public String toString() {
		return "UploadedObject [url=" + url + ", uploadDate=" + uploadDate + "]";
	}

}