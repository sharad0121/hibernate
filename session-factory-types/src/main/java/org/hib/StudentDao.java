package org.hib;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.*;

public class StudentDao 
{
    public List<Student> getAllStudents() {
    Session session =  SessionUtil.getSessionFromJavaConfig();
    List<Student> students =  new ArrayList<>();
    Student student = null;
    Transaction transaction = session.beginTransaction();
    student = (Student)session.get(Student.class, Long.valueOf(2));
    students.add(student);
   students.forEach(t->{
        System.out.println(t.toString());
   });
  
    //session.get(new Long(1), Student.class);
    transaction.commit();
    session.close();
    return students;
}
}
