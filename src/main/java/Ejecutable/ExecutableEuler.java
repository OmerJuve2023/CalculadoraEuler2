package Ejecutable;

import Dao.Euler2Dao;
import Datos.EulerTO;

import java.util.Scanner;

public class ExecutableEuler extends Euler2Dao {
    private final Euler2Dao euler2;
    private EulerTO eulerTO;

    public ExecutableEuler() {
        euler2 = new Euler2Dao();
        eulerTO = new EulerTO();
        process();
    }

    public void process() {
        eulerTO = euler2.ingress();
        double[] t = euler2.execution_t(eulerTO.getRangeI(), eulerTO.getN(), eulerTO.getH());
        double[][] xy = euler2.closed_matrix(eulerTO.getH(), eulerTO.getFunctionA(), eulerTO.getFunctionB(), eulerTO.getX1(), eulerTO.getY1(), eulerTO.getN(), eulerTO.getRangeI());
        graffiti(eulerTO.getFunctionA() + "\t" + eulerTO.getFunctionB(), xy, t, eulerTO.getFunctionA(), eulerTO.getFunctionB());
        print(t, xy, eulerTO.getN());
        System.out.println("Continue");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();
        if (response.equals("si") || response.equals("s")) {
            process();
        } else {
            System.exit(0);
        }
    }
}