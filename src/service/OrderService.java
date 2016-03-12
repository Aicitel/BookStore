package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import entity.Userbook;
import DAO.BaseDao;

public class OrderService {
	private BaseDao orderDao;
	public void setOrderDao(BaseDao orderDao){
		this.orderDao = orderDao;
	}
	
	public void UpdateOrder(String ID,String userID,String bookID){
		Userbook entryUserbook = new Userbook();
		entryUserbook.setId(Integer.parseInt(ID));
		entryUserbook.setUserid(Integer.parseInt(userID));
		entryUserbook.setBookid(Integer.parseInt(bookID));
		orderDao.UpdateEntry(ID, entryUserbook);
	}
	
	@SuppressWarnings("unchecked")
	public void GetAllOrder(){
		List<Userbook>entryUserbookList = orderDao.RetrieveAllEntry();
  	  	ArrayList<ArrayList<String>>entryList = new ArrayList<ArrayList<String>>();
		Iterator<Userbook> iter = entryUserbookList.iterator();
        while(iter.hasNext()){
        	Userbook cnt_userbook = iter.next();
      	  	ArrayList<String>bookentry = new ArrayList<String>();
      	  	bookentry.add(cnt_userbook.getId()+"");
      	  	bookentry.add(cnt_userbook.getBookid()+"");
      	  	bookentry.add(""+cnt_userbook.getUserid()+"");
      	  	entryList.add(bookentry);
        }
		ActionContext context = ActionContext.getContext();
		context.put("entrylist",entryList);
	}
	
	public void UserAddEntry(String userID, String bookID){
		Userbook userbook = new Userbook();
		userbook.setBookid(Integer.parseInt(bookID));
		userbook.setUserid(Integer.parseInt(userID));
		orderDao.AddEntry(userbook);
	}

	@SuppressWarnings({ "unchecked", "rawtypes"})
	public void UserRemoveEntry(String userID, String bookID){
		List orderList = (List<Userbook>)orderDao.RetrieveEntrybyName(userID);
		for(int i = 0;i<orderList.size();i++)
			if(bookID.equals(((Userbook) orderList.get(i)).getBookid()+"")){
				orderDao.RemoveEntry(((Userbook)orderList.get(i)).getId()+"");
				break;
			}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public List<Integer> GetUserOrderBookId(String userID){
		List orderList = (List<Userbook>)orderDao.RetrieveEntrybyName(userID);
		List<Integer>bookIdList = new ArrayList<Integer>();
		for(int i = 0;i<orderList.size();i++)
			bookIdList.add(((Userbook)orderList.get(i)).getBookid());
		return bookIdList;
	}

}
