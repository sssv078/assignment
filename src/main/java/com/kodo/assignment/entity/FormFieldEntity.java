package com.kodo.assignment.entity;

import com.kodo.assignment.models.FieldType;
import com.kodo.assignment.models.Form;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "field")
@Getter
public class FormFieldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String label;
    @Enumerated(EnumType.STRING)
    private FieldType type;
    private boolean required;
    @OneToOne(cascade = CascadeType.ALL)
    private FieldConfigurationEntity configuration;
    @ManyToOne
    @JoinColumn(name = "form_id")
    private FormEntity form;

}
