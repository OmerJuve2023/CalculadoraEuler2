package Datos;

public interface Esqueleto {
    EulerTO ingreso();

    double[] ejecucion_t(double inicial, int N, double h);

    double[][] ejecucion_matriz(double h, String funcionA,String funcionB,double inicialx,double inicialy,double N);

    void  salida(double []t,double[][]xy, int N);

    void grafica(String name, double [][]xy, double []t, String funcionA, String funcionB);

    double funcion(String funcion, double x, double y);
    

}
