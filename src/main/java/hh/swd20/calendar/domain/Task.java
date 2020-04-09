package hh.swd20.calendar.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity 
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private Date time;
	@ManyToOne(fetch = FetchType.LAZY) // when category is fetched, all it's tasks are fetched when needed
	@JoinColumn(name = "category")
	private Category category;
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(String name, String description, Date time, Category category) {
		super();
		this.name = name;
		this.description = description;
		this.time = time;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", time=" + time + "]";
	}
	
	
	
}
