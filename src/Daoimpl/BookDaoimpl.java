package Daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Book;
import DAO.BaseDao;

public class BookDaoimpl extends HibernateDaoSupport implements BaseDao{

	@Override
	public void AddEntry(Object entry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RemoveEntry(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateEntry(String id, Object entry) {
		Session session = null;
	    try {  
	          session = getSessionFactory().openSession();
	          Transaction transaction = session.beginTransaction();
	          session.update(id,(Book)entry);
	          transaction.commit();
	          if(session!=null)  
	              session.close();
	    } 
	    catch (HibernateException e){	
	          throw e; 
	    }
	}

	@Override
	public Object RetrieveEntrybyId(String id) {
		Session session = null;
	    try {  
	          session = getSessionFactory().openSession();
	          Book book = (Book)session.get(Book.class,id);
	          if(session!=null)  
	              session.close();
	          return book;
	    } 
	    catch (HibernateException e){	
	          throw e; 
	    }
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object RetrieveEntrybyName(String name) {
		Session session = null;
	    try {  
	          session = getSessionFactory().openSession();
	          String hql = "from Book where name='"+name+"'";
	          List<Book> list= session.createQuery(hql).list();
	          if(session!=null)  
	              session.close();
	          return list.get(0);
	    } 
	    catch (HibernateException e){
	          throw e; 
	    }
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List RetrieveAllEntry(){
		Session session = null;
	    try {  
	          session = getSessionFactory().openSession();
	          String hql = "from Book";
	          List<Book> list= session.createQuery(hql).list();
	          if(session!=null)  
	              session.close();
	          return list;
	    } 
	    catch (HibernateException e){
	          throw e; 
	    }
	}

}
