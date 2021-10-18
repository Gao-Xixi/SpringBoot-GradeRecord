# SpringBoot-GradeRecord
Springboot, mysql, thymeleaf

## remain to do: view, mysql, join tables, deploy
### post -- save graderecord
*post:http://localhost:8082/grades/
{
    "subject":"eecs",
    "code":"1023",
    "grade":"B"
}
### get
*get all records: http://localhost:8082/grades/
*get record by id: http://localhost:8082/grades/id/1
*get records by subject: http://localhost:8082/grades/eecs
*get record by subject and code: http://localhost:8082/grades/eecs/1012

### delete
*delete by id: http://localhost:8082/grades/id/1

### put
*update by id: http://localhost:8082/grades/id/1
{
    "subject":"eecs",
    "code":"1023",
    "grade":"A+"
}
