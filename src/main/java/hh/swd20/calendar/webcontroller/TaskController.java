package hh.swd20.calendar.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.calendar.domain.Category;
import hh.swd20.calendar.domain.CategoryRepository;
import hh.swd20.calendar.domain.Task;
import hh.swd20.calendar.domain.TaskRepository;

@Controller
public class TaskController {

	@Autowired
	private TaskRepository repository;

	@Autowired
	private CategoryRepository catRepository;

	// RESTful service to get all tasks
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public @ResponseBody List<Task> taskListRest() {
		return (List<Task>) repository.findAll();
	}

	// RESTful service to get on task by id
	@RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Task> findTaskRest(@PathVariable("id") Long id) {
		return repository.findById(id);
	}

	// RESTful service to get all categories
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> catListRest() {
		return (List<Category>) catRepository.findAll();
	}
}
