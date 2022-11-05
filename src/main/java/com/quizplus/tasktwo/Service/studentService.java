package com.quizplus.tasktwo.Service;

import com.quizplus.tasktwo.Models.Student;
import com.quizplus.tasktwo.Rerpositry.StudentRepo;

import java.util.List;

public class studentService {
    private StudentRepo studentRepo;

    public studentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> findall() {
        // TODO Auto-generated method stub
        return studentRepo.finaAll();
    }
    public Student findById(int theId) {
        // TODO Auto-generated method stub
        return studentRepo.findById(theId);
    }
    public void save(Student theStudent) {
        // TODO Auto-generated method stub
        studentRepo.save(theStudent);

    }

    public void deleateById(int theId) {
        // TODO Auto-generated method stub
        studentRepo.deleateById(theId);
    }



}
