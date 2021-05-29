package io.sanjeeva.main.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class topicController {

	@Autowired
	private topicService topicService; 
	
	@RequestMapping("/topics")
	public List<Topic> topicsList() {
		return topicService.getAllTopics(); 	
	}
	@RequestMapping("/topics/{test}")
	public Topic getTopic(@PathVariable("test") String id) {
		return topicService.getTopic(id);
		
	}
	@RequestMapping(method=RequestMethod.POST ,value="/topics")
	public void addingTopic(@RequestBody Topic topic) {
		 topicService.addTopic(topic);		
	}
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{test}")
	public void updateTopic(@RequestBody Topic topic ,@PathVariable String test) {
		 topicService.updateTopicById(test,topic);
		
	}
	@RequestMapping(method=RequestMethod.DELETE ,value="/topics/{test}")
	public void deleteTopic(@PathVariable("test") String id) {
		 topicService.deleteTopicById(id);
		
	}
	
}
