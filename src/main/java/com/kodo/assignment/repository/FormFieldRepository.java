package com.kodo.assignment.repository;

import com.kodo.assignment.entity.FormFieldEntity;
import com.kodo.assignment.models.FormField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormFieldRepository extends JpaRepository<FormFieldEntity, Integer> {
}
