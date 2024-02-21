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
    private Integer id;
    @Builder.Default
    private String label = null;
    private FieldType type;
    private boolean required;
    private FieldConfiguration configuration;

    public FormField convertFormFieldFromEntity(FormFieldEntity formFieldEntity) {
        return FormField.builder()
                .id(formFieldEntity.getId())
                .label(formFieldEntity.getLabel())
                .configuration(new FieldConfiguration().getFieldConfigurationObject(formFieldEntity.getConfiguration()))
                .build();
    }
}
