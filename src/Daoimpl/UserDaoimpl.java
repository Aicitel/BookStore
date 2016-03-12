package Daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.User;
import DAO.BaseDao;

public class UserDaoimpl extends HibernateDaoSupport implements BaseDao{

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
	          session.update(id,(User)entry);
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
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object RetrieveEntrybyName(String name) {
		Session session = null;
	    try {  
	          session = getSessionFactory().openSession();
	          String hql = "from User where username='"+name+"'";
	          List<User> list= session.createQuery(hql).list();
	          if(session!=null)  
	              session.close();
	          return list.get(0);
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
	          String hql = "from User";
	          List<User> list= session.createQuery(hql).list();
	          if(session!=null)  
	              session.close();
	          return list;
	    } 
	    catch (HibernateException e){
	          throw e; 
	    }
	}

}
