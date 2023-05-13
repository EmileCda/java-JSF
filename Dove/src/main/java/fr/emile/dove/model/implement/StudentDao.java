package fr.emile.dove.model.implement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.emile.dove.entity.Student;
import fr.emile.dove.model.connect.DBConnect;
import fr.emile.dove.model.interfaces.IStudentDao;
import fr.emile.dove.utils.Utils;

public class StudentDao implements IStudentDao {

// -------------------------------------------------------------------------------------------------
	@Override
	public Student add(Student student) throws Exception {
		Utils.trace(student.toString());

		Session session = DBConnect.getSession();
		Transaction transaction = null;
		try {

			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			if (session != null && session.isOpen())
				session.close();

		}
		return student;
	}

//-------------------------------------------------------------------------------------------------
	@Override
	public Student get(int id) throws Exception {
		Student studentReturn = null;
		Session session = DBConnect.getSession();

		try {
			studentReturn= session.find(Student.class, id);

		} catch (Exception e) {
			// TODO: handle exception

		} finally {
			if (session != null && session.isOpen())
				session.close();

		}
		return studentReturn;
	}

//-------------------------------------------------------------------------------------------------
	@Override
	public Student get(String email) throws Exception {
		Student studentReturn = null;
		Session session = DBConnect.getSession();

		try {
			session.find(Student.class, email);

		} catch (Exception e) {
			// TODO: handle exception

		} finally {
			if (session != null && session.isOpen())
				session.close();

		}

		return studentReturn;
	}

//-------------------------------------------------------------------------------------------------
	@Override
	public List<Student> get() throws Exception {
		List<Student> studentListReturn = null;
		Session session = DBConnect.getSession();

		try {
			Query query = session.createQuery("from Student");
			studentListReturn = new ArrayList<Student>();
			studentListReturn = (List<Student>) query.getResultList();
			
					

		} catch (Exception e) {
			// TODO: handle exception

		} finally {
			if (session != null && session.isOpen())
				session.close();

		}

		return studentListReturn;
	}

//-------------------------------------------------------------------------------------------------
	@Override
	public int update(Student student) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

//-------------------------------------------------------------------------------------------------
	@Override
	public int delete(int id, boolean isDeleted) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Student student, boolean isDeleted) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Student student) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(Student student) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
