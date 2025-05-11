package com.mateus_lima.desafio.courses.course.controller;

import com.mateus_lima.desafio.courses.course.dto.CreateCourseRequestDTO;
import com.mateus_lima.desafio.courses.course.useCases.CreateCourseUseCase;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateCourseRequestDTO createCourseRequestDTO) {
        try {
            var response = createCourseUseCase.execute(createCourseRequestDTO);
            return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(response);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
