package com.xixi.graderecord.controller;

import com.xixi.graderecord.entity.GradeRecord;
import com.xixi.graderecord.service.GradeRecordService;
import com.xixi.graderecord.service.GradeRecordServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GradeRecordController {

    @Autowired
    private GradeRecordService gradeRecordService;
    @PostMapping("/grades")
    public <Optional>GradeRecord saveGradeRecord(@RequestBody GradeRecord gradeRecord){
        return gradeRecordService.saveGradeRecord(gradeRecord);
    }
    @GetMapping("/grades")
    public List<GradeRecord> fetchGradeRecordList(){
        return gradeRecordService.fetchGradeRecordList();
    }
    @GetMapping("/grades/id/{id}")
    public GradeRecord fetchGradeRecordById(@PathVariable("id") Long gradeId){
        return gradeRecordService.fetchGradeRecordById(gradeId);
    }
    @DeleteMapping("/grades/id/{id}")
    public String deleteGradeRecordById(@PathVariable("id") Long gradeId){
        gradeRecordService.deleteGradeRecordById(gradeId);
        return "GradeRecord deleted Successfully!!";
    }

    @PutMapping("/grades/id/{id}")
    public GradeRecord updateGradeRecord(@PathVariable("id") long gradeId,
                                         @RequestBody GradeRecord gradeRecord){
        return gradeRecordService.updateGradeRecord(gradeId, gradeRecord);
    }


    @GetMapping("/grades/{subject}/{code}")
    public GradeRecord fetchGradeRecordByCourse(@PathVariable("subject") String subject,
                                                @PathVariable("code") String code){
        return gradeRecordService.fetchGradeRecordByCourse(subject,code);

    }

    @GetMapping("/grades/{subject}")
    public List<GradeRecord> fetchGradeRecordBySubject(@PathVariable("subject") String subject){
        return gradeRecordService.fetchGradeRecordBySubject(subject);

    }
}
