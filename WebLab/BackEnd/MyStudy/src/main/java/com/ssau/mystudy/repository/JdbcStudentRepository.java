package com.ssau.mystudy.repository;

import com.ssau.mystudy.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class JdbcStudentRepository implements StudentRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private RowMapper<Student> studentMapper = (rs, rowNum) -> {
        Student student = new Student();
        student.setId(rs.getLong("id"));
        student.setName(rs.getString("name"));
        student.setBirthdate(rs.getDate("birthdate"));
        student.setNumber(rs.getInt("number"));
        return student;
    };

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from public.students", Integer.class);
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query("select * from public.students", studentMapper);
    }

    @Override
    public List<Student> findAllByName(String name) {
        return namedParameterJdbcTemplate.query("select * from public.students where name ilike '%' || :name || '%'",
                Collections.singletonMap("name", name), studentMapper);
    }
    
    @Override
    public Student add(Student student){
        return namedParameterJdbcTemplate.query("insert into public.students values "
                + "(default, :namev, :birthdate, :number) returning *",
                Map.of(
                        "namev",student.getName(),
                        "birthdate", student.getBirthdate(),
                        "number", student.getNumber()), studentMapper).get(0);
    }
    
    @Override
    public boolean delete(long id){
        int res = namedParameterJdbcTemplate.update("delete from public.students where id=:id",
                Collections.singletonMap("id", id));
        return res!=0;
    }
    
    @Override
    public Student update(Student student){
        namedParameterJdbcTemplate.update("update public.students"
                + " set name = :namev, birthdate = :birthdate, number = :number"
                + " where id = :id",
                Map.of("id", student.getId(),
                        "namev",student.getName(),
                        "birthdate", student.getBirthdate(),
                        "number", student.getNumber()));
        return student;
    }
    
    @Override
    public List<Student> findById(long id) {
        return namedParameterJdbcTemplate.query("select * from public.students where id = :id",
                Collections.singletonMap("id", id), studentMapper);
    }
}
