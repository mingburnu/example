package model;

public class ContentBean {
	private String title;
	private String content;

	public ContentBean() {

	}

	public ContentBean(String line) {
		if (line != null && line.length() != 0) {
			String[] temp = line.split(",");
			if (temp != null && temp.length == 2) {
				this.title = temp[0];
				this.content = temp[1];
			}
		}
	}

	@Override
	public String toString() {
		return "[" + title + "," + content + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
