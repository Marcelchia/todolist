package org.generation.todolist.controller;


import org.generation.todolist.controller.dto.TaskDTO;
import org.generation.todolist.repository.Entity.Tasks;
import org.generation.todolist.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;



import java.util.Date;

@RestController
@RequestMapping("/item")    // a naming "/item" is given

public class TaskController {

	final TaskService itemService;

	//constructor
	public TaskController(@Autowired TaskService itemService) {
		this.itemService = itemService;
	}

	@CrossOrigin
	//Cross-origin resource sharing (CORS) provides security to prohibit AJAX calls to the resources residing outside
	// the current origin.
	@GetMapping("/all") // a naming "/all" is given
	//GetMapping is the route that correspond to the HTTP GET method calls from the client.

	public Iterable<Tasks> getItems() {
		return TaskService.all();   //calling a method all() in the service package - ItemService interface
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public Tasks findItemById(@PathVariable Integer id) {
		return itemService.findById(id);
	}

	@CrossOrigin
	@DeleteMapping("/{id}") //  {id} entry of the id value (integer)
	public void delete(@PathVariable Integer id) {
		itemService.delete(id);
	}

	@CrossOrigin
	@PostMapping("/add")
	//@RequestParam method to pass the information received from the clients
	public Tasks save(@RequestParam(name = "title", required = true) String title,
										@RequestParam(name = "description", required = true) String description,
										@RequestParam(name = "targetDate", required = true) Date targetDate)


	{
		TaskDTO itemDto = new TaskDTO(title, description, targetDate);
		return itemService.save(new Tasks(itemDto));
	}


}
