package com.kodo.assignment.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "field_config")
@Getter
public class FieldConfigurationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer maxSize;
    private Integer minSize;
    private boolean IntegerOnly;

}
