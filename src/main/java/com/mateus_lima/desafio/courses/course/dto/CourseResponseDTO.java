package com.mateus_lima.desafio.courses.course.dto;

import com.mateus_lima.desafio.courses.course.enums.TypeCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponseDTO {
    private UUID id;
    private String name;
    private TypeCategory category;
    private Boolean active;
}



