package com.kodo.assignment.repository;

import com.kodo.assignment.entity.FormEntity;
import com.kodo.assignment.models.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<FormEntity, Integer> {
}
