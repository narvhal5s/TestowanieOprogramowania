package com.services;

import com.entity.Student;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Log
@Service
public class StudentRepositoryService {
    @Autowired
    private final StudentRepository studentRepository;

    public long saveStudent(Student student){
        studentRepository.save(student);
        return 1;
    }

    public long countObject(){
        return studentRepository.count();
    }

}
