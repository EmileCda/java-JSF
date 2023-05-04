package fr.emile.jsfsix.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.emile.jsfsix.entity.Person;
import fr.emile.jsfsix.entity.Student;
import fr.emile.jsfsix.enums.DevLang;
import fr.emile.jsfsix.model.connection.DBConnect;
import fr.emile.jsfsix.utils.Utils;

public class StudentDao implements IStudentDao {

	@Override
	public Student add(Student student) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String langString = "";
		for (DevLang lang : student.getDesiredLanguageList()) {
			
			langString+= lang.getValue() + ";" ;
		}
		
		try {
			connection = DBConnect.getConnection();
			String sqlRequest = "INSERT INTO `student`(" +
			"`firstname`, `lastname`, `gender`," +
			"`birthdate`, `email`, `service_level`,"+
			"`lang_list`,`phone`, `position`,`is_avalaiblle`, `is_delete`)"+
			"VALUES (?,?,?,?,?,?,?,?,?,?,?)" ;

			
			
			
			preparedStatement = connection.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, student.getFirstname());
			preparedStatement.setString(2, student.getLastname());
			preparedStatement.setString(3,student.getGender().getValue());
			preparedStatement.setDate(4, Utils.toSqlDate(student.getBirthdate()));
			preparedStatement.setString(5, student.getEmail());
			preparedStatement.setString(6, student.getServiceLevel().getValue());
			preparedStatement.setString(7, langString);
			preparedStatement.setString(8, student.getPhone());
			preparedStatement.setString(9, student.getCurrentPosition().getValue());
			preparedStatement.setBoolean(10, student.isAvailable());
			preparedStatement.setBoolean(11, student.isDeleted());

			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet != null && resultSet.next()) {
				student.setId(resultSet.getInt(1));
				return  student ;
			}
		} finally {
			this.closeStream(connection, preparedStatement, resultSet);
		}
		return student ;
	}

	@Override
	public Student get(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> get() throws Exception {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> studentList = null;
		try {
			connection = DBConnect.getConnection();
			String sqlRequest ="	SELECT "+
			"`id`, `firstname`, `lastname`, `gender`,"+
			"`birthdate`, `email`, `service_level`, `lang_list`,"+
			" `phone`, `position`,`is_avalaiblle`, `is_delete` FROM `student` " +
			"WHERE `is_delete`= false";
			preparedStatement = connection.prepareStatement(sqlRequest);

			preparedStatement.execute();
			resultSet = preparedStatement.getResultSet();

			if (resultSet != null) {
				studentList = new ArrayList<Student>();

				while (resultSet.next()) {
					Student student = new Student(resultSet);

					studentList.add(student);
				}
			}
		} finally {
			this.closeStream(connection, preparedStatement, resultSet);
		}
		return studentList;
		
	}

	@Override
	public int Update(Student student) throws Exception {
		Connection connection = null;
		int result = 0;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBConnect.getConnection();
			String sqlRequest="UPDATE `student` SET " +
			"`firstname`=?,`lastname`=?,`gender`=?,"+
					"`birthdate`=?,`email`=?,`service_level`=?,"+
			"`lang_list`=?,`phone`=?,`position`=?,`is_avalaiblle`=?,`is_delete`=? "+
			" WHERE id= ?";
			
			
			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.setString(1, student.getFirstname());
			preparedStatement.setString(2, student.getLastname());
			preparedStatement.setString(3, student.getGender().getValue());
			preparedStatement.setDate(4, Utils.toSqlDate(student.getBirthdate()));
			preparedStatement.setString(5, student.getEmail());
			preparedStatement.setString(6, student.getServiceLevel().getValue());
			preparedStatement.setString(7, DevLang.Lang2String(student.getDesiredLanguageList()));
			preparedStatement.setString(8, student.getPhone());
			preparedStatement.setString(9, student.getCurrentPosition().getValue());
			preparedStatement.setBoolean(10, student.isDeleted());
			preparedStatement.setBoolean(11, student.isAvailable());
			preparedStatement.setInt(12, student.getId());

			result = preparedStatement.executeUpdate();

		} finally {

			this.closeStream(connection, preparedStatement);
		}
		return result;
	}

	@Override
	public int delete(int id, boolean isDeleted) throws Exception {

		Connection connection = null;
		int result = 0;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBConnect.getConnection();
			String sqlRequest="UPDATE `student` SET " +
							"`is_delete`=? "+
							" WHERE id= ?";
			
			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.setBoolean(1, isDeleted);
			preparedStatement.setInt(2, id);

			result = preparedStatement.executeUpdate();

		} finally {

			this.closeStream(connection, preparedStatement);
		}
		return result;
	}

	@Override
	public int delete(Student person, boolean isDeleted) throws Exception {
		
		return this.delete(person.getId(), isDeleted);
	}

	@Override
	public int delete(int id) throws Exception {
		
		return this.delete(id, true);
	}

	@Override
	public int delete(Student person) throws Exception {
		return this.delete(person, true);
	}


	private void closeStream(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet)
			throws Exception {

		if (resultSet != null && !resultSet.isClosed()) {
			resultSet.close();
		}
		if (preparedStatement != null && !preparedStatement.isClosed()) {
			preparedStatement.close();
		}
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}

	}

//-----------------------------------------------------------------------------
	private void closeStream(Connection connection, PreparedStatement preparedStatement) throws Exception {

		closeStream(connection, preparedStatement, null);

	}
	
}
