package com.trainingsample.trainingsample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Table(name = "EMPLOYEES")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Column(name = "ID", unique = true, nullable = false)
    private Long Id;

    @NotEmpty(message = "Name cannot be null or empty")
    @NonNull
    @Pattern(regexp = "^[ A-Za-z]+$", message = "Only letters allowed")
    @Column(unique = true, nullable = false)
    private String name;

    @DecimalMin(value = "0.00", message = "Salary cannot be negative")
    @NonNull
    private Double salary;

    //@OneToOne(mappedBy = "employee")
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;
}
