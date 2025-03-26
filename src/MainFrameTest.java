import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainFrameTest {

    private final MainFrame frame = new MainFrame();

    @Test
    void test1_RealParaDolar() {
        double resultado = frame.converterMoedaTeste(1.0, "Dólar");
        assertEquals(0.192, resultado, 0.001); // 1 BRL = 0.192 USD (1/5.20)
    }

    @Test
    void test2_ReaisParaEuro() {
        double resultado = frame.converterMoedaTeste(2.0, "Euro");
        assertEquals(0.357, resultado, 0.001); // 2 BRL = 0.357 EUR (2/5.60)
    }

    @Test
    void test3_ReaisParaLibra() {
        double resultado = frame.converterMoedaTeste(3.0, "Libra");
        assertEquals(0.408, resultado, 0.001); // 3 BRL = 0.408 GBP (3/7.36)
    }

    @Test
    void test4_ReaisParaYene() {
        double resultado = frame.converterMoedaTeste(4.0, "Yene");
        assertEquals(105.263, resultado, 0.001); // 4 BRL = 105.263 JPY (4/0.038)
    }

    @Test
    void test5_ReaisParaDolarAustraliano() {
        double resultado = frame.converterMoedaTeste(5.0, "Dólar Australiano");
        assertEquals(1.397, resultado, 0.001); // 5 BRL = 1.397 AUD (5/3.58)
    }

    @Test
    void test6_ReaisParaDolarCanadense() {
        double resultado = frame.converterMoedaTeste(6.0, "Dólar Canadense");
        assertEquals(1.511, resultado, 0.001); // 6 BRL = 1.511 CAD (6/3.97)
    }

    @Test
    void test7_ReaisParaFrancoSuico() {
        double resultado = frame.converterMoedaTeste(7.0, "Franco Suíço");
        assertEquals(1.087, resultado, 0.001); // 7 BRL = 1.087 CHF (7/6.44)
    }

    @Test
    void test8_ReaisParaYuan() {
        double resultado = frame.converterMoedaTeste(8.0, "Yuan");
        assertEquals(10.204, resultado, 0.001); // 8 BRL = 10.204 CNY (8/0.784)
    }

    @Test
    void test9_ReaisParaPesoArgentino() {
        double resultado = frame.converterMoedaTeste(9.0, "Peso Argentino");
        assertEquals(1800.0, resultado, 0.001); // 9 BRL = 1800 ARS (9/0.005)
    }

    @Test
    void test10_ReaisParaBitcoin() {
        double resultado = frame.converterMoedaTeste(10.0, "Bitcoin");
        assertEquals(0.00004, resultado, 0.000001); // 10 BRL = 0.00004 BTC (10/250000)
    }
}