package com.idb.example.microserviceexample.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class SampleDto extends BaseSoftDeleteDto {
    @NotBlank
    private String name;
}
