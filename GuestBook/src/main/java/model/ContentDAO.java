package model;

import java.util.List;

public interface ContentDAO {
	public abstract List<ContentBean> select();
	public abstract ContentBean select(String title);
	public abstract ContentBean insert(ContentBean bean);

}