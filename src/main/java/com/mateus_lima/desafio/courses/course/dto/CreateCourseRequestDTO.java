package com.mateus_lima.desafio.courses.course.dto;

import com.mateus_lima.desafio.courses.course.enums.TypeCategory;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data

public class CreateCourseRequestDTO {
    @NotBlank(message = "O nome do curso não pode ser nulo ou vazio.")
    @Length(min = 6, max = 150, message = "Por favor, insira uma senha válida (entre 6 e 150 caracteres)")
    private String name;

    private TypeCategory category;

}
