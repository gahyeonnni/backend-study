package org.example.project_demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PersonRequestDto {
    private String name;
    private String job;
    private int age;
    private String address;
}
