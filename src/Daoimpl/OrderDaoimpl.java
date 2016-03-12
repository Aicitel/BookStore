package Daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Userbook;
import DAO.BaseDao;

public class OrderDaoimpl extends HibernateDaoSupport implements BaseDao{

	@Override
	public void AddEntry(Object entry) {
		// TODO Auto-generated method stub
		Session session = null;
	    try {  
	        session = getSessionFactory().openSession();
	        session.save(entry);
        	session.beginTransaction().commit();
	        if(session!=null)  
	            session.close();
	    } 
	    catch (HibernateException e){
	        throw e; 
	    }
	}

	@Override
	public void RemoveEntry(String id) {
		Session session = null;
		try {
	        session = getSessionFactory().openSession();
			Userbook userbook = (Userbook) session.get(Userbook.class,Integer.parseInt(id));
			session.delete(userbook);
	        session.beginTransaction().commit();
		    if(session!=null)  
		    	session.close();
		}
	    catch (HibernateException e){
	        throw e; 
	    }
	}

	@Override
	public void UpdateEntry(String id, Object entry) {
		Session session = null;
	    try {  
	          session = getSessionFactory().openSession();
	          Transaction transaction = session.beginTransaction();
	          session.update(id,(Userbook)entry);
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
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List RetrieveEntrybyName(String name) {
		Session session = null;
	    try {  
	          session = getSessionFactory().openSession();
	          String hql = "from Userbook as a where userid='"+name+"'";
	          List<Userbook> list= session.createQuery(hql).list();
	          if(session!=null)  
	              session.close();
	          return list;
	    } 
	    catch (HibernateException e){
	          throw e; 
	    }
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List RetrieveAllEntry() {
		Session session = null;
	    try {  
	          session = getSessionFactory().openSession();
	          String hql = "from Userbook";
	          List<Userbook> list= session.createQuery(hql).list();
	          if(session!=null)  
	              session.close();
	          return list;
	    } 
	    catch (HibernateException e){
	          throw e; 
	    }
	}
	

}
