package hh.swd20.calendar.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

	List<Task> findByName(String name);
}
