package org.hib;

public class TestStudentDao{
    public static void main(String[] args){
        StudentDao studentDao =  new StudentDao();
        // test getAllStudents() method is working
        studentDao.getAllStudents();
    }
}