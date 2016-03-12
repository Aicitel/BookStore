package Daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;










import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;






import com.opensymphony.xwork2.ActionContext;






//import dao.plugin.*;
import DAO.BaseDao;
import DAO.Dao;

public class Userprofileimp implements BaseDao{

	public Map<String, String> check(String username){
		try{
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("userprofile");
			Map<String, String> result = new HashMap<String, String>();
			DBCollection users = db.getCollection("users");
			BasicDBObject query = new BasicDBObject();
			
			DBCursor cur = users.find(query);
			if(cur.hasNext()){
				DBObject obj = cur.next();
				result.put("gender", obj.get("gender").toString());
				result.put("address", obj.get("address").toString());
				result.put("phone", obj.get("phone").toString());
				result.put("favorite", obj.get("favorite").toString());
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void AddEntry(Object username) {
		try{
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("userprofile");
			DBObject user = new BasicDBObject();
			user.put("name", username);
			user.put("gender", "");
			user.put("address", "");
			user.put("phone", "");
			user.put("favorite","");
			DBCollection users = db.getCollection("users");
			users.insert(user);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void RemoveEntry(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateEntry(String username, Object entry) {
		try{
			/*
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("userprofile");
			DBObject user = new BasicDBObject();
			user.put("name", username);
			user.put("gender", info.get("gender"));
			user.put("address", info.get("address"));
			user.put("phone", info.get("phone"));
			user.put("favorite",info.get("favorite"));
			DBCollection users = db.getCollection("users");
			DBObject query = new BasicDBObject();
			query.put("name", username);
			users.findAndModify(query, user);*/
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public Object RetrieveEntrybyId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object RetrieveEntrybyName(String name) {
		try{
			ArrayList<String>profile = new ArrayList<String>(); 
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("mydb");
			DBCollection users = db.getCollection("user");
			
	        BasicDBObject query=new BasicDBObject ();
	        query.put("name","bluemaple");
	        DBCursor cursor = users.find(query);
	        if(!cursor.hasNext())
	        	System.out.println("no item");
			users.find(new BasicDBObject("name",name));
			while(cursor.hasNext()){
				DBObject userprofile = cursor.next();
				
			    profile.add(userprofile.get("name").toString());
			    profile.add(userprofile.get("password").toString());
			    profile.add(userprofile.get("gender").toString());
			    profile.add(userprofile.get("mailaddress").toString());
			    profile.add((String)userprofile.get("introduction"));
			    System.out.println(profile.get(4));
				ActionContext context = ActionContext.getContext();
				context.put("userprofile",profile);
			}
	        return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List RetrieveAllEntry() {
		try{
			ArrayList<String>profile = new ArrayList<String>(); 
			Mongo mongo = new Mongo("localhost", 27017); 
            //new BasicDBObject("name", 121),
			DB db = mongo.getDB("mydb");
			DBCollection users = db.getCollection("user");
	        DBCursor cursor=users.find(); 
	        System.out.println("mongodb中的user表结果如下：");
	        while(cursor.hasNext()){
				DBObject user = cursor.next();
				
	        	/*user.get("name", username);
	        	user.get("password", password);
	        	
				user.get("gender", info.get("gender"));
				user.get("address", info.get("address"));
				user.get("phone", info.get("phone"));
				user.get("favorite",info.get("favorite"));*/
		    	profile.add(user.get("name").toString());
		    	profile.add(user.get("password").toString());
		    	profile.add(user.get("gender").toString());
		    	profile.add(user.get("mailaddress").toString());
		    	profile.add(user.get("introduction").toString());
	            //System.out.println(cursor.next());
	        }
			ActionContext context = ActionContext.getContext();
			context.put("userprofile",profile);
	        return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
