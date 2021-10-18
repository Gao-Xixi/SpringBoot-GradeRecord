package com.xixi.graderecord.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gradeId;
    private String subject;
    private String code;
    private String grade;
}
