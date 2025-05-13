package com.mateus_lima.desafio.courses.course.useCases;

import com.mateus_lima.desafio.courses.course.entity.CourseEntity;
import com.mateus_lima.desafio.courses.course.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatchCourseUseCase {

    private final CourseRepository courseRepository;


    public void execute(UUID courseId){

        CourseEntity existingCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));

        existingCourse.setActive(!existingCourse.getActive());

        courseRepository.save(existingCourse);


    }
}
