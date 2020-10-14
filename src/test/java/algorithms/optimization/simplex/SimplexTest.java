package algorithms.optimization.simplex;

import junit.framework.TestCase;

/**
 * @author thepn
 */
public class SimplexTest extends TestCase {

  public void testSolution() {
    Tableau tableau = new TableauBuilder().addObjectFunctionCoefficients(6, -4, -2)
        .addConstraint(10, 3, 0, 3)
        .addConstraint(12, 1, 1, -1)
        .addConstraint(26, 3, 2, 1)
        .build();

    runTableauTest(tableau, -52.0D);

    tableau = new TableauBuilder().addObjectFunctionCoefficients(-30, 10, -15)
        .addConstraint(105, 1, -1, 0)
        .addConstraint(110, 1, 0, 5)
        .addConstraint(75, 0, 5, -1)
        .build();

    runTableauTest(tableau, -3250.0D);
  }

  private void runTableauTest(Tableau tableau, double objValue) {
    assertTrue(tableau.isFeasible());

    double result = tableau.solve();

    assertEquals(objValue, result);
    assertEquals(-1, tableau.isOptimal());
  }

  public void testIllegalStartSolution() {
    Tableau tableau = new TableauBuilder().addObjectFunctionCoefficients(6, -4, -2)
        .addConstraint(-10, 3, 0, 3)
        .addConstraint(-12, 1, 1, -1)
        .addConstraint(-26, 3, 2, 1)
        .build();

    try {
      tableau.solve();
      fail();
    } catch (IllegalArgumentException e) {
    }
  }

}
