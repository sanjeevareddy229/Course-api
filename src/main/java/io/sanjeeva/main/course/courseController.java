package io.sanjeeva.main.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.sanjeeva.main.controller.Topic;

@RestController 
public class courseController {

	@Autowired
	private courseService courseService; 
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> topicsList(@PathVariable String topicId) {
		return courseService.getAllCourses(topicId); 	
	}
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getTopic(@PathVariable String id) {
		return courseService.getCourse(id);
		
	}
	@RequestMapping(method=RequestMethod.POST ,value="/topics/{topicId}/courses")
	public void addingCourse(@RequestBody Course course, @PathVariable String topicId ) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);		
	}
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateTopic(@RequestBody Course course ,@PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourseById(course);
		
	}
	@RequestMapping(method=RequestMethod.DELETE ,value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourseById(id);
		
	}
	
}
