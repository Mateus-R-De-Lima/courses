package com.mateus_lima.desafio.courses.course.controller;

import com.mateus_lima.desafio.courses.course.dto.CreateCourseRequestDTO;
import com.mateus_lima.desafio.courses.course.dto.UpdateCourseRequestDTO;
import com.mateus_lima.desafio.courses.course.useCases.CreateCourseUseCase;
import com.mateus_lima.desafio.courses.course.useCases.DeleteCourseUseCase;
import com.mateus_lima.desafio.courses.course.useCases.GetAllCourseUseCase;
import com.mateus_lima.desafio.courses.course.useCases.UpdateCourseUseCase;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final GetAllCourseUseCase getAllCourseUseCase;
    private final CreateCourseUseCase createCourseUseCase;
    private final UpdateCourseUseCase updateCourseUseCase;
    private final DeleteCourseUseCase deleteCourseUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateCourseRequestDTO createCourseRequestDTO) {
        try {
            var newCourse = createCourseUseCase.execute(createCourseRequestDTO);
            return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(newCourse);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }


    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        try {
            return ResponseEntity.ok().body(this.getAllCourseUseCase.execute());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Object> update(@PathVariable UUID id,@Valid @RequestBody UpdateCourseRequestDTO updateCourseRequestDTO){
        try {
            updateCourseUseCase.execute(id,updateCourseRequestDTO);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public  ResponseEntity<Object> delete(@PathVariable UUID id){
       try {
           deleteCourseUseCase.execute(id);
           return ResponseEntity.noContent().build();
       }catch (Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }


}
