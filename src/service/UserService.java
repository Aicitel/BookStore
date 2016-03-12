package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import entity.User;
import DAO.BaseDao;

public class UserService {
	private BaseDao userDao;
	
	public void setUserDao(BaseDao userDao){
		this.userDao = userDao;
	}
	public void UpdateUser(String ID,String username,String password){
		User entry = new User();
		entry.setId(ID);
		entry.setUsername(username);
		entry.setPassword(password);
		userDao.UpdateEntry(ID,entry);
	}
	
	@SuppressWarnings("unchecked")
	public void GetAllUser(){
		List<User>entryUserList = userDao.RetrieveAllEntry();
  	  	ArrayList<ArrayList<String>>entryList = new ArrayList<ArrayList<String>>();
		Iterator<User> iter = entryUserList.iterator();
        while(iter.hasNext()){
        	User cnt_user = iter.next();
      	  	ArrayList<String>userentry = new ArrayList<String>();
      	  	userentry.add(cnt_user.getId()+"");
      	  	userentry.add(cnt_user.getUsername()+"");
      	  	userentry.add(cnt_user.getPassword()+"");
      	  	entryList.add(userentry);
        }
		ActionContext context = ActionContext.getContext();
		context.put("userlist",entryList);
	}
	
	public boolean UserExist(String username){
		if((this.userDao.RetrieveEntrybyName(username))!=null)
			return true;
		else
			return false;
	}
	public boolean LoginVerfiy(String username, String password){
		User user=(User)this.userDao.RetrieveEntrybyName(username);
		if(user.getPassword().equals(password))
			return true;
		else 
			return false;
	}
	public String GetUserId(String username){
		User user=(User)this.userDao.RetrieveEntrybyName(username);
		if(user==null)
			return null;
		else 
			return user.getId();
	}
}
