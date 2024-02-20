package com.kodo.assignment.entity;

import com.kodo.assignment.models.FormField;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "form")
@Getter
public class FormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_id")
    private Integer id;
    private String title;
    private String submitButtonLabel;
    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL)
    private List<FormFieldEntity> formFields;
}
