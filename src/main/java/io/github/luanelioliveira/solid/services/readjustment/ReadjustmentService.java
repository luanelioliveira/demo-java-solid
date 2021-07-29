package io.github.luanelioliveira.solid.services.readjustment;

import io.github.luanelioliveira.solid.models.InternalEmployee;
import io.github.luanelioliveira.solid.services.readjustment.validations.ReadjustmentValidation;
import java.math.BigDecimal;
import java.util.List;

public class ReadjustmentService {

  private final List<ReadjustmentValidation> validations;

  public ReadjustmentService(List<ReadjustmentValidation> validations) {
    this.validations = validations;
  }

  public void readjustmentSalary(InternalEmployee employee, BigDecimal increase) {
    validations.forEach(validation -> validation.valid(employee, increase));

    var newSalary = employee.getSalary().add(increase);
    employee.updateSalary(newSalary);

    System.out.println("Readjustment salary.");
  }

}
