package com.practice.course_data.topic.controller;

import com.practice.course_data.topic.Topic;
import com.practice.course_data.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicservice;

    @RequestMapping(value = "/topics",method = RequestMethod.GET)
    public List<Topic> getAllTopics(){
        return topicservice.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Optional<Topic> getTopicById(@PathVariable String id){
        return topicservice.getTopicById(id);
    }

    @RequestMapping(method =POST, value = "/topics")
    public void  addTopic(@RequestBody Topic topic){
        topicservice.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic,@PathVariable String id){
        topicservice.updateTopic(topic,id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicservice.deleteTopic(id);
    }


}
