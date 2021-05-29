package io.sanjeeva.main.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class topicService {
    @Autowired
   	private TopicRepository topicRepository; 
	
	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("spring", "Spring Framework", "springdescripption"),
					new Topic("Java", "Java 1.8 versio", "Java description"),
					new Topic("phyton", "latest version of it", "python description")));

	public List<Topic> getAllTopics() {
		
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics:: add);
		return topics;
	}

	public Topic getTopic(String id) {

		return topicRepository.findById(id).get();
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		

	}

	public void addTopic(Topic topic) {

		topicRepository.save(topic);
		//topics.add(topic);

	}

	public void updateTopicById(String test, Topic topic) {

		/*
		 * for (int i = 0; i < topics.size(); i++) { Topic t = topic; if
		 * (t.getId().equals(test)) { topics.set(i, topic); return; } }
		 */
		topicRepository.save(topic); 
	}

	public void deleteTopicById(String id) {

		//topics.removeIf(n -> n.getId().equals(id));
		topicRepository.deleteById(id);
		
	}

}
