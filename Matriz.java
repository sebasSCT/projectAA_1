package proyecto_java;

import java.util.ArrayList;
import java.util.Random;

public class Matriz 
{
    public static void main(String[] args) 
    {
        //generar(5000, "matriz_12"); 
        //cargar("matriz_9");
    }

    private static void cargar (String name)
    {
        double[][] m_ = cargar_matriz(name);
    }

    private static void generar (int size, String file)
    {
        int[] m = iniciar_matriz(size);
        
        int i = 0, x = 0, size_ = size * size;
        String save = "";
        System.out.println("-----------------GUARDAR--------------------");
        for (int b : m)
        {

            if (i == 5000)
            {
                return;
            }

            if (x == size - 1)
            {
                Archivos.escribirEnArchivo("proyecto_java/Matrices/" + file + ".txt",  save + b + ";\n", false);
                save = "";
                x = 0;
            }
            else
            {
                save += b + ",";
                x++;
            }
            i++;
            System.out.println(i+"/"+size_);
            // System.out.println(i+"/"+5585000);
        }
    }

    private static int[] iniciar_matriz (int size)
    {
        Random r = new Random();

        //ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        int[] a = new int[size*size];

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                a[i + j * size] = r.nextInt(1000, 9999);
            }
            System.out.println((i + 1) + "/" + size);
        }

        return a;
    }

    public static double[][] cargar_matriz (String matriz)
    {
        System.out.println("Reading file...");
        String a = Archivos.leerArchivoTxt("/proyecto_java/Matrices/" + matriz + ".txt");
        String[] b = a.split(";");

        double[][] m = new double[b.length][b.length];
        
        for (int i = 0; i < b.length; i++)
        {
            String[] c = b[i].split(",");
            for (int j = 0; j < b.length; j++)
            {       
                m[i][j] = Integer.parseInt(c[j]);
            }
            System.out.println("Reading file... (" + (i + 1) + "/" + b.length + ")");
        }

        return m;
    }
    
}
