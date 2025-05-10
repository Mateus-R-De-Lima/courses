package com.mateus_lima.desafio.courses.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {
    private  String menssage;
    private  String field;
}
