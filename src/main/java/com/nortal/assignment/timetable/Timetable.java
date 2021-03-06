package com.nortal.assignment.timetable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.nortal.assignment.common.CustomDateTimeDeserializer;
import com.nortal.assignment.common.CustomDateTimeSerializer;
import com.nortal.assignment.employee.Employee;
import com.nortal.assignment.project.Project;

public class Timetable {

  private Long id;
  private Employee employee;
  private Project project;
  @JsonSerialize(using = CustomDateTimeSerializer.class)
  @JsonDeserialize(using = CustomDateTimeDeserializer.class)
  private Date startDate;
  @JsonSerialize(using = CustomDateTimeSerializer.class)
  @JsonDeserialize(using = CustomDateTimeDeserializer.class)
  private Date endDate;
  private long hoursWorked;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Employee getEmployee() {
    return employee;
  }

  public long getHoursWorked() {
	return hoursWorked;
}

  public void setHoursWorked(long hoursWorked) {
	this.hoursWorked = hoursWorked;
}

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public long getWorkedTime() {
    // TODO remove hard coded value and calculate actual worked time based on
    // start and end date
	  long hoursWorkedMS = getEndDate().getTime() - getStartDate().getTime();
	  long hoursWorkedHOURS = TimeUnit.MILLISECONDS.toHours(hoursWorkedMS);
	  
    return hoursWorkedHOURS;
  }



}
