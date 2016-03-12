package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import entity.Book;
import DAO.BaseDao;

public class BookService {
	private BaseDao bookDao;
	
	public void setBookDao(BaseDao bookDao){
		this.bookDao = bookDao;
	}
	public void UpdateBookInfo(String ID,String name,String price,String count){
		Book entryBook = new Book();
		entryBook.setId(ID);
		entryBook.setName(name);
		entryBook.setPrice(Double.parseDouble(price));
		entryBook.setBookcount(Integer.parseInt(count));
		bookDao.UpdateEntry(ID,entryBook);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void GetBookList(){
		List books = bookDao.RetrieveAllEntry();
		List booklist = new ArrayList<ArrayList<String>>();
	    Iterator<Book> iter = books.iterator();
	    while(iter.hasNext()){
	    	  Book cnt_book = iter.next();
	    	  List cnt_list = new ArrayList<String>();
	    	  cnt_list.add(cnt_book.getId());
	      	  cnt_list.add(cnt_book.getName());
	      	  cnt_list.add(cnt_book.getPrice());
	      	  cnt_list.add(cnt_book.getBookcount());
	      	  booklist.add(cnt_list);
	    }
		ActionContext context = ActionContext.getContext();
		context.put("booklist",booklist);
	}
	public Book GetBookById(String bookId){
		return (Book)bookDao.RetrieveEntrybyId(bookId);
	}
	
	@SuppressWarnings({ "rawtypes"})
	public List GetBookListById(List<Integer>bookIdList){
		List<Book>booklist = new ArrayList<Book>();
		for(int i = 0;i<bookIdList.size();i++)
			booklist.add((Book)bookDao.RetrieveEntrybyId(bookIdList.get(i).toString()) );
		return booklist;
	}

}
