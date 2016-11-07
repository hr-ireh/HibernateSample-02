package ir.hri.view;

import ir.hri.Entity.Address;
import ir.hri.Entity.Student;
import ir.hri.bl.StudentBusiness;
import ir.hri.exception.DaoException;

public class App {
    public static void main(String[] args) {
        StudentBusiness studentBusiness = new StudentBusiness();
        StudentBusiness studentBusiness2 = new StudentBusiness();

        Address address = new Address("Tehran", "Tehran", "Emam", "203040");
        Student student1 = new Student("HamidReza", address);

        Student student2 = new Student("Mohamad", address);

        try {
            studentBusiness.addStudent(student1);
            studentBusiness.addStudent(student2);
            studentBusiness.getSession().close();

            Student student = studentBusiness2.getStudent(1);
            System.out.println(student.getName());
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }
}
