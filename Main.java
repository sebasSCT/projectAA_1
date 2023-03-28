package proyecto_java;

import java.util.Scanner;

import proyecto_java.Algoritmos.NaivKaha;
import proyecto_java.Algoritmos.NaivLoopUnrollingFour;
import proyecto_java.Algoritmos.NaivLoopUnrollingThree;
import proyecto_java.Algoritmos.NaivLoopUnrollingTwo;
import proyecto_java.Algoritmos.NaivOnArray;
import proyecto_java.Algoritmos.NaivStandard;
import proyecto_java.Algoritmos.ParallelBlock_III;
import proyecto_java.Algoritmos.ParallelBlock_IV;
import proyecto_java.Algoritmos.ParallelBlock_V;
import proyecto_java.Algoritmos.SequentialBlock_III;
import proyecto_java.Algoritmos.SequentialBlock_IV;
import proyecto_java.Algoritmos.SequentialBlock_V;
import proyecto_java.Algoritmos.StrassenNaiv;
import proyecto_java.Algoritmos.StrassenWinograd;
import proyecto_java.Algoritmos.WinogradOriginal;
import proyecto_java.Algoritmos.WinogradScaled;

public class Main
{

    private static long start_time, stop_time;
    private static Thread t;
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) 
    {
        // double[][] m = {{3,3,3},{3,3,3},{3,3,3}};
        // double[][] m_ = m;
        double[][] m = Matriz.cargar_matriz("matriz_3");
        double[][] m_ = m;
        
        int opc = 0, i = 1;
        String msg;

        while(i <= 16)
        {

            double[][] result = new double[m.length][m.length];

            // System.out.println("Metodo: ");
            // opc = s.nextInt();

            start_time = System.nanoTime();

            msg = metodo(i, m, m_, result);

            stop_time = System.nanoTime();

            long total_time = stop_time - start_time;
            System.out.println("\n"+ msg + "\nTiempo: " + total_time + "\n");
            
            i++;
            //imprimir(result);

        }
    }
    
    private static void imprimir (double[][] m)

    {
        for (double[] a : m)
        {
            for (double b : a)
            {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    private static String metodo (int opc, double[][] m, double[][] m_, double[][] result)
    {
        switch (opc)
        {
            case 1:
                NaivStandard.run(m, m_, result, m.length, m.length, m.length);
                return "1. NaivStandard";

            case 2:
                NaivOnArray.run(m, m_, result, m.length, m.length, m.length);
                return "2. NaivOnArray";
            
            case 3:
                NaivKaha.run(m, m_, result, m.length, m.length, m.length);
                return "3. NaivKahan";
            
            case 4:
                NaivLoopUnrollingTwo.run(m, m_, result, m.length, m.length, m.length);
                return "4. NaivLoopUnrollingTwo";
            
            case 5:
                NaivLoopUnrollingThree.run(m, m_, result, m.length, m.length, m.length);
                return "5. NaivLoopUnrollingThree";
            
            case 6:
                NaivLoopUnrollingFour.run(m, m_, result, m.length, m.length, m.length);
                return "6. NaivLoopUnrollingFour";
            
            case 7:
                WinogradOriginal.run(m, m_, result, m.length, m.length, m.length);
                return "7. WinogradOriginal";
            
            case 8:
                WinogradScaled.run(m, m_, result, m.length, m.length, m.length);
                return "8. WinogradScaled";
            
            case 9:
                StrassenNaiv.run(m, m_, result, m.length, m.length, m.length);
                return "9. StrassenNaiv";
            
            case 10:
                StrassenWinograd.run(m, m_, result, m.length, m.length, m.length);
                return "10. StrassenWinograd";
            
            case 11:
                SequentialBlock_III.run(m, m_, result);
                return "11. SequentialBlock_III";
            
            case 12:
                t = new Thread(new ParallelBlock_III(m,m_,result));
                t.start();
                return "12. ParallelBlock_III";
            
            case 13:
                SequentialBlock_IV.run(m, m_, result);
                return "13. SequentialBlock_IV";
            
            case 14:
                t = new Thread(new ParallelBlock_IV(m,m_,result));
                t.start();
                return "14. ParallelBlock_IV";
            
            case 15:
                SequentialBlock_V.run(m, m_, result);
                return "15. SequentialBlock_V";
            
            case 16:
                t = new Thread(new ParallelBlock_V(m,m_,result));
                t.start();
                return "16. ParallelBlock_V";
            
        }

        return "no";
    }
}
