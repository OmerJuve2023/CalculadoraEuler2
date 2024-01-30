package Datos;

import lombok.Setter;

@Setter
public class EulerTO {

    private double h;
    private String functionA;
    private String functionB;
    private double x1;
    private double y1;
    private int rangeI;
    private int rangeF;

    public int getN() {
        return (int) ((this.rangeF - this.rangeI) / this.h);
    }

    public double getH() {
        return h;
    }

    public String getFunctionA() {
        return functionA;
    }

    public String getFunctionB() {
        return functionB;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public int getRangeI() {
        return rangeI;
    }

}
