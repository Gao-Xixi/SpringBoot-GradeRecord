package com.xixi.graderecord.repository;

import com.xixi.graderecord.entity.GradeRecord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
/*
Still Having Problems!
Reminder: GradeRecord is stored in the Real DataBase!
Delete this row after testing
 */

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GradeRecordRepositoryTest {
    @Autowired
    private GradeRecordRepository gradeRecordRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
//        GradeRecord gradeRecord = GradeRecord.builder()
//                .subject("ADMS")
//                .code("1014")
//                .grade("A+")
//                .build();
//
//        entityManager.persist((gradeRecord));
    }

    @Test
    public void test_findById(){
        System.out.println(gradeRecordRepository.findAll());
        GradeRecord gradeRecord = gradeRecordRepository.findById(5L).get();
        assertEquals(gradeRecord.getSubject(), "ADMS");
    }

    @AfterEach
    void tearDown() {
        gradeRecordRepository.deleteById(5L);
    }
}