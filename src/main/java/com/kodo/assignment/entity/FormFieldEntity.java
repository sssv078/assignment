package com.kodo.assignment.entity;

import com.kodo.assignment.models.FieldType;
import com.kodo.assignment.models.Form;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "field")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormFieldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String label;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "configuration_id")
    private FieldConfigurationEntity configuration;
    @ManyToOne
    @JoinColumn(name = "form_id")
    private FormEntity form;

}
