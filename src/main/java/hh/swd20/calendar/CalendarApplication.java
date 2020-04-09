package hh.swd20.calendar;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.calendar.domain.Category;
import hh.swd20.calendar.domain.CategoryRepository;
import hh.swd20.calendar.domain.Task;
import hh.swd20.calendar.domain.TaskRepository;

@SpringBootApplication
public class CalendarApplication {

	private static final Logger log = LoggerFactory.getLogger(CalendarApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CalendarApplication.class, args);
	}

	@Bean

	public CommandLineRunner taskDemo(TaskRepository taskRepo, CategoryRepository catRepo) {
		return (args) -> {
			log.info("save demo data");
			catRepo.save(new Category("Työ"));
			catRepo.save(new Category("Koulu"));
			catRepo.save(new Category("Vapaa-aika"));
			catRepo.save(new Category("Merkkipäivät"));
			catRepo.save(new Category("Treenit"));
			
			// tallennetaan demodataa tietokantaan
			taskRepo.save(new Task("Spinning", "Spinning-tunti Kampin Elixiassa", new Date(), catRepo.findByName("Treenit").get(0)));
			taskRepo.save(new Task("Synttärikahvit", "Jee synttärit!", new Date(), catRepo.findByName("Merkkipäivät").get(0)));

			log.info("fetch all tasks");
			for (Task task : taskRepo.findAll()) {
				log.info(task.toString());
			}
		};
	}
}
