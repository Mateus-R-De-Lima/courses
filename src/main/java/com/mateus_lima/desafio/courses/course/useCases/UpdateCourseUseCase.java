package com.mateus_lima.desafio.courses.course.useCases;

import com.mateus_lima.desafio.courses.course.dto.CourseResponseDTO;
import com.mateus_lima.desafio.courses.course.dto.UpdateCourseRequestDTO;
import com.mateus_lima.desafio.courses.course.entity.CourseEntity;
import com.mateus_lima.desafio.courses.course.mapper.CourseMapper;
import com.mateus_lima.desafio.courses.course.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateCourseUseCase {

    private final CourseRepository courseRepository;

    private final CourseMapper courseMapper;

    //TODO: Melhorar as validações

    public CourseResponseDTO execute(UUID courseId ,UpdateCourseRequestDTO updateCourseRequestDTO){

        CourseEntity existingCourse = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));

        courseMapper.applyUpdates(existingCourse,updateCourseRequestDTO);

        CourseEntity updateCourse = courseRepository.save(existingCourse);

       return courseMapper.toResponseDTO(updateCourse);
    }


}
