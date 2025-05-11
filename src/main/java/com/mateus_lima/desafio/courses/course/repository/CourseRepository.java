package com.mateus_lima.desafio.courses.course.repository;

import com.mateus_lima.desafio.courses.course.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {


}
