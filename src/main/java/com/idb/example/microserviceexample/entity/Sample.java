package com.idb.example.microserviceexample.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name = "sample", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}, name = "uk_sample"))
public class Sample extends BaseSoftDeleteEntity {
    @Column(name = "name", length = 100, nullable = false)
    @NotBlank
    private String name;
}
