package problems.romannumeralconverter;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import problems.romannumeralconverter.impl.Converter;

public class ConverterTest {

  Converter converter = new Converter();

  @Test
  public void inputIGet1() {

    assertEquals(1, converter.convert("I"));
  }

  @Test
  public void inputIIIGet3() {

    assertEquals(3, converter.convert("III"));
  }

  @Test
  public void inputVGet5() {

    assertEquals(5, converter.convert("V"));
  }

  @Test
  public void inputVIIGet7() {

    assertEquals(7, converter.convert("VII"));
  }

  @Test
  public void inputIVGet4() {

    assertEquals(4, converter.convert("IV"));
  }

  @Test
  public void inputIXGet4() {

    assertEquals(4, converter.convert("IV"));
  }

  @Test
  public void inputIXGet9() {

    assertEquals(4, converter.convert("IV"));
  }

  @Test
  public void inputXXXIXGet39() {

    assertEquals(39, converter.convert("XXXIX"));
  }

  @Test
  public void inputXXVIIIGet28() {

    assertEquals(28, converter.convert("XXVIII"));
  }

  @Test
  public void inputXLGet40() {

    assertEquals(40, converter.convert("XL"));
  }

  @Test
  public void inputLXXXGet80() {

    assertEquals(80, converter.convert("LXXX"));
  }

  @Test
  public void inputXCGet90() {

    assertEquals(90, converter.convert("XC"));
  }

  @Test
  public void inputCXCIGet191() {

    assertEquals(191, converter.convert("CXCI"));
  }

  @Test
  public void inputCDGet400() {

    assertEquals(400, converter.convert("CD"));
  }

  @Test
  public void inputCMGet900() {

    assertEquals(900, converter.convert("CM"));
  }

  @Test
  public void inputMCMIIIGet1903() {

    assertEquals(1903, converter.convert("MCMIII"));
  }
}