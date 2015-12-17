package model.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.ProductBean;

public class ProductDAOFile {
	public static void main(String[] args) {

		File input = new File("D:/JavaSource/product.txt");
		ProductDAOFile dao = new ProductDAOFile(input);
		List<ProductBean> data = dao.getData();

		for(Iterator<ProductBean> it = data.iterator(); it.hasNext(); ) {
			ProductBean bean = it.next();

			System.out.print(bean.getId()+":");
			System.out.print(bean.getName()+":");
			System.out.print(bean.getPrice()+":");
			System.out.print(bean.getMake()+":");
			System.out.println(bean.getExpire());
		}
	}
	private List<ProductBean> data = new ArrayList<ProductBean>();
	public List<ProductBean> getData() {
		return data;
	}

	public ProductDAOFile(File input) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(input));
			String line = br.readLine();
			while(line!=null) {
				ProductBean bean = new ProductBean(line);
				this.data.add(bean);

				line = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
