package io.github.luanelioliveira.solid.models;

import java.math.BigDecimal;

public abstract class Employee {
  protected String name;
  protected BigDecimal salary;
  protected Role role;

  public Employee(String name, BigDecimal salary, Role role) {
    this.name = name;
    this.salary = salary;
    this.role = role;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public Role getRole() {
    return role;
  }

}
