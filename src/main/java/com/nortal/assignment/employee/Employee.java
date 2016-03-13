package com.nortal.assignment.employee;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 *
 * @author Priit Liivak
 *
 */
public class Employee {

  private Long id;
  private String employeeName;
  private String kind;
  private BigDecimal salary;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }
  
public static class OrderBySalary implements Comparator<Employee> {
	  
	  @Override
	  public int compare(Employee e1, Employee e2) {
		  e1.getSalary().compareTo(e2.getSalary());
		  return e1.salary.intValue() > e2.salary.intValue() ? 1 : (e1.salary.intValue() < e2.salary.intValue() ? -1 : 0);
	  }
  }

}
