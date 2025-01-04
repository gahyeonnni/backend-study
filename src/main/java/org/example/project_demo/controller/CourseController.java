package org.example.project_demo.controller;

import lombok.RequiredArgsConstructor;
import org.example.project_demo.domain.Course;
import org.example.project_demo.domain.CourseRepository;
import org.example.project_demo.models.CourseRequestDto;
import org.example.project_demo.prac.Prac;
import org.example.project_demo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CourseController {

    private final CourseRepository courseRepository;
    private final CourseService courseService;

    @GetMapping("/api/courses")
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    @PostMapping("/api/courses")
    public Course createCourse(@RequestBody CourseRequestDto requestDto) {
        Course course = new Course(requestDto);
        return courseRepository.save(course);
    }

    @PutMapping("/api/courses/{id}")
    public Long updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto) {
        return courseService.update(id, requestDto);
    }

    @DeleteMapping("/api/courses/{id}")
    public Long deleteCourse(@PathVariable Long id){
        courseRepository.deleteById(id);
        return id;
    }
    /*
    @GetMapping("/courses")
    public Prac.Course getCourses() {
        Prac.Course course = new Prac.Course();
        course.setTitle("웹개발의 봄 스프링");
        course.setDays(35);
        course.setTutor("남병관");
        return course;
    } */
}

