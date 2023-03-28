package proyecto_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivos
{
    public static String leerArchivoTxt ( String ruta )
	{
		String msn = "";
		FileReader input = null;
		try
		{
			input = new FileReader(getPath(ruta));

			BufferedReader buffer = new BufferedReader(input);

			String aux = "";
			while ( aux != null )
			{
				aux = buffer.readLine();
				msn += (aux == null) ? "" : aux;
			}

		} catch ( IOException e )
		{
			e.printStackTrace();
		}

		return msn;
	}

    public static void escribirEnArchivo (String ruta, String data, boolean sobreescribir)
	{
		FileWriter fw;

		try
		{
            if (!sobreescribir)
            {
                //Escribir en siguiente linea
                fw = new FileWriter(getPath(ruta), true);
            }
            else
            {
                //Sobreescribir archivo
                fw = new FileWriter(getPath(ruta));
            }
			
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(data);
			bw.flush();
			bw.close();
		} catch ( IOException e )
		{
			e.printStackTrace();
		}
	}

    private static String getPath ( String ruta )
	{
		String raiz = System.getProperty("user.dir");
		String filePath = raiz + "/" + ruta;
		return filePath;
	}
}
