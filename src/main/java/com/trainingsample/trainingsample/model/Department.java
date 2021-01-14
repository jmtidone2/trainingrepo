package com.trainingsample.trainingsample.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Table(name = "DEPARTMENTS")
public class Department {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @NonNull
   @Column(name = "ID", unique = true, nullable = false)
    private Long Id;

   @NotEmpty(message = "Name cannot be null or empty")
   @Pattern(regexp = "^[ A-Za-z]+$", message = "Only letters allowed")
   @NonNull
   @Column(unique = true, nullable = false)
    private String name;

    @OneToOne(mappedBy = "department")
    private Employee employee;
}
