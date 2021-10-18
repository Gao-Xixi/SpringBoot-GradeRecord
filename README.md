# SpringBoot-GradeRecord
Springboot, mysql, thymeleaf

## remain to do: view, mysql, join tables, deploy
### post -- save graderecord
post:http://localhost:8082/grades/
```
{
    "subject":"eecs",
    "code":"1023",
    "grade":"B"
}
```
### get
- get all records: http://localhost:8082/grades/
- get record by id: http://localhost:8082/grades/id/1
- get records by subject: http://localhost:8082/grades/eecs
- get record by subject and code: http://localhost:8082/grades/eecs/1012

### delete
 delete by id: http://localhost:8082/grades/id/1

### put
 update by id: http://localhost:8082/grades/id/1
```
{
    "subject":"eecs",
    "code":"1023",
    "grade":"A+"
}
```

### validation
```
@NotBlank
@length(max =, min =)
private String Code;
```
### logger
```
private final Logger LOGGER = LoggerFactoral.getLogger(GradeRecord.class);
LOGGER.info(" ")
```
### Unit Tests
- Service
```
@MockBean
    private GradeRecordRepository gradeRecordRepository;
```
- Repository
```
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Autowired
    private TestEntityManager entityManager;
    
    entityManager.persist((gradeRecord));
```
