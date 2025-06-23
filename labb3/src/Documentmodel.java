package labb2;

public class Documentmodel {
	
	private String content = "";
	private String filePath = "";
	private boolean isModified = false;
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
		setModified(true);
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public boolean isModified() {
		return isModified;
	}
	
	public void setModified(boolean isModified) {
		this.isModified = isModified;
	}
}



