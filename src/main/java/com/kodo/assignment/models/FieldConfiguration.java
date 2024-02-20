package com.kodo.assignment.models;

import com.kodo.assignment.entity.FieldConfigurationEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FieldConfiguration {
    private Integer maxSize;
    private Integer minSize;
    private boolean IntegerOnly;
    private FieldType fieldType;
    private boolean required;

    public FieldConfiguration getFieldConfigurationObject(FieldConfigurationEntity fieldConfigurationEntity) {
        return FieldConfiguration.builder()
                .maxSize(fieldConfigurationEntity.getMaxSize())
                .minSize(fieldConfigurationEntity.getMinSize())
                .IntegerOnly(fieldConfigurationEntity.isIntegerOnly())
                .fieldType(fieldConfigurationEntity.getType())
                .required(fieldConfigurationEntity.isRequired())
                .build();

    }
}
