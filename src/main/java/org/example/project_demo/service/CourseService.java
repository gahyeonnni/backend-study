package org.example.project_demo.service;

import lombok.RequiredArgsConstructor;
import org.example.project_demo.domain.Course;
import org.example.project_demo.domain.CourseRepository;
import org.example.project_demo.models.CourseRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Target;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Transactional
    public Long update(Long id, CourseRequestDto requestDto) {
        Course course1 = courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        course1.update(requestDto);
        return course1.getId();
    }
}