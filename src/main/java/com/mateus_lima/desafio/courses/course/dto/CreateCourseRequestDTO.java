package com.mateus_lima.desafio.courses.course.dto;

import com.mateus_lima.desafio.courses.course.enums.TypeCategory;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@Data
public class CreateCourseRequestDTO {
    @NotBlank(message = "O nome do curso não pode ser nulo ou vazio.")
    @Length(min = 6, max = 150, message = "Por favor, insira uma senha válida (entre 6 e 150 caracteres)")
    private String name;

    // TODO: Encontra uma maneira de validar o ENUM Com alguma Anotation
    @NotNull(message = "Category é obrigatório.")
    private TypeCategory category;

}


