package com.mateus_lima.desafio.courses.course.controller;

import com.mateus_lima.desafio.courses.course.dto.CreateCourseRequestDTO;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateCourseRequestDTO createCourseRequestDTO){
        try {
          return   ResponseEntity.status(HttpServletResponse.SC_CREATED).body(createCourseRequestDTO);
        }catch (Exception exception){
            return  ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
