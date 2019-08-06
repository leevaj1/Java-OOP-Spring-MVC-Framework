/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classrosterr.service;

import com.mycompany.classrosterr.dao.ClassRosterPersistenceException;
import com.mycompany.classrosterr.dto.Student;
import java.util.List;

/**
 *
 * @author leeva
 */
public interface ClassRosterServiceLayer {

    void createStudent(Student student) throws
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException;
    

    List<Student> getAllStudents() throws
            ClassRosterPersistenceException;

    Student getStudent(String studentId) throws
            ClassRosterPersistenceException;

    Student removeStudent(String studentId) throws
            ClassRosterPersistenceException;

    public void addStudent(String studentId, Student newStudent);
}
