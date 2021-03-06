package com.xixi.graderecord.repository;

import com.xixi.graderecord.entity.GradeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRecordRepository extends JpaRepository<GradeRecord, Long> {
    GradeRecord findBySubjectAndCode(String subject, String code);
    List<GradeRecord> findAllBySubject(String subject);
}
