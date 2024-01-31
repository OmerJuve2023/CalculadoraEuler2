package Dao;

import interfaces.Esqueleto;
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
        print("Income h:\t");
        euler.setH(scanner.nextDouble());
        print("Income Function A:\t");
        euler.setFunctionA(scanner.next());
        print("Income Function B:\t");
        euler.setFunctionB(scanner.next());
        print("Income x1:\t");
        euler.setX1(scanner.nextDouble());
        print("Income y1:\t");
        euler.setY1(scanner.nextDouble());
        print("Income init range:\t");
        euler.setRangeI(scanner.nextInt());
        print("Income final range:\t");
        euler.setRangeF(scanner.nextInt());
        println("----------------------------");
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
        DecimalFormat format = new DecimalFormat("##00.000000");
        DecimalFormat form = new DecimalFormat("#0.00");
        println("iteration" + "\t" + "\t" + "T" + "\t" + "\t" + "\t" + "X" + "\t" + "\t" + "\t" + "Y");
        for (int i = 0; i < N; i++) {
            println("\t" + (i + 1) + "\t" + "|\t" + "\t" + form.format(t[i]) +
                    "\t" + "|\t" + format.format(xy[i][0]) + "\t" + "|\t" + format.format(xy[i][1]));
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

        JFrame panel = new JFrame("Euler graph with two equations");
        panel.setBounds(370, 10, 600, 550);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);
        panel.setResizable(false);

        Plot2DPanel graffiti = new Plot2DPanel();
        graffiti.setBounds(370, 10, 600, 550);
        graffiti.addLegend("SOUTH");
        graffiti.addLinePlot(functionA, t, x);
        graffiti.addLinePlot(functionB, t, y);
        graffiti.setVisible(true);
        panel.add(graffiti);

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

    public double[][] closed_matrix(double h, String functionA, String functionB, double initX, double initY, double N, double initI) {
        DecimalFormat format = new DecimalFormat("####,######");
        double[] t = new double[(int) N];
        t[0] = initI;
        double[][] array = new double[(int) N][2];
        array[0][0] = initX;
        array[0][1] = initY;
        for (int i = 1; i < N; i++) {
            StringBuilder txt = new StringBuilder();
            t[i] = t[i - 1] + h;
            txt.append("Iteration nº:").append(i).append("\t\t").append("t: ").append(t[i]).append("\n");
            array[i][0] = array[i - 1][0] + (h * function(functionA, array[i - 1][0], array[i - 1][1]));
            double fx1 = Double.parseDouble(format.format(array[i - 1][0]));
            double fy2 = Double.parseDouble(format.format(array[i - 1][1]));
            String fx = String.valueOf(fx1);
            String fy = String.valueOf(fy2);

            txt.append("x(").append(i + 1).append(")=").append(array[i - 1][0]).append("+").append(h).append("*(").append(functionA.replace("x", fx).replace("y", fy)).append(")\n");
            txt.append("x(").append(i + 1).append(")= ").append(format.format(array[i][0])).append("\n");
            array[i][1] = array[i - 1][1] + (h * function(functionB, array[i - 1][0], array[i - 1][1]));
            txt.append("y(").append(i + 1).append(")=").append(array[i - 1][1]).append("+").append(h).append("*(").append(functionB.replace("x", fx).replace("y", fy)).append(")\n");
            txt.append("y(").append(i + 1).append(")= ").append(format.format(array[i][1])).append("\n");
            txt.append("------------------------------------------------\n");
            System.out.println(txt);
        }
        return array;
    }

    private void print(String txt) {
        System.out.print(txt);
    }

    private void println(String txt) {
        System.out.println(txt);
    }
}