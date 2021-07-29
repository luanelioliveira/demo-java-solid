package io.github.luanelioliveira.solid.services.promotion;

import static io.github.luanelioliveira.solid.models.Role.ANALYST;
import static io.github.luanelioliveira.solid.models.Role.ASSISTANT;
import static io.github.luanelioliveira.solid.models.Role.MANAGER;
import static io.github.luanelioliveira.solid.models.Role.SPECIALIST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.github.luanelioliveira.solid.exceptions.ValidationException;
import io.github.luanelioliveira.solid.models.InternalEmployee;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PromotionServiceTest {

  private PromotionService promotionService;

  @BeforeEach
  public void setUp() {
    promotionService = new PromotionService();
  }

  @Test
  public void shouldPromoteEmployeeToAnalyst() {
    var employee = new InternalEmployee("João da Silva", new BigDecimal("5000"), ASSISTANT);

    promotionService.promotion(employee, true);

    assertEquals(ANALYST, employee.getRole());
  }

  @Test
  public void shouldPromoteEmployeeToSpecialist() {
    var employee = new InternalEmployee("João da Silva", new BigDecimal("5000"), ANALYST);

    promotionService.promotion(employee, true);

    assertEquals(SPECIALIST, employee.getRole());
  }

  @Test
  public void shouldPromoteEmployeeToManager() {
    var employee = new InternalEmployee("João da Silva", new BigDecimal("5000"), SPECIALIST);

    promotionService.promotion(employee, true);

    assertEquals(MANAGER, employee.getRole());
  }

  @Test
  public void shouldNotPromoteEmployeeManager() {
    var employee = new InternalEmployee("João da Silva", new BigDecimal("5000"), MANAGER);

    assertThrows(ValidationException.class, () -> promotionService.promotion(employee, true));
  }

  @Test
  public void shouldNotPromoteEmployeeHasNotHitGoal() {
    var employee = new InternalEmployee("João da Silva", new BigDecimal("5000"), ANALYST);

    assertThrows(ValidationException.class, () -> promotionService.promotion(employee, false));
  }

}
