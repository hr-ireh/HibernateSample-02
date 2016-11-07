package ir.hri.bl;

import ir.hri.Entity.Student;
import ir.hri.exception.DaoException;
import ir.hri.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentBusiness {
    Session session;

    {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void addStudent(Student student) throws DaoException {
        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(student);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                try {
                    transaction.rollback();
                } catch (HibernateException e1) {
                    throw new DaoException("Fetal exception in " + e1.getMessage());
                }
            throw new DaoException("Fetal to retrieve " + e.getMessage());
        }
    }

    public Student getStudent(long id) throws DaoException {
        Transaction transaction = session.beginTransaction();
        Student student;

        try {
            student = (Student) session.load(Student.class, new Long(id));
        } catch (HibernateException e) {
            if (transaction != null)
                try {
                    transaction.rollback();
                } catch (HibernateException e1) {
                    throw new DaoException("Fetal exception in " + e1.getMessage());
                }
            throw new DaoException("Fetal to retrieve " + e.getMessage());
        }
        return student;
    }

    public List<Student> getStudents() throws DaoException {
        List<Student> students;

        try {
            students = session.createQuery("FROM ir.hri.Entity.Student").list();
        } catch (HibernateException e) {

            throw new DaoException("Fetal to retrieve " + e.getMessage());
        }
        return students;
    }

    public void removeStudent(long id) throws DaoException {
        Transaction transaction = session.beginTransaction();

        try {
            //// TODO: 11/7/2016
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                try {
                    transaction.rollback();
                } catch (HibernateException e1) {
                    throw new DaoException("Fetal exception in " + e1.getMessage());
                }
            throw new DaoException("Fetal to retrieve " + e.getMessage());
        }
    }

    public void sessionClose() {
        session.close();
    }
}
