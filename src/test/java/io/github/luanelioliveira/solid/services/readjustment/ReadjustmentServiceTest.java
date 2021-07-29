package io.github.luanelioliveira.solid.services.readjustment;


import static io.github.luanelioliveira.solid.models.Role.ANALYST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.github.luanelioliveira.solid.exceptions.ValidationException;
import io.github.luanelioliveira.solid.models.InternalEmployee;
import io.github.luanelioliveira.solid.services.readjustment.validations.ReadjustmentPercentageValidation;
import io.github.luanelioliveira.solid.services.readjustment.validations.ReadjustmentPeriodicityValidation;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReadjustmentServiceTest {

  private ReadjustmentService readjustmentService;

  @BeforeEach
  public void setUp() {
    var percentageValidation = new ReadjustmentPercentageValidation();
    var periodicityValidation = new ReadjustmentPeriodicityValidation();
    var validations = List.of(percentageValidation, periodicityValidation);
    readjustmentService = new ReadjustmentService(validations);
  }

  @Test
  public void shouldReadjustmentSalary() {
    var employee = new InternalEmployee("João da Silva", new BigDecimal("5000"), ANALYST);
    var increase = new BigDecimal("1000");

    readjustmentService.readjustmentSalary(employee, increase);

    assertEquals(employee.getSalary(), new BigDecimal("6000"));
  }

  @Test
  public void shouldThrowValidationExceptionOnReadjustmentSalary() {
    var employee = new InternalEmployee("João da Silva", new BigDecimal("5000"), ANALYST);
    var increase = new BigDecimal("3000");

    assertThrows(ValidationException.class,
        () -> readjustmentService.readjustmentSalary(employee, increase));
  }

}
