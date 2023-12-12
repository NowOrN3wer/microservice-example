package com.idb.example.microserviceexample.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ExampleDto extends BaseModel {
    @NotBlank
    private String name;
}
