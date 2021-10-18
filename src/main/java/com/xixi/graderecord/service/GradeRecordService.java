package com.xixi.graderecord.service;

import com.xixi.graderecord.entity.GradeRecord;
import com.xixi.graderecord.error.GradeRecordNotFoundException;

import java.util.List;
import java.util.Optional;

public interface GradeRecordService {
    GradeRecord saveGradeRecord(GradeRecord gradeRecord);

    List<GradeRecord> fetchGradeRecordList();

    GradeRecord fetchGradeRecordById(Long gradeId) throws GradeRecordNotFoundException;

    void deleteGradeRecordById(Long gradeId);

    GradeRecord updateGradeRecord(long gradeId, GradeRecord gradeRecord);

    GradeRecord fetchGradeRecordByCourse(String subject, String Code);

    List<GradeRecord> fetchGradeRecordBySubject(String subject);
}
