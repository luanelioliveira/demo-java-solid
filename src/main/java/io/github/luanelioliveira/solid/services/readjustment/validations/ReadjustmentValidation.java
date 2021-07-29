package io.github.luanelioliveira.solid.services.readjustment.validations;

import io.github.luanelioliveira.solid.models.InternalEmployee;
import java.math.BigDecimal;

public interface ReadjustmentValidation {

  void valid(InternalEmployee employee, BigDecimal increase);

}
