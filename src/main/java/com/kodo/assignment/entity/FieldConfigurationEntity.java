package com.kodo.assignment.entity;

import com.kodo.assignment.models.FieldType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "field_config")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FieldConfigurationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "max_size")
    private Integer maxSize;
    @Column(name = "min_size")
    private Integer minSize;
    @Column(name = "integer_only")
    private boolean integerOnly;
    @Enumerated(EnumType.STRING)
    private FieldType type;
    private boolean required;
}
