package com.idb.example.microserviceexample.configuration;

import lombok.Data;

@Data
public class ExampleTableConstants {
    public String tableName = "example";
    public String uniqueConstraintsName = "uk_example";
}
