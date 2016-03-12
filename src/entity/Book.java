package entity;

public class Book {  
  
    private String id;   
    private String name;   
    private int bookcount;     
    private double price;
      
    public String getId() {  
        return id;  
    }  
    public void setId(String id) {  
        this.id = id;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getBookcount() {  
        return bookcount;  
    }  
    public void setBookcount(int bookcount){
    	this.bookcount = bookcount;
    }
    public void setPrice(double price) {  
        this.price = price;  
    }  
    public double getPrice(){
    	return price;
    }
}  