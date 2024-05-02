package com.example.demo.service;

import org.hibernate.annotations.TimeZoneStorage;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class CourseServiceTestNaive {
   
@Autowired
private CourseServiceTestNaive courseservice;


@Test
public void CourseService_createCourse_Course(){

    Course course = new Course ("Gatito");
    Course course2 = new Course ("Gatoto");

    Course newCourse = courseService.createCourse(course);
    newCourse = courseService.createCourse(course2);
   
    Assertions.assertThat(newCourse).isNotNull();
}

  

}
    

