package com.services;

import com.entity.Student;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import java.util.Optional;

@AllArgsConstructor
@Log
@Service
public class StudentRepositoryService {
    @Autowired
    private final StudentRepository studentRepository;

    public int createStudent(String name, String surname, Integer age, String email){
        if(name == null || surname == null || age == null || email == null) {
            return 0;
        }

        Student student = new Student(studentRepository.count() + 1, name, surname, age, email);
        studentRepository.save(student);

        return 1;
    }

    public int deleteStudent(Long id){
        try {
            studentRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            return 0;
        }
        catch (IllegalArgumentException e) {
            return 0;
        }
        return 1;
    }

    public int updateStudent(Long id, String name, String surname, Integer age, String email) {
        Student student;

        try {
            student = studentRepository.getOne(id);
        } catch (InvalidDataAccessApiUsageException e) {
            return 0;
        }

        if(!studentRepository.existsById(id)) {
            return 0;
        }

        if(name == null || surname == null || age == null || email == null) {
            return 0;
        }

        student = new Student(id, name, surname, age, email);
        studentRepository.save(student);

        return 1;
    }

    public Student readStudent(long id){
        Optional<Student> o = studentRepository.findById(id);
        final Student[] s = new Student[1];
        o.ifPresent( student -> {
            s[0] = student;
        });
        return s[0];
    }

    public long countObject(){
        return studentRepository.count();
    }

}
