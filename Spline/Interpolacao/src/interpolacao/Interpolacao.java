/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpolacao;

/**
 *
 * @author Tauan
 */
import java.awt.BorderLayout;
import javax.swing.JFrame;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator;
//import org.apache.commons.math3.analysis.UnivariateFunction;

//import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
//import org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.stat.StatUtils;
import org.math.plot.Plot2DPanel;

public class Interpolacao {

    double[] x = {6, 18, 31, 46, 61, 72, 82, 93, 104, 114, 127, 145, 159, 190, 202, 212, 224, 231, 237, 248, 266, 281, 305, 328, 341, 359, 366, 369, 390, 398, 414, 436, 451, 477, 502, 521};
    double[] y = {100, 115, 130, 150, 170, 180, 190, 200, 205, 208, 209, 208, 204, 190, 183, 175, 170, 169, 171, 174, 185, 192, 205, 214, 230, 242, 245, 250, 250, 263, 284, 297, 304, 302, 287, 250};
    UnivariateInterpolator interpolador = new SplineInterpolator();//sera excluido
    Plot2DPanel plot = new Plot2DPanel();
    double[] h = new double[x.length - 1];
    double[] g = new double[x.length + 1];
    double[] a = new double[x.length - 1];
    double[] b = new double[x.length - 1];
    double[] c = new double[x.length - 1];
    double[] d = new double[x.length - 1];
    double[][] matrizA = new double[h.length - 1][h.length - 1]; //[h.length + 1]; (g0 = gn = 0;
    double[] vetorB = new double[h.length - 1];

    public Interpolacao() {
        UnivariateFunction polinomio = interpolador.interpolate(x, y);//sera excluido
        int n = (int) Math.abs((StatUtils.max(x) - Math.abs(StatUtils.min(x))) * 10);//numero de elementos
        double[] xc = new double[n];
        double[] yc = new double[n];
        double[] yc2 = new double[n];

        double xi = StatUtils.min(x);//valor inicial

        for (int i = 0; i < h.length; i++)//calculo de h
        {
            h[i] = x[i + 1] - x[i];
        }

        for (int i = 0; i < h.length - 1; i++) { //criacao da matriz A para cálculo de G (sistema linear
            for (int j = 1; j < h.length; j++) { // pular primeira e ultima colunas

                if (i == j) {
                    matrizA[i][j - 1] = h[i];
                } else {
                    if (j == i + 1) {
                        matrizA[i][j - 1] = 2 * (h[i] + h[i + 1]);
                    } else {
                        if (j == i + 2) {
                            matrizA[i][j - 1] = h[i + 1];
                        } else {
                            matrizA[i][j - 1] = 0;
                        }
                    }
                }
                System.out.print(matrizA[i][j - 1] + " ");// imprime matrizA criada            
            }
            System.out.println("");
        } //fim criacao matriz A

        for (int i = 0; i < vetorB.length; i++) {
            double auxY1 = y[i + 1] - y[i];
            double auxY2 = y[i + 2] - y[i + 1];
            double auxH1 = ((x[i + 1] - x[i]));
            double auxH2 = ((x[i + 2] - x[i + 1]));

            vetorB[i] = 6 * ((auxY2 / auxH2) - (auxY1 / auxH1));

            System.out.print(vetorB[i] + " ");// imprime vetorB criada  
        }

        RealMatrix coefficients = new Array2DRowRealMatrix(matrizA, false);

        DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();

        RealVector constants = new ArrayRealVector(vetorB, false);
        RealVector solution = solver.solve(constants);

        g[0] = 0;
        for (int k = 1; k < g.length - 2; k++) {
            g[k] = solution.getEntry(k - 1);
        }
        
        g[g.length - 1] = 0;


        for (int t = 0; t < x.length - 1; t++) {
            d[t] = y[t];
            c[t] = ((y[t + 1] - y[t]) / h[t]) + (((2 * h[t] * g[t + 1]) + (g[t + 0] * h[t])) / 6);
            b[t] = g[t+1] / 2; // talvez seja g[t+1]  <-----
            a[t] = (g[t + 1] - g[t + 0]) / (6 * h[t]);
        }

        double step = (StatUtils.max(x) - StatUtils.min(x)) / n;
        
        int auxPos = 0;
        double x_val = x[0];
        
        for (int i = 0; i < xc.length; i++) {
            
            while(x_val >= x[auxPos + 1]){
                FuncaoS(x[auxPos + 1], auxPos);
                auxPos++;
            }

            xc[i] = x_val;

            yc[i] = FuncaoS(xc[i], auxPos);
            
            yc2[i] = polinomio.value(xc[i]);

            x_val = (step*i) + x[0];

        }

        plot.addLegend("SOUTH");
        plot.addScatterPlot("Pontos", x, y);
        plot.addLinePlot("Spline", xc, yc);


        JFrame frame = new JFrame("Spline");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.add(plot, BorderLayout.CENTER);
        frame.setVisible(true);

        
        Plot2DPanel plot2 = new Plot2DPanel();
        plot2.addLegend("SOUTH");
        plot2.addScatterPlot("Pontos", x, y);
        plot2.addLinePlot("Spline", xc, yc2);


        JFrame frame2 = new JFrame("SplineComp");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(600, 500);
        frame2.add(plot2, BorderLayout.CENTER);
        frame2.setVisible(true);
    }

    public final double FuncaoS(double x_partial, int intervalo) {
        double x_dif = x_partial - x[intervalo];
        double s1 = (a[intervalo] * (Math.pow(x_dif, 3))) + (b[intervalo] * (Math.pow(x_dif, 2))) + (c[intervalo] * (x_dif)) + d[intervalo];
        return s1;
    }

    public double FuncaoA(double g2, double g1, double h1) {
        double a = (g2 - g1) / (6 * h1);
        return a;
    }

    public double FuncaoB(double g1) {
        return (g1 / 2);
    }

    public double FuncaoC(double y2, double y1, double h1, double g2, double g1) {
        return ((y2 - y1) / h1) + (((2 * h1 * g2) + g1 * h1) / 6);
    }

    public static void main(String[] args) {

        new Interpolacao();
    }
}
