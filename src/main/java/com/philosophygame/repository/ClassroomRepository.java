package com.philosophygame.repository;

import com.philosophygame.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    Classroom findByClassroomName(String classroomName);
}
