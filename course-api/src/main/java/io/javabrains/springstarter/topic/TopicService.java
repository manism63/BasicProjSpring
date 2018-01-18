package io.javabrains.springstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring", "Spring Framework", "Spring Framework Description"),
			new Topic("Java", "Java 8", "Java 8 Description"),
			new Topic("JavaScript", "ES6", "ES6 Description")
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		for(Topic t : topics) {
			if(t.getId().equals(id)) {
				return t;
			}
		}
		return new Topic();
	}
	
	public void addTopic(Topic t) {
		topics.add(t);
	}

	public void updateTopic(Topic topic, String id) {
		
		for(Topic t : topics) {
			if(t.getId().equals(id)) {
				t.setDesc(topic.getDesc());
				t.setName(topic.getName());
				break;
			}
		}
		
	}

	public void deleteTopic(String id) {
		Iterator<Topic> it = topics.iterator();
		while(it.hasNext()) {
			if(id.equals(it.next().getId())) {
				it.remove();
				return;
			}
		}
		
	}
}
