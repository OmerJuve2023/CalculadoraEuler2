package test;

import Dao.Euler2Dao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Euler2DaoTest {

    @Test
    public void testExecutionT() {
        Euler2Dao euler2Dao = new Euler2Dao();
        double[] result = euler2Dao.execution_t(0, 5, 1);
        double[] expected = {0, 1, 2, 3, 4};
        assertArrayEquals(expected, result, 0.0001); // Tolerancia para comparación de números de punto flotante
    }

    @Test
    public void testExecutionMatrix() {
        Euler2Dao euler2Dao = new Euler2Dao();
        double[][] result = euler2Dao.execution_matrix(1, "2*x+1", "3*y+1", 1, 2, 5);
        double[][] expected = {{1, 2}, {4, 9}, {13, 37}, {40, 149}, {121, 597}};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFunction() {
        Euler2Dao euler2Dao = new Euler2Dao();
        double result = euler2Dao.function("2*x+1", 3, 4);
        assertEquals(7, result, 0.0001); // Tolerancia para comparación de números de punto flotante
    }
}
