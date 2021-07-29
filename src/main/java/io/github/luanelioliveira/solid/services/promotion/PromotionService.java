package io.github.luanelioliveira.solid.services.promotion;

import io.github.luanelioliveira.solid.exceptions.ValidationException;
import io.github.luanelioliveira.solid.models.InternalEmployee;
import io.github.luanelioliveira.solid.models.Role;

public class PromotionService {

  public void promotion(InternalEmployee employee, boolean hasHitGoal) {
    if (!hasHitGoal) {
      throw new ValidationException("Employee did not hit goal!");
    }

    var currentRole = employee.getRole();
    if (Role.MANAGER.equals(currentRole)) {
      throw new ValidationException("Managers cannot be promoted!");
    }

    employee.promotion(currentRole.getNextRole());
  }

}
