package io.github.luanelioliveira.solid.services.readjustment.validations;

import io.github.luanelioliveira.solid.exceptions.ValidationException;
import io.github.luanelioliveira.solid.models.InternalEmployee;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class ReadjustmentPeriodicityValidation implements ReadjustmentValidation {

  private final static int MIN_MONTHS_READJUSTMENT = 6;

  @Override
  public void valid(InternalEmployee employee, BigDecimal increase) {
    var lastReadjustment = employee.getLastReadjustment();
    if (Objects.isNull(lastReadjustment)) {
      return;
    }

    var currentDate = LocalDate.now();
    var monthsLastReadjustment = ChronoUnit.MONTHS.between(lastReadjustment, currentDate);

    if (monthsLastReadjustment < MIN_MONTHS_READJUSTMENT) {
      throw new ValidationException(
          "Interval between readjustments must be at least " + MIN_MONTHS_READJUSTMENT + " months");
    }
  }
}
