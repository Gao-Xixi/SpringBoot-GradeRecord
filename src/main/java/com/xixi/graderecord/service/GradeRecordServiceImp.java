package com.xixi.graderecord.service;

import com.xixi.graderecord.entity.GradeRecord;
import com.xixi.graderecord.error.GradeRecordNotFoundException;
import com.xixi.graderecord.repository.GradeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
public class GradeRecordServiceImp implements GradeRecordService{
    @Autowired
    private GradeRecordRepository gradeRecordRepository;
    @Override
    public GradeRecord saveGradeRecord(GradeRecord gradeRecord) {
        if(gradeRecordRepository.findBySubjectAndCode(
                gradeRecord.getSubject(),gradeRecord.getCode()) == null){
            return gradeRecordRepository.save(gradeRecord);
        }
        return null;
    }

    @Override
    public List<GradeRecord> fetchGradeRecordList() {
        return gradeRecordRepository.findAll();
    }

    @Override
    public GradeRecord fetchGradeRecordById(Long gradeId) throws GradeRecordNotFoundException {

        Optional<GradeRecord> gradeRecord = gradeRecordRepository.findById(gradeId);

        if(!gradeRecord.isPresent()){
            throw new GradeRecordNotFoundException();
        }
        return gradeRecord.get();
    }

    @Override
    public void deleteGradeRecordById(Long gradeId) {
        gradeRecordRepository.deleteById(gradeId);
    }

    @Override
    public GradeRecord updateGradeRecord(long gradeId, GradeRecord gradeRecord) {
        GradeRecord gr = gradeRecordRepository.findById(gradeId).get();
        if(gradeRecord.getSubject()!= null &&
                !"".equalsIgnoreCase(gradeRecord.getSubject())){
            gr.setSubject(gradeRecord.getSubject());
        }
        if(gradeRecord.getCode() != null&&
                !"".equalsIgnoreCase(gradeRecord.getCode())){
            gr.setCode(gradeRecord.getCode());
        }
        if(gradeRecord.getGrade() != null &&
                !"".equalsIgnoreCase(gradeRecord.getGrade())){
            gr.setGrade(gradeRecord.getGrade());
        }
        return gradeRecordRepository.save(gr);
    }

    @Override
    public GradeRecord fetchGradeRecordByCourse(String subject, String code) {
        return gradeRecordRepository.findBySubjectAndCode(subject,code);
    }

    @Override
    public List<GradeRecord> fetchGradeRecordBySubject(String subject) {
        return gradeRecordRepository.findAllBySubject(subject);
    }


}
