package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.ProductBean;
import model.ProductService;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport implements ServletRequestAware {
	
	private HttpServletRequest request;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	private ProductBean bean ;
	private String prodaction;
	@Override
	public void validate() {
		
		if(prodaction!=null) {
			if(prodaction.equals("Insert") || prodaction.equals("Update") || prodaction.equals("Delete")) {
				if(bean.getId()==0) {
					this.addFieldError("bean.id",
							this.getText("productForm.id.required"));
				}
			}
		}

	}
	private ProductService service = new ProductService();
	@Override
	public String execute() throws Exception {
		if(prodaction!=null && prodaction.equals("Select")) {
			List<ProductBean> result = service.select(bean);
			request.setAttribute("select", result);
			return Action.SUCCESS;
		} else if(prodaction!=null && prodaction.equals("Insert")) {
			ProductBean result = service.insert(bean);
			if(result!=null) {
				request.setAttribute("insert", result);
			} else {
				this.addFieldError("action",
						this.getText("productForm.insert.fail"));
			}
			return Action.INPUT;
		} else if(prodaction!=null && prodaction.equals("Update")) {
			ProductBean result = service.update(bean);
			if(result!=null) {
				request.setAttribute("update", result);
			} else {
				this.addFieldError("action",
						this.getText("productForm.update.fail"));
			}
			return Action.INPUT;
			
		} else if(prodaction!=null && prodaction.equals("Delete")) {
			boolean result = service.delete(bean);
			if(result) {
				this.addFieldError("action",
						this.getText("productForm.delete.success"));
			} else {
				this.addFieldError("action",
						this.getText("productForm.delete.fail"));
			}
			return Action.INPUT;
		} else {
			this.addFieldError("action",
					this.getText("productForm.action.unknown"));
			return Action.INPUT;
		}
	}
	public ProductBean getBean() {
		return bean;
	}
	public void setBean(ProductBean bean) {
		this.bean = bean;
	}
	public String getProdaction() {
		return prodaction;
	}
	public void setProdaction(String prodaction) {
		this.prodaction = prodaction;
	}
}
