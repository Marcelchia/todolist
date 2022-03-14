package org.generation.todolist.repository;

import org.generation.todolist.repository.Entity.*;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring
// CRUD refers Create, Read, Update, Delete
public interface TaskRepository extends CrudRepository<Tasks, Integer>

{
}

//ItemRepository extends CrudRepository Class and it is able to access the methods that is available in the
// CrudRepository Class.

