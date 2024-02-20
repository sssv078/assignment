package com.kodo.assignment.repository;

import com.kodo.assignment.entity.FieldConfigurationEntity;
import com.kodo.assignment.entity.FormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldConfigurationRepository extends JpaRepository<FieldConfigurationEntity, Long> {
}
