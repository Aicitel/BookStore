package Daoimpl;

import DAO.Dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;  
import org.hibernate.HibernateException;
import org.hibernate.Session;

import action.Invoketest;
import entity.Userbook;
  
public class DaoimplHdbc extends HibernateDaoSupport implements Dao{
  
//hhhh-----------------------------------------
  Invoketest invoketest;
  public void setInvoketest(Invoketest invoketest){
	  this.invoketest = invoketest;
  }
  public Invoketest getInvoketest(){
	  return this.invoketest;
  }
 //---------------------------------------------
  
  public String ex = "normal";
  public DaoimplHdbc(){
	  
  }
  @SuppressWarnings({ "rawtypes" } )
  private String getbookcount(String bookid){
	  Session session = null;
      try {  
          session = getSessionFactory().openSession();
          String hql = "select bookcount from Book as a where id='"+bookid+"'";
          List list = session.createQuery(hql).list();
          if(session!=null)  
              session.close();
          if(list.size()==0)
        	  return "cound not get the count"+bookid;
          else
        	  return ""+list.get(0);
      } 
      catch (HibernateException e){
          throw e; 
      }
  }
  @SuppressWarnings("unchecked")
  private String GetUserID(String username){
	  Session session = null;
      try {
          session = getSessionFactory().openSession();  
          String hql = "select id from User as a where username='"+username+"'";
          List<String>list= session.createQuery(hql).list();
          if(session!=null)  
              session.close();
          if(list.size()==0)
        	  return "-1";
          else
        	  return list.get(0);
      } 
      catch (HibernateException e) {
          throw e;
      }
  }
  
  @SuppressWarnings({ "unchecked"})
  public String UserRemoveBook(String username,String bookid){
	  Session session = null;
      try {
//------------------------------------------------------
    	  //invoketest.invoke_print();
//======================================================
    	  
          //session = sessionFactory.openSession();
          session = getSessionFactory().openSession();
          
          String hql = "from Userbook where userid="+GetUserID(username)+" and bookid= "+bookid ;
          
          List<Userbook>list= session.createQuery(hql).list();
          Userbook remove_entry = list.get(0);
          int remove_entry_id = remove_entry.getId(); 
          if(list.size()==0){
              if(session!=null)  
                  session.close();              
        	  return "fail"+username+" "+bookid;
          }
          else{	
        	  String delete_hql="delete Userbook as ub where ub.id="+remove_entry_id;
        	  session.createQuery(delete_hql).executeUpdate();
        	  session.beginTransaction().commit();
              if(session!=null)  
                  session.close();
        	  return "success";
          }
      } 
      catch (HibernateException e) {
    	  throw e;
      }
  }
}  