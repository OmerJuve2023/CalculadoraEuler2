package Dao;

import Datos.Esqueleto;
import Datos.EulerTO;
import org.math.plot.Plot2DPanel;
import org.nfunk.jep.JEP;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Euler2Dao implements Esqueleto {
    @Override
    public EulerTO ingress() {
        EulerTO euler = new EulerTO();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese h:\t");
        euler.setH(scanner.nextDouble());
        System.out.print("ingrese Funcion A:\t");
        euler.setFunctionA(scanner.next());
        System.out.print("Ingrese Funcion B:\t");
        euler.setFunctionB(scanner.next());
        System.out.print("Ingrese x1:\t");
        euler.setX1(scanner.nextDouble());
        System.out.print("Ingrese y1:\t");
        euler.setY1(scanner.nextDouble());
        System.out.print("Ingrese rango Inicial:\t");
        euler.setRangeI(scanner.nextInt());
        System.out.print("Ingrese rango Final:\t");
        euler.setRangeF(scanner.nextInt());
        System.out.println("----------------------------");
        return euler;
    }

    @Override
    public double[] execution_t(double initial, int N, double h) {
        double[] t = new double[N];
        t[0] = initial;
        for (int i = 1; i < N; i++) {
            t[i] = t[i - 1] + h;
        }
        return t;
    }

    @Override
    public double[][] execution_matrix(double h, String functionA, String functionB, double initialX, double initialY, double N) {
        double[][] array = new double[(int) N][2];
        array[0][0] = initialX;
        array[0][1] = initialY;
        for (int i = 1; i < N; i++) {
            array[i][0] = array[i - 1][0] + (h * function(functionA, array[i - 1][0], array[i - 1][1]));
            array[i][1] = array[i - 1][1] + (h * function(functionB, array[i - 1][0], array[i - 1][1]));
        }
        return array;
    }

    @Override
    public void print(double[] t, double[][] xy, int N) {
        DecimalFormat formato = new DecimalFormat("##00.000000");
        DecimalFormat form = new DecimalFormat("#0.00");
        System.out.println("iteration" + "\t" + "\t" + "T" + "\t" + "\t" + "\t" + "X" + "\t" + "\t" + "\t" + "Y");
        for (int i = 0; i < N; i++) {
            System.out.println("\t" + (i + 1) + "\t" + "|\t" + "\t" + form.format(t[i]) +
                    "\t" + "|\t" + formato.format(xy[i][0]) + "\t" + "|\t" + formato.format(xy[i][1]));
        }
    }

    @Override
    public void graffiti(String name, double[][] xy, double[] t, String functionA, String functionB) {
        double[] x = new double[xy.length];
        double[] y = new double[xy.length];
        for (int i = 0; i < xy.length; i++) {
            x[i] = xy[i][0];
            y[i] = xy[i][1];
        }

        JFrame panel = new JFrame("grafica Euler con Dos Ecuaciones");
        panel.setBounds(370, 10, 600, 550);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);
        panel.setResizable(false);

        Plot2DPanel grafica = new Plot2DPanel();
        grafica.setBounds(370, 10, 600, 550);
        grafica.addLegend("SOUTH");
        //grafica.removeAllPlots();
        grafica.addLinePlot(functionA, t, x);
        grafica.addLinePlot(functionB, t, y);
        grafica.setVisible(true);
        panel.add(grafica);

    }

    @Override
    public double function(String function, double x, double y) {
        JEP jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.addVariable("x", x);
        jep.addVariable("y", y);
        jep.parseExpression(function);
        return jep.getValue();
    }

    public double[][] salida_matriz(double h, String funcionA, String funcionB, double inicialx, double inicialy, double N, double inicialI) {
        DecimalFormat format=new DecimalFormat("####,######");
        double[] t = new double[(int) N];
        t[0] = inicialI;
        double[][] array = new double[(int) N][2];
        array[0][0] = inicialx;
        array[0][1] = inicialy;
        for (int i = 1; i < N; i++) {
            StringBuilder txt=new StringBuilder();
            t[i] = t[i - 1] + h;
            txt.append("Iteracion nº:").append(i).append("\t\t").append("t: ").append(t[i]).append("\n");
            array[i][0] = array[i - 1][0] + (h * function(funcionA, array[i - 1][0], array[i - 1][1]));
            double fx1= Double.parseDouble(format.format(array[i-1][0]));
            double fy2=Double.parseDouble(format.format(array[i-1][1]));
            String fx = String.valueOf(fx1);
            String fy = String.valueOf(fy2);

            txt.append("x(").append(i + 1).append(")=").append(array[i - 1][0]).append("+").append(h).append("*(").append(funcionA.replace("x", fx).replace("y", fy)).append(")\n");
            txt.append("x(").append(i + 1).append(")= ").append(format.format(array[i][0])).append("\n");
            array[i][1] = array[i - 1][1] + (h * function(funcionB, array[i - 1][0], array[i - 1][1]));
            txt.append("y(").append(i + 1).append(")=").append(array[i - 1][1]).append("+").append(h).append("*(").append(funcionB.replace("x", fx).replace("y", fy)).append(")\n");
            txt.append("y(").append(i + 1).append(")= ").append(format.format(array[i][1])).append("\n");
            txt.append("------------------------------------------------\n");
            System.out.println(txt);
        }
        return array;
    }
}