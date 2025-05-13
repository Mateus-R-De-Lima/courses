package com.mateus_lima.desafio.courses.course.mapper;

import com.mateus_lima.desafio.courses.course.dto.CourseResponseDTO;
import com.mateus_lima.desafio.courses.course.dto.CreateCourseRequestDTO;
import com.mateus_lima.desafio.courses.course.dto.UpdateCourseRequestDTO;
import com.mateus_lima.desafio.courses.course.entity.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseResponseDTO toResponseDTO(CourseEntity entity) {
        if (entity == null) return null;

        return CourseResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .category(entity.getCategory())
                .active(entity.getActive())
                .build();
    }

    public CourseEntity toEntity(CreateCourseRequestDTO dto) {
        if (dto == null) return null;

        return CourseEntity.builder()
                .name(dto.getName())
                .category(dto.getCategory())
                .active(true) // default para novo curso
                .build();
    }

    public CourseEntity applyUpdates(CourseEntity entity, UpdateCourseRequestDTO dto) {
        entity.setName(dto.getName());
        entity.setCategory(dto.getCategory());
        entity.setActive(dto.getActive());
        return entity;
    }

}
