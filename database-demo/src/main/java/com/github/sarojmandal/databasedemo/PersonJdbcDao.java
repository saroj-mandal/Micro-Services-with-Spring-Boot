package com.github.sarojmandal.databasedemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJdbcDao {

	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("location"));
			person.setLocation(rs.getString("name"));
			person.setBirthDate(rs.getDate("birth_date"));
			return person;
		}
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Person> findAllPerson() {
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}

	public Person findPersonById(int id) {
		return (Person) jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper(Person.class));
	}

	public int deletePersonById(int id) {
		return jdbcTemplate.update("delete from person where id=?", new Object[] { id });
	}

	public int createPerson(Person person) {
		return jdbcTemplate.update("insert into PERSON (id, name, location, birth_date) " + "values (?, ?, ?, ?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(), person.getBirthDate() });
	}

	public int updatePerson(Person person) {
		return jdbcTemplate.update("update PERSON set name=?, location=?, birth_date=? where id=?",
				new Object[] { person.getName(), person.getLocation(), person.getBirthDate(), person.getId() });
	}
}
