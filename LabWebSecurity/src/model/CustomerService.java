package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import model.dao.CustomerDAOJdbc;

public class CustomerService {
	private CustomerDAO dao = new CustomerDAOJdbc();
	
	private MessageDigest mDigest = null;
	public CustomerService() {
		try {
			mDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}	
	public static void main(String[] args) {
		CustomerService service = new CustomerService();
		service.changePassword("Alex", "AAA", "A");
	}
	public boolean changePassword(
			String username, String oldPassword, String newPassword) {
		
//		String regex = 
//				"^.*(?=.{6,})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
//		if(!newPassword.matches(regex)) {
//			System.out.println("強度不足");
//			return false;
//		}
		
		CustomerBean bean = this.login(username, oldPassword);
		if(bean!=null) {
			byte[] temp = newPassword.getBytes();	//使用者輸入：明碼
			temp = mDigest.digest(temp);			//使用者輸入：one-way hash
			return dao.update(temp,
					bean.getEmail(), bean.getBirth(), username);
		}
		return false;
	}
	public CustomerBean login(String username, String password) {
		CustomerBean bean = dao.select(username);
		if(bean!=null) {
			if(password!=null && password.length()!=0) {
				byte[] temp = bean.getPassword();	//資料庫抓出：one-way hash
				byte[] pass = password.getBytes();  //使用者輸入：明碼
				pass = mDigest.digest(pass);		//使用者輸入：one-way hash
				if(Arrays.equals(temp, pass)) {
					return bean;
				}
			}
		}
		return null;
	}
}
