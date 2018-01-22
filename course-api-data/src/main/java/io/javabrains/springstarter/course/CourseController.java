package io.javabrains.springstarter.course;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService; 
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{id}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String id) {
		Topic t = new Topic(id, "", "");
		course.setTopic(t);
		System.out.println("-------------------------");
		System.out.println(course.getDescription() + ":" + course.getId() + course.getName());
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}/courses/{cid}")
	public void updateTopic(@RequestBody Course t, @PathVariable String id) {
		courseService.updateCourse(t);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}/courses/{cid}")
	public void deleteTopic(@PathVariable String cid) {
		courseService.deleteCourse(cid);
	}
	

}
