package com.kodo.assignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "form")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
