package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOFile {
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
