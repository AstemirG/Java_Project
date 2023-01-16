package com.bank.authorization.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;

@Entity
@Table(name = "audit", schema = "authorization")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Size(max = 40)
    @NotNull
    @Column(name = "entity_type",nullable = false,length = 40)
    private String entityType;

    @Size(max = 255)
    @NotNull
    @Column(name = "operation_type",nullable = false)
    private String operationType;

    @Size(max = 255)
    @NotNull
    @Column(name = "created_by",nullable = false)
    private String createdBy;

    @Size(max = 255)
    @Column(name = "modified_by")
    private String modifiedBy;

    @NotNull
    @Column(name = "created_at",nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "modified_at")
    private OffsetDateTime modifiedAt;

    @Column(name = "new_entity_json")
    @Type(type = "org.hibernate.type.TextType")
    private String newEntityJson;

    @NotNull
    @Column(name = "entity_json",nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String entityJson;
}