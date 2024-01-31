package interfaces;

import Datos.EulerTO;

public interface Esqueleto {
    EulerTO ingress();

    double[] execution_t(double initial, int N, double h);

    double[][] execution_matrix(double h, String functionA, String functionB, double initialX, double initialY, double N);

    void print(double[] t, double[][] xy, int N);

    void graffiti(String name, double[][] xy, double[] t, String functionA, String functionB);

    double function(String function, double x, double y);
    
}
