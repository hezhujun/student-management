package com.studentManagement.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.studentManagement.model.News;

/**
 * 获取新闻的action
 * @author Hezhujun
 *
 */
public class GetNewsAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 254860676085829768L;
	private int page = 1; // 页数
	private int rowsPerPage = 10; // 每页的数据条数

	@Override
	public String execute() throws Exception {
		if (page == 1) {
			int rows = (int) getService().getTotalRow("News", null, null);
			sendObject("totalPage", getService()
					.getTotalPage(rows, rowsPerPage));
		}
		// 获取最新消息
		List<News> news = getService().getNews(page, rowsPerPage);
		sendObject("totalNews", news.size());

		// 发送最新10条信息
		Map<Integer, News> newMap = new HashMap<Integer, News>();
		for (int i = 0; i < news.size(); i++) {
			newMap.put(i + 1, news.get(i));
		}
		sendObject("news", newMap);

		return SUCCESS;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
}
