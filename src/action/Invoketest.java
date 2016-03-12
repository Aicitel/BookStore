package action;

import DAO.Dao;

public class Invoketest {
	private Dao daotest;
	public void setDaotest(Dao daotest){
		this.daotest = daotest;
	}
	
	public Dao getDaotest(){ 
		return this.daotest;
	}
	
	public void invoke_print(){
		//daotest.printdao();
	}
}
