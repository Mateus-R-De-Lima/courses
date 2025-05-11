package com.mateus_lima.desafio.courses.course.dto;

import com.mateus_lima.desafio.courses.course.enums.TypeCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCourseResponseDTO {


    private UUID id;
    private String name;
    private TypeCategory category;
    private Boolean active;
}
