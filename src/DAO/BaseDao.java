package DAO;

import java.util.List;

public interface BaseDao {
	
	public void AddEntry(Object entry);

	public void RemoveEntry(String id);
	
	public void	UpdateEntry(String id ,Object entry);
	
	public Object RetrieveEntrybyId(String id);

	public Object RetrieveEntrybyName(String name);

	@SuppressWarnings("rawtypes")
	public List RetrieveAllEntry();
	
}
