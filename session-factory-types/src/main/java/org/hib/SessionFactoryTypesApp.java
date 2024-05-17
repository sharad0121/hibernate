package org.hib;

import org.hib.StudentDao;

/**
 * Hello world!
 *
 */
public class SessionFactoryTypesApp
{
    public static void main(String[] args){
        StudentDao studentDao =  new StudentDao();
        // test getAllStudents() method is working
        studentDao.getAllStudents();
    }}
