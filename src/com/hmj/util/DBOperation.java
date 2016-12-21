package com.hmj.util;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DBOperation extends HibernateDaoSupport{
	
	//添加分页使用的成员变量，并添加各成员变量的setter和getter函数。
	private int pageSize = 5; // 页面大小page size
	private int totalRec; // 总记录数 total record number
	private int pageCount; // 页数 page count
	private String pageStr; // 分页显示 page linker

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRec() {
		return totalRec;
	}
	public void setTotalRec(int totalRec) {
		this.totalRec = totalRec;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public String getPageStr() {
		return pageStr;
	}
	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}
	
	public Collection getAll(String sql, int iPage) {
		List lists = null;
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		lists = session.createQuery("select count(*) " + sql).list();
		totalRec = Integer.parseInt(lists.get(0).toString());
		lists.clear();
		pageCount = totalRec / pageSize + ((totalRec % pageSize) > 0 ? 1 : 0);
		Query query = session.createQuery(sql);
		int limit = 0;
		if (iPage > 0)
			limit = pageSize * (iPage - 1);
		if (iPage > pageCount)
			limit = pageSize * (pageCount - 1);
		setPageStr(iPage);
		limit = limit < 0 ? 0 : limit;
		query.setFirstResult(limit);
		query.setMaxResults(pageSize);
		lists = query.list();
		session.close();
		return lists;
	}
	public void setPageStr(int iPage) {
		if (iPage > pageCount)
			iPage = pageCount;
		iPage = iPage < 1 ? 1 : iPage;
		pageStr = "共有<font color='#ff7103'>" + totalRec + "</font>条数据";
		pageStr += " 第<font color='#ff7103'>" + iPage + "</font>页" +"/" + pageCount + "页"
		 + " <font color='#ff7103'>" + pageSize + "</font>条数据/页";
		int iStart = iPage - 5, iEnd;
		iStart = (iStart < 1) ? 1 : iStart;
		iEnd = iStart + 9;
		iEnd = (iEnd > pageCount) ? pageCount : iEnd;
		if ((iEnd > 0) && (iPage > 1))
			pageStr += "　<span onclick='gotoPage(1)' title='首页' style='color:#333333' "
			+ "onmouseover='this.style.color=\"#ff7103\"' onmouseout='this.style.color=\"#333333\"'>◀</span>";
		else
			pageStr += "　◀";
		while(iStart <= iEnd){
			if (iStart == iPage)
				pageStr += "　" +  "<font color='#ff7103'>" + iStart + "</font>";
			else
				pageStr += "　<span onclick='gotoPage(" + iStart
				+ ")' title='第" + iStart + "页' style='color:#333333' "
				+ "onmouseover='this.style.color=\"#ff7103\"' onmouseout='this.style.color=\"#333333\"'>" + iStart + "</span>";
			iStart++;
		}
		if ((iEnd > 0) && (iPage < iEnd))
			pageStr += "　<span onclick='gotoPage(" + pageCount
			+ ")' title='末页' style='#333333' "
			+"onmouseover='this.style.color=\"#ff7103\"' onmouseout='this.style.color=\"#333333\"'>▶</span>";
		else
			pageStr += "　▶";
	}

	
	public List getAll(String hql){
		List lists = null;
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		lists = query.list();
		session.close();
		return lists;
	}
	public Object getInfo(Class objectClass, Integer key) {
		return getHibernateTemplate().get(objectClass, key);
	}
	public void update(Object object) throws Exception {
		getHibernateTemplate().saveOrUpdate(object);
	}
	public void delete(Object object){
		getHibernateTemplate().delete(object);
	}
}
