package model2;
import java.io.File;
import java.util.Iterator;
import java.util.List;

import model.ProductBean;
import model.ProductDAOFile;


public class Test {

	public static void main(String[] args) {

		File input = new File("D:/JavaSource/product.txt");
		ProductDAOFile dao = new ProductDAOFile(input);
		List<ProductBean> data = dao.getData();
		
		
		for(Iterator<ProductBean> it = data.iterator(); it.hasNext(); ) {
			ProductBean bean = it.next();

			System.out.println(bean);
		}
			
		
		
	}

}
