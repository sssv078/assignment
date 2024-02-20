package com.kodo.assignment.models;

import com.kodo.assignment.entity.FormFieldEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FormField {
    private String label;
    private FieldType type;
    private boolean required;
    private FieldConfiguration configuration;

    public FormField convertFormFieldFromEntity(FormFieldEntity formFieldEntity) {
        return FormField.builder()
                .label(formFieldEntity.getLabel())
                .type(formFieldEntity.getType())
                .required(formFieldEntity.isRequired())
                .configuration(new FieldConfiguration().getFieldConfigurationObject(formFieldEntity.getConfiguration()))
                .build();
    }
}
