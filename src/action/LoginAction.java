package action;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;

import Daoimpl.Userprofileimp;
import service.BookService;
import service.OrderService;
import service.TrolleyService;
import service.UserService;

public class LoginAction{
	
   private String username;
   private String password;
   private String addbookid;
   private String removebookid;
   private String orderbookid;
   
   private String bookid;
   private String bookname;
   private String bookprice;
   private String bookcount;
   
   private String orderid;
   private String rootorderbookid;
   private String rootorderuserid;
   
   private String rootuserid;
   private String rootusername;
   private String rootuserpassword;
   
   private UserService userManager;
   private BookService bookManager;
   private OrderService orderManager;
   private TrolleyService trolleyManager;
 
   public void setUserManager(UserService userManager){
	   this.userManager = userManager;
   }
   public void setBookManager(BookService bookService){
	   this.bookManager = bookService;
   }
   public void setOrderManager(OrderService orderService){
	   this.orderManager = orderService;
   }
   public void setTrolleyManager(TrolleyService trolleyService){
	   this.trolleyManager = trolleyService;
   }
   
   public void setBookid(String bookid){
	   this.bookid = bookid;
   }
   public void setBookname(String bookname){
	   this.bookname = bookname;
   }
   public void setBookprice(String bookprice){
	   this.bookprice = bookprice;
   }
   public void setBookcount(String bookcount){
	   this.bookcount = bookcount;
   }
   public void setOrderid(String orderid){
	   this.orderid = orderid;
   }
   public void setRootorderbookid(String rootorderbookid){
	   this.rootorderbookid = rootorderbookid;
   }
   public void setRootorderuserid(String rootorderuserid){
	   this.rootorderuserid = rootorderuserid;
   }
   
   public void setRootuserid(String rootuserid){
	   this.rootuserid = rootuserid;
   }
   public void setRootusername(String rootusername){
	   this.rootusername = rootusername;
   }
   public void setRootuserpassword(String rootuserpassword){
	   this.rootuserpassword = rootuserpassword;
   }
   
   public String verify() {
	  if(userManager.UserExist(username)&&userManager.LoginVerfiy(username, password)){
		  if(username.equals("root"))
			  return "root";
		  else
			  return "success";
	  }
	  else
		  return "fail";
   }
   public String getinfo(){
	   getBooklist();
	   getCarlist();
	   return "information";
   }
   public String getrootinfo(){
	   getBooklist();
	   getUserlist();
	   getOrderlist();
	   return "information";
   }
   public String useraddbook(){
	   trolleyManager.UserAddTrolleyEntry(this.username,this.addbookid);
	   getinfo();
	   return "changed";
   }
   public String userremovebook(){
	   trolleyManager.UserRemoveTrolleyEntry(this.username,this.removebookid);
	   getinfo();
	   return "changed";
   }
   public String userorderbook(){
	   trolleyManager.UserOrderTrolleyEntry(this.username,this.orderbookid);
	   getinfo();
	   return "changed";   
   }

   public String rootupdatebook(){
	   bookManager.UpdateBookInfo(this.bookid,this.bookname,this.bookprice,this.bookcount);
	   return "changed";
   }
   public String rootupdateorder(){
	   orderManager.UpdateOrder(this.orderid, this.rootorderuserid, this.rootorderbookid);
	   return "changed";
   }
   public String rootupdateuser(){
	   userManager.UpdateUser(this.rootuserid, this.rootusername, this.rootuserpassword);
	   return "changed";
   }
   
   public String getUsername() {
      return username;
   }
   public void setUsername(String name) {
      this.username = name;
   }
   public String getPassword(){
	   return password;
   }
   public void setPassword(String psd){
	   this.password = psd;
   }
  
   public void setRemovebookid(String rbid){
	   this.removebookid = rbid;
   }
   public String getRemovebookid(){
	   return this.removebookid;
   }
   public void setAddbookid(String abid){
	   this.addbookid = abid;
   }
   public String getAddbookid(){
	   return this.addbookid;
   }
   public void setOrderbookid(String obid){
	   this.orderbookid = obid;
   }
   public String getOrderbookid(){
	   return this.orderbookid;
   }
   
   public void getBooklist(){
	   bookManager.GetBookList();
   }
   
   public void getCarlist(){
	   trolleyManager.GetTrolleyList(this.username);
   }
   private void getOrderlist(){
	   orderManager.GetAllOrder();
   }
   private void getUserlist(){
	   userManager.GetAllUser();
   }
   public String logout(){
	   ActionContext context = ActionContext.getContext();
	   context.getSession().put("trolley", null);
	   return "drop";
   }
   
   public String userprofile(){
	   Userprofileimp userprofileimp = new Userprofileimp();
	   userprofileimp.RetrieveEntrybyName(this.username);
	   return "profile";
   }
   
   public String userupdateprofile(){
	   
	   return "changed";
   }
   
}