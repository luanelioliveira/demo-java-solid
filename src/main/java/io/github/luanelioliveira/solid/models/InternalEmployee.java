package io.github.luanelioliveira.solid.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InternalEmployee extends Employee {

  private LocalDate lastReadjustment;

  public InternalEmployee(String name, BigDecimal salary, Role role) {
    super(name, salary, role);
  }

  public void updateSalary(BigDecimal newSalary) {
    this.salary = newSalary;
  }

  public LocalDate getLastReadjustment() {
    return lastReadjustment;
  }

  public void promotion(Role newRole) {
    this.role = newRole;
  }
}
