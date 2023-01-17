package com.bank.authorization.dto;

import com.bank.authorization.model.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * A DTO for the {@link AuditEntity} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditDto implements Serializable {
    private Long id;
    @NotNull
    private String entityType;
    @NotNull
    private String operationType;
    @NotNull
    private String createdBy;
    private String modifiedBy;
    @NotNull
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;
    private String newEntityJson;
    @NotNull
    private String entityJson;
}
