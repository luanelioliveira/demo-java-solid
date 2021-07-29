package io.github.luanelioliveira.solid.models;

import java.math.BigDecimal;

public class OutsourcedEmployee extends Employee {

  public OutsourcedEmployee(String name, BigDecimal salary, Role role) {
    super(name, salary, role);
  }
}
