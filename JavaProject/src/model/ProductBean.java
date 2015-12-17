package model;

public class ProductBean {
	public ProductBean(String line) {
		if(line!=null && line.length()!=0) {
			String[] temp = line.split(",");
			if(temp !=null && temp.length == 0) {
				this.id = ProductBean.convertInt(temp[0]); 
				this.name = temp[1];
				this.price = ProductBean.convertInt(temp[2]);
//				this.make = ;
				this.expire = ProductBean.convertInt(temp[4]);
			}
			
		}
	}
	public static int convertInt(String data) {
		int result = 0;
		try {
			result = Integer.parseInt(data);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			result = -1000;
		}
		return result;
	}
	private int id;
	private String name;
	private double price;
	private java.util.Date make;
	private int expire;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public java.util.Date getMake() {
		return make;
	}
	public void setMake(java.util.Date make) {
		this.make = make;
	}
	public int getExpire() {
		return expire;
	}
	public void setExpire(int expire) {
		this.expire = expire;
	}
}
