package fr.emile.dove.model.implement;

import java.util.List;

import fr.emile.dove.entity.Student;
import fr.emile.dove.model.interfaces.IStudent;

public class StudentDao implements IStudent {

	@Override
	public Student add(Student student) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student get(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student get(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Student student) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

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
