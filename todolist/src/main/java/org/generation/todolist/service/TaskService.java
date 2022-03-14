package org.generation.todolist.service;

import org.generation.todolist.repository.Entity.*;
import java.util.List;

public interface TaskService {

	Tasks save (Tasks item);  //save the item into the database

	void delete (int itemId);   //delete item from database

	List<Tasks> all();   //return all product items to user

	Tasks findById (int itemId);     //find a particular item

}



