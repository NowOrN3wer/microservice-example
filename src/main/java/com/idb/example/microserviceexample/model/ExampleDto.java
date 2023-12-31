package com.idb.example.microserviceexample.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ExampleDto extends BaseDto {
    @NotBlank
    private String name;
}
