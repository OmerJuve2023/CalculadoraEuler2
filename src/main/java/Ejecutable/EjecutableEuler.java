package Ejecutable;

import Dao.Euler2Dao;
import Datos.EulerTO;

import java.util.Scanner;

public class EjecutableEuler extends Euler2Dao {
    private final Euler2Dao euler2;
    private EulerTO eulerTO;

    public EjecutableEuler(){
        euler2=new Euler2Dao();
        eulerTO=new EulerTO();
        process();
    }
    public void process(){
        eulerTO=euler2.ingreso();
        double[] t = euler2.ejecucion_t(eulerTO.getRangoI(), eulerTO.getN(), eulerTO.getH());
        double[][] xy = euler2.salida_matriz(eulerTO.getH(), eulerTO.getFuncionA(), eulerTO.getFuncionB(), eulerTO.getX1(), eulerTO.getY1(), eulerTO.getN(),eulerTO.getRangoI());
        grafica(eulerTO.getFuncionA()+"\t"+eulerTO.getFuncionB(), xy, t,eulerTO.getFuncionA(),eulerTO.getFuncionB());
        salida(t, xy,eulerTO.getN());
        System.out.println("Seguir?");
        Scanner scanner=new Scanner(System.in);
        String rpta=scanner.next();
        if(rpta.equals("si") ||rpta.equals("s")){
            process();
        }else {
            System.exit(0);
        }
    }
}