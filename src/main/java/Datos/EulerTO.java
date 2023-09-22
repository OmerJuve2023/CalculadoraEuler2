package Datos;

public class EulerTO {

    private double h; private String funcionA; private String funcionB;
    private double x1;private double y1;private int rangoI;
    private int rangoF;

    public int getN() {
        return (int) ((this.rangoF-this.rangoI)/this.h);
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public String getFuncionA() {
        return funcionA;
    }

    public void setFuncionA(String funcionA) {
        this.funcionA = funcionA;
    }

    public String getFuncionB() {
        return funcionB;
    }

    public void setFuncionB(String funcionB) {
        this.funcionB = funcionB;
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

    public int getRangoI() {
        return rangoI;
    }

    public void setRangoI(int rangoI) {
        this.rangoI = rangoI;
    }

    public void setRangoF(int rangoF) {
        this.rangoF = rangoF;
    }

}
