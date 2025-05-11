package com.mateus_lima.desafio.courses.course.useCases;

import com.mateus_lima.desafio.courses.course.dto.CreateCourseRequestDTO;
import com.mateus_lima.desafio.courses.course.dto.CreateCourseResponseDTO;
import com.mateus_lima.desafio.courses.course.entity.CourseEntity;
import com.mateus_lima.desafio.courses.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseUseCase {


    @Autowired
    private CourseRepository courseRepository;

    public CreateCourseResponseDTO execute(CreateCourseRequestDTO createCourseRequestDTO){

       var newCourse = CourseEntity.builder()
               .name(createCourseRequestDTO.getName())
               .category(createCourseRequestDTO.getCategory())
               .active(true)
               .build();

       var response = this.courseRepository.save(newCourse);

        return  CreateCourseResponseDTO.builder()
               .id(response.getId())
               .active(response.getActive())
               .category(response.getCategory())
               .name(response.getName())
               .build();

    }
}
