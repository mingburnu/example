package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.ContentBean;
import model.ContentService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ContentCheck extends ActionSupport {
	private String title;
	private String commemt;
	private ContentBean bean;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCommemt() {
		return commemt;
	}

	public void setCommemt(String commemt) {
		this.commemt = commemt;
	}

	public void validate() {
		if (title == null || title.trim().equals("")) {
			addFieldError("title", "The title is required");
		}
		if (commemt == null || commemt.trim().equals("")) {
			addFieldError("commemt", "The commemt is required");
		}
	}

	

	public String execute() {
		
			return Action.SUCCESS;
		

	}
	public ContentBean getBean() {
		return bean;
	}

	public void setBean(ContentBean bean) {
		this.bean = bean;
	}
}