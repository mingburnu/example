package controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import model.CustomerBean;
import model.CustomerService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class LoginAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

//接收資料
	private String username;
	private String password;
	
//驗證資料
//	@Override
//	public void validate() {
//		System.out.println("validate");
//		if(username==null || username.trim().length()==0) {
//            this.addFieldError("username",
//            		this.getText("loginForm.username.required"));
//		}
//		if(password==null || password.trim().length()==0) {
//            this.addFieldError("password",
//            		this.getText("loginForm.password.required"));
//		}
//	}

//呼叫Model、根據Model執行結果導向View
	private CustomerService service = new CustomerService();
	@Override
	public String execute() throws Exception {

		CustomerBean bean = service.login(username, password);
		if(bean==null) {
            this.addFieldError("password",
            		this.getText("loginForm.login.fail"));
            return Action.INPUT;
		} else {
			session.put("user", bean);
			return Action.SUCCESS;
		}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
