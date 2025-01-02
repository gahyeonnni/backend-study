package org.example.project_demo.controller;

import org.example.project_demo.prac.Prac;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @GetMapping("/courses")
    public Prac.Course getCourses() {
        Prac.Course course = new Prac.Course();
        course.setTitle("웹개발의 봄 스프링");
        course.setDays(35);
        course.setTutor("남병관");
        return course;
    }
}

