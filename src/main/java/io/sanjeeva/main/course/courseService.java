package io.sanjeeva.main.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.sanjeeva.main.controller.Topic;

@Service
public class courseService {
    @Autowired
   	private CourseRepository courseRepository; 
	
	/*
	 * private List<Course> topics = new ArrayList<>( Arrays.asList(new
	 * Topic("spring", "Spring Framework", "springdescripption"), new Topic("Java",
	 * "Java 1.8 versio", "Java description"), new Topic("phyton",
	 * "latest version of it", "python description")));
	 */

	public List<Course> getAllCourses(String topicId) {
		
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses:: add);
		return courses;
	}

	public Course getCourse(String id) {

		return courseRepository.findById(id).get();
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		

	}

	public void addCourse(Course course) {

		courseRepository.save(course);
		//topics.add(topic);

	}

	public void updateCourseById( Course course) {

		/*
		 * for (int i = 0; i < topics.size(); i++) { Topic t = topic; if
		 * (t.getId().equals(test)) { topics.set(i, topic); return; } }
		 */
		courseRepository.save(course); 
	}

	public void deleteCourseById(String id) {

		//topics.removeIf(n -> n.getId().equals(id));
		courseRepository.deleteById(id);
		
	}

}
