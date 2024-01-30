package Datos;

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

    public void setH(double h) {
        this.h = h;
    }

    public String getFunctionA() {
        return functionA;
    }

    public void setFunctionA(String functionA) {
        this.functionA = functionA;
    }

    public String getFunctionB() {
        return functionB;
    }

    public void setFunctionB(String functionB) {
        this.functionB = functionB;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public int getRangeI() {
        return rangeI;
    }

    public void setRangeI(int rangeI) {
        this.rangeI = rangeI;
    }

    public void setRangeF(int rangeF) {
        this.rangeF = rangeF;
    }

}
