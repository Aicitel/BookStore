package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import entity.Book;

public class TrolleyService {
	private OrderService orderManager;
	private BookService bookManager;
	private UserService userManager;
	
	public void setOrderManager(OrderService orderService){
		this.orderManager = orderService;
	}
	public void setBookManager(BookService bookService){
		this.bookManager = bookService;
	}
	public void setUserManager(UserService userService){
		this.userManager = userService;
	}
	
	public void UserOrderTrolleyEntry(String username,String bookID){
		String userID = userManager.GetUserId(username);
		orderManager.UserAddEntry(userID, bookID);
	}
	
	@SuppressWarnings("unchecked")
	public void UserAddTrolleyEntry(String username,String bookID){
		Book addBookEntry = bookManager.GetBookById(bookID);
		ArrayList<String> addTrolleyEntry = new ArrayList<String>();
		addTrolleyEntry.add(addBookEntry.getId());
		addTrolleyEntry.add(addBookEntry.getName());
		addTrolleyEntry.add(addBookEntry.getPrice()+"");
		
		ActionContext context = ActionContext.getContext();
		ArrayList<ArrayList<String>>troList = (ArrayList<ArrayList<String>>)context.getSession().get("trolley");
		if(troList == null)
			troList = new ArrayList<ArrayList<String>>();
		troList.add(addTrolleyEntry);
		context.getSession().put("trolley", troList);
	}
	
	@SuppressWarnings("unchecked")
	public void UserRemoveTrolleyEntry(String username,String bookID){
		ActionContext context = ActionContext.getContext();
		ArrayList<ArrayList<String>>troList = (ArrayList<ArrayList<String>>)context.getSession().get("trolley");
		for(int i = 0; i<troList.size();i++)
			if(troList.get(i).get(0).equals(bookID)){
				troList.remove(i);
				break;
			}	
		context.getSession().put("trolley", troList);
	}
	
	public void UserRemoveDataEntry(String username,String bookID){
		String userID = userManager.GetUserId(username);
		orderManager.UserRemoveEntry(userID, bookID);
	}
	
	@SuppressWarnings({"unchecked" })
	public void GetTrolleyList(String username){
		String userId = userManager.GetUserId(username);
		List<Integer>bookIDlist = orderManager.GetUserOrderBookId(userId);
		List<Book>booklist = bookManager.GetBookListById(bookIDlist);
  	  	ArrayList<ArrayList<String>>bookEntryList = new ArrayList<ArrayList<String>>();
		Iterator<Book> iter = booklist.iterator();
        while(iter.hasNext()){
        	Book cnt_book = iter.next();
      	  	ArrayList<String>bookentry = new ArrayList<String>();
      	  	bookentry.add(cnt_book.getId());
      	  	bookentry.add(cnt_book.getName());
      	  	bookentry.add(""+cnt_book.getPrice());
            bookEntryList.add(bookentry);
        }
		ActionContext context = ActionContext.getContext();
		context.put("carlist", bookEntryList);
	}
}
