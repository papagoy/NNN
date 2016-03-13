package com.nortal.assignment.timetable;

import com.nortal.assignment.employee.Employee;
import com.nortal.assignment.employee.EmployeeServiceJdbcImpl.EmployeeRowMapper;
import com.nortal.assignment.project.Project;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Priit Liivak
 */
@Service
public class TimetableServiceJdbcImpl implements TimetableService {

  @Resource
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Timetable> getListData() {
    // TODO Remove hard coded value and get the actual data from DB

	    String sql = "select t.id, t.start_date, t.end_date, e.employee_name from timetable t join employee e ON t.employee_id = e.id";
	    return jdbcTemplate.query(sql, new TimeTableRowMapper());
	    

  }

  @Override
  public void save(final Timetable data) {
    // TODO Do actual save here
  }

  @Override
  public void delete(Long id) {
    String recordSql = "DELETE FROM timetable WHERE id=?";
    jdbcTemplate.update(recordSql, id);
  }
  
  public void deleteRecordEmployees(Long id) {
	    String recordEmployeeSql = "delete from timetable where employee_id=?";
	    jdbcTemplate.update(recordEmployeeSql, id);
	  }

@Override
public void deleteRecordProject(Long id) {
	// TODO Auto-generated method stub
    String recordProjectSql = "delete from timetable where project_id=?";
    jdbcTemplate.update(recordProjectSql, id);
  }

public final class TimeTableRowMapper implements RowMapper<Timetable> {

    @Override
    public Timetable mapRow(ResultSet rs, int rowNum) throws SQLException {
      Timetable timetable = new Timetable();
      timetable.setId(rs.getLong("id"));
      timetable.setStartDate(rs.getDate("start_date"));
      timetable.setEndDate(rs.getDate("end_date"));
      Employee employee = new Employee();
      employee.setEmployeeName(rs.getString("employee_name"));
      timetable.setEmployee(employee);
      
      long hours;
      hours = timetable.getWorkedTime();
      timetable.setHoursWorked(hours);  // aga ei saa timetable.setHoursWorked(timetable.getWorkedTime()); ???
      
      
      

      return timetable;
    }
  }

}
