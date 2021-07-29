package io.github.luanelioliveira.solid;

import static io.github.luanelioliveira.solid.models.Role.ANALYST;

import io.github.luanelioliveira.solid.models.InternalEmployee;
import io.github.luanelioliveira.solid.services.readjustment.ReadjustmentService;
import io.github.luanelioliveira.solid.services.readjustment.validations.ReadjustmentPercentageValidation;
import io.github.luanelioliveira.solid.services.readjustment.validations.ReadjustmentPeriodicityValidation;
import java.math.BigDecimal;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    var validations = List
        .of(new ReadjustmentPercentageValidation(), new ReadjustmentPeriodicityValidation());

    var service = new ReadjustmentService(validations);

    var internalEmployee = new InternalEmployee("João da Silva", new BigDecimal("5000"), ANALYST);
    service.readjustmentSalary(internalEmployee, new BigDecimal("1000"));


  }

}
