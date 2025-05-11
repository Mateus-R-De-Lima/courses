package com.mateus_lima.desafio.courses.course.useCases;

import com.mateus_lima.desafio.courses.course.dto.CourseResponseDTO;
import com.mateus_lima.desafio.courses.course.entity.CourseEntity;
import com.mateus_lima.desafio.courses.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllCourseUseCase {

    private final CourseRepository courseRepository;

    public List<CourseResponseDTO> execute() {
        return courseRepository.findAll()
                .stream()
                .map(course -> CourseResponseDTO.builder()
                        .id(course.getId())
                        .name(course.getName())
                        .category(course.getCategory())
                        .active(course.getActive())
                        .build()
                )
                .toList();
    }

}
