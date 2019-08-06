/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classrosterr;

import com.mycompany.classrosterr.controller.ClassRosterController;
import com.mycompany.classrosterr.dao.ClassRosterAuditDao;
import com.mycompany.classrosterr.dao.ClassRosterAuditDaoFileImpl;
import com.mycompany.classrosterr.dao.ClassRosterDao;
import com.mycompany.classrosterr.dao.ClassRosterDaoFileImpl;
import com.mycompany.classrosterr.service.ClassRosterServiceLayer;
import com.mycompany.classrosterr.service.ClassRosterServiceLayerImpl;
import com.mycompany.classrosterr.ui.ClassRosterView;
import com.mycompany.classrosterr.ui.UserIO;
import com.mycompany.classrosterr.ui.UserIOConsoleImpl;


/**
 *
 * @author leeva
 */
public class App {
public static void main(String[] args) {
    // Instantiate the UserIO implementation
    UserIO myIo = new UserIOConsoleImpl();
    // Instantiate the View and wire the UserIO implementation into it
    ClassRosterView myView = new ClassRosterView(myIo);
    // Instantiate the DAO
    ClassRosterDao myDao = new ClassRosterDaoFileImpl();
    // Instantiate the Audit DAO
    ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
    // Instantiate the Service Layer and wire the DAO and Audit DAO into it
    ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
    // Instantiate the Controller and wire the Service Layer into it
    ClassRosterController controller = new ClassRosterController(myService, myView);
    // Kick off the Controller
    controller.run();
}
}