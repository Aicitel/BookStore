package entity;

public class Userbook {  

    private int id;   
    private int bookid;   
    private int userid;
    private double orderprice;
    
    public int getId() {  
        return id;  
    }  
    public void setId(int id) {  
        this.id = id;  
    }  
    public int getBookid() {  
        return bookid;  
    }  
    public void setBookid(int bookid) {  
        this.bookid = bookid;  
    }  
    public int getUserid() {  
        return userid;  
    }  
    public void setUserid(int userid) {  
        this.userid = userid;  
    }  
    public void setOrderprice(double orderprice){
    	this.orderprice = orderprice;
    }
    public double getOrderprice(){
    	return this.orderprice;
    }
}  