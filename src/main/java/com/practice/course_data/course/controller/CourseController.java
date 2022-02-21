package com.practice.course_data.course.controller;

import com.practice.course_data.course.topic.Course;
import com.practice.course_data.course.topic.CourseService;
import com.practice.course_data.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/topics")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId){
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/{topicId}/courses/{courseId}")
    public Optional<Course> getCourse(@PathVariable String courseId){
        return courseService.getCourse(courseId);
    }

    @RequestMapping(method =POST, value = "/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId,""," "));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{topicId}/courses/{courseId}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId,@PathVariable String courseId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{topicId}/courses/{courseId}")
    public void deleteTopic(@PathVariable String courseId){
        courseService.deleteCourse(courseId);
    }


}