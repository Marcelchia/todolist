package org.generation.todolist.service;

import org.generation.todolist.repository.TaskRepository;
import org.generation.todolist.repository.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

// implement the ItemService to allow controller to use the methods in ItemService

@Service
public class TaskServiceMySQL implements TaskService {

	private final TaskRepository itemRepository; // final - will not change. Create an object itemRepository from
	// CrudRepository in Interface ItemRepository

	//constructor
	public TaskServiceMySQL(@Autowired TaskRepository itemRepository) //@Autowired - to link
	{
		this.itemRepository = itemRepository;
	}

	@Override
	//this save method is in the service layer and will be called by the controller.
	public Tasks save (Tasks item)
	{
		//save an item into the database
		//perform the action CRUD - Create (new item) or Update(existing item)
		return this.itemRepository.save(item); //use the save(S entity) method in interface CrudRepository
	}

	@Override
	//this delete method is in the service layer and will be called by the controller.
	public void delete (int itemId)
	{
		this.itemRepository.deleteById(itemId);
	}

	@Override
	public List<Tasks> all ()
	{
		List<Tasks> result = new ArrayList<>(); //create an instance result of type ArrayList
		this.itemRepository.findAll().forEach(result::add); //forEach loop to add to result arraylist
		return result; //in a form of List - ArrayList
	}

	@Override
	public Tasks findById (int itemId)
	{
		//using Optional to identify this item that returns back might be a 'null'
		Optional<Tasks> item = this.itemRepository.findById(itemId);
		Tasks itemResponse = item.get();     //Create an object itemResponse to hold the get item
		return itemResponse;
	}
}
