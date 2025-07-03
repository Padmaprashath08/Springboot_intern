package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext student=new ClassPathXmlApplicationContext("resources.xml");
        Studentpersonaldetails s= (Studentpersonaldetails) student.getBean("stp");
        s.studentdetails("padmaprashath","padmaprashath@gamil.com",20);
        Studenteducationdetails sed= (Studenteducationdetails) student.getBean("ste");
        sed.educationdetails();
        Studentparentdetails spd= (Studentparentdetails) student.getBean("st");
        spd.parentdetails();
    }
}
