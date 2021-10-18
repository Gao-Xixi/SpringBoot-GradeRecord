package com.xixi.graderecord.service;

import com.xixi.graderecord.entity.GradeRecord;
import com.xixi.graderecord.repository.GradeRecordRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GradeRecordServiceTest {
    @Autowired
    private GradeRecordService gradeRecordService;
    @MockBean
    private GradeRecordRepository gradeRecordRepository;;
    @BeforeEach
    void setUp() {
        GradeRecord gradeRecord = GradeRecord.builder()
                                    .subject("EECS")
                                    .code("1012")
                                    .grade("A+")
                                    .build();
         Mockito.when(gradeRecordRepository.findBySubjectAndCode("EECS", "1012"))
            .thenReturn(gradeRecord);

    }
    @Test
    @DisplayName("Get Data based on course info")
    public void test_fetchGradeRecordByCourse(){
        String subject = "EECS";
        String code = "1012";
        GradeRecord found = gradeRecordService.fetchGradeRecordByCourse(subject,code);
        assertEquals(subject, found.getSubject());
        assertEquals(code, found.getCode());
    }
}