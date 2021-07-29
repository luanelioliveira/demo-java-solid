package io.github.luanelioliveira.solid.services.readjustment.validations;

import io.github.luanelioliveira.solid.exceptions.ValidationException;
import io.github.luanelioliveira.solid.models.InternalEmployee;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReadjustmentPercentageValidation implements ReadjustmentValidation {

  private final static double MAX_READJUSTMENT_PERCENTAGE = 0.4;

  @Override
  public void valid(InternalEmployee employee, BigDecimal increase) {
    var currentSalary = employee.getSalary();
    var readjustmentPercentage = increase.divide(currentSalary, RoundingMode.HALF_UP);

    if (readjustmentPercentage.compareTo(new BigDecimal(MAX_READJUSTMENT_PERCENTAGE)) > 0) {
      throw new ValidationException(
          "Readjustment should not be more than " + MAX_READJUSTMENT_PERCENTAGE * 100 + " percent");
    }
  }
}
