package com.decathlon.alertSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name="DEVELOPER",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"phoneNumber"})
)
public class Developer{

    @Id
    @GeneratedValue
    private Long developerId;


    @NotNull(message = "Name cannot be null")
    @Pattern(regexp="^[\\p{L} .'-]+$",message="Name cannot contain numeric or special characters")
    private String name;


    @NotNull
    @Pattern(regexp="(^$|[0-9]{10})",message="Phone number not valid")
    private  String phoneNumber;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="TEAM_ID")
    @JsonIgnore
    private Team team;
}
