package com.pichlera.service;

import com.pichlera.domain.Student;
import com.pichlera.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Student.
 */
@Service
@Transactional
public class StudentService {

    private int count = 0;

    private final String TUGRAZ = "30";

    private String matrikelnumber = "";

    private final Logger log = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Save a student.
     *
     * @param student the entity to save
     * @return the persisted entity
     */
    public Student saveStudentCreate(Student student) {
        log.debug("Request to save Student : {}", student);
        student.setMatrikelnummer(getGeneratedMatricelNumber());
        return studentRepository.save(student);
    }

    /**
     * Save a student by Update.
     *
     * @param student the entity to save
     * @return the persisted entity
     */
    public Student save(Student student) {
        log.debug("Request to save Student : {}", student);
        return studentRepository.save(student);
    }

    /**
     * Get all the students.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        log.debug("Request to get all Students");
        return studentRepository.findAll();
    }


    /**
     * Get one student by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Student> findOne(Long id) {
        log.debug("Request to get Student : {}", id);
        return studentRepository.findById(id);
    }

    /**
     * Delete the student by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Student : {}", id);
        studentRepository.deleteById(id);
    }

    private String getMatricelNumberYear(){
        DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
        String formattedDate = df.format(Calendar.getInstance().getTime());
        return formattedDate;
    }

    private Long getGeneratedMatricelNumber(){
        String year = getMatricelNumberYear();
        long generatedMatrikelnummer = 0;
        this.matrikelnumber = year + TUGRAZ + String.format("%03d", count);
        try{
            generatedMatrikelnummer = Long.valueOf(this.matrikelnumber);
        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        count++;

        return generatedMatrikelnummer;
    }
}
