package com.mateus_lima.desafio.courses.course.useCases;

import com.mateus_lima.desafio.courses.course.dto.CreateCourseRequestDTO;
import com.mateus_lima.desafio.courses.course.dto.CourseResponseDTO;
import com.mateus_lima.desafio.courses.course.entity.CourseEntity;
import com.mateus_lima.desafio.courses.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCourseUseCase {

    private final CourseRepository courseRepository;

    public CourseResponseDTO execute(CreateCourseRequestDTO requestDTO) {
        CourseEntity newCourse = CourseEntity.builder()
                .name(requestDTO.getName())
                .category(requestDTO.getCategory())
                .active(true)
                .build();

        CourseEntity savedCourse = courseRepository.save(newCourse);
        return toResponseDTO(savedCourse);
    }
    // Map
    private CourseResponseDTO toResponseDTO(CourseEntity entity) {
        return CourseResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .category(entity.getCategory())
                .active(entity.getActive())
                .build();
    }
}
