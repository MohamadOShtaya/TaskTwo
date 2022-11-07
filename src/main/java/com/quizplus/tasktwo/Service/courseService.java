package com.quizplus.tasktwo.Service;

import com.quizplus.tasktwo.Models.Course;
import com.quizplus.tasktwo.Rerpositry.CourseRepo;

import java.util.List;

public class courseService {
    private CourseRepo courseRepo;

    public courseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public List<Course> findall() {
        // TODO Auto-generated method stub

        return courseRepo.finaAll();

    }
    public Course findById(int theId) {
        return courseRepo.findById(theId);
    }
    public void save(Course course){
        courseRepo.save(course);
    }
    public void deleateById(int theId) {
        // TODO Auto-generated method stub
        courseRepo.deleteById(theId);
    }



}
