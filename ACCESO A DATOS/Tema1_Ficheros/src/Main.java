import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        PropuestaEjercicio6();
    }

    // Minuto 26:14 Video-Tutoria 30/09/2025
    public static void PropuestaEjercicio1()
    {
        Scanner sc = new Scanner(System.in);

        File directorio = new File("E:"+File.separator+"DESENVOLUPAMENT APLICACIONS MULTIPLATAFORMA"+File.separator+"ACCESO A DATOS"+ File.separator+"Tema1_Ficheros"+File.separator+"Nuevo_Directorio");
        File archivo = new File("E:"+File.separator+"DESENVOLUPAMENT APLICACIONS MULTIPLATAFORMA"+File.separator+"ACCESO A DATOS"+ File.separator+"Tema1_Ficheros"+File.separator+"Nuevo_Directorio"+File.separator+"miArchivo.txt");

        int opcion;
        do
        {
            System.out.println("1. Crear un directorio en la ruta absoluta de Nuevo_Directorio\n" +
                    "2. Crear un nuevo fichero de texto llamada fichero_de_texto2.txt en Nuevo_Directorio\n" +
                    "3. Eliminar el fichero fichero_de_texto.txt\n" +
                    "4. Eliminar el directorio Nuevo_Directorio\n" +
                    "5. Salir");

            opcion = sc.nextInt();

            switch (opcion)
            {
                case 1:
                    if (directorio.mkdir())
                        System.out.println("El directorio se ha creado correctamente");
                    else
                        System.out.println("El directorio no se ha podido crear");
                    break;
                case 2:
                    try
                    {
                        if (archivo.createNewFile())
                            System.out.println("El archivo se ha creado correctamente");
                        else
                            System.out.println("El archivo no se ha podido crear");
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    if (archivo.exists())
                    {
                        if (archivo.delete())
                            System.out.println("El archivo se ha eliminado correctamente");
                        else
                            System.out.println("El archivo no se ha podido eliminar");
                    }
                    else
                        System.out.println("El archivo no se ha encontrado");
                    break;
                case 4:
                    if (directorio.exists())
                    {
                        if (directorio.delete())
                            System.out.println("El directorio se ha eliminado correctamente");
                        else
                            System.out.println("El directorio no se ha podido eliminar");
                    }
                    else
                        System.out.println("El directorio no se ha encontrado");
                    break;
                case 5:
                    System.out.println("Se ha finalizado la aplicacion");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 5);
    }

    // Minuto 36:45 Video-Tutoria 30/09/2025
    public static void PropuestaEjercicio2()
    {
        Scanner sc = new Scanner(System.in);
        try (FileWriter fw = new FileWriter("miCarpetaPrivada"+File.separator+"miFicheroALeer.txt"))
        {
            System.out.println("Ingrese el texto del archivo:");
            String texto = sc.nextLine();
            fw.write(texto);
            fw.flush();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("A continuación leeremos lo que has escrito.");
        try (FileReader fr = new FileReader("miCarpetaPrivada"+File.separator+"miFicheroALeer.txt"))
        {
            int valor;
            while ((valor = fr.read()) != -1)
            {
                System.out.print((char)valor);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    // Minuto 40:08 Video-Tutoria 30/09/2025
    public static void PropuestaEjercicio3()
    {
        Scanner sc = new Scanner(System.in);
        try (FileWriter fw = new FileWriter("miCarpetaPrivada"+File.separator+"miFicheroALeer.txt"))
        {
            String[] cadenaStrings;
            System.out.println("Ingrese 3 textos para el archivo:");
            String texto1 = sc.nextLine();
            String texto2 = sc.nextLine();
            String texto3 = sc.nextLine();
            cadenaStrings = new String[] {texto1, texto2, texto3};
            for (String cadena : cadenaStrings)
            {
                fw.write(cadena);
                fw.append("\n");
            }
            fw.append("*");
            fw.flush();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("A continuación leeremos lo que has escrito.");
        try (FileReader fr = new FileReader("miCarpetaPrivada"+File.separator+"miFicheroALeer.txt"))
        {
            int valor;
            while ((valor = fr.read()) != -1)
            {
                System.out.print((char)valor);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    // Minuto 43:19 Video-Tutoria 30/09/2025 FileWriter
    public static void PropuestaEjercicio4()
    {
        try (FileReader fr = new FileReader(new File("miCarpetaPrivada"+File.separator+"miFicheroALeer.txt")))
        {
            int valor;
            while ((valor = fr.read()) != -1)
            {
                System.out.print((char)valor);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    // Minuto 44:08 Video-Tutoria 30/09/2025 FileWriter
    public static void PropuestaEjercicio5()
    {
        Scanner sc = new Scanner(System.in);

        try (FileWriter fw = new FileWriter(new File("miCarpetaPrivada"+File.separator+"Empleados.txt"));
            FileReader fr = new FileReader("miCarpetaPrivada"+File.separator+"Empleados.txt"))
        {
            String[] listaEmpleados = new String[5];
            System.out.println("Ingrese 5 nombres de empleados");
            for (int i = 0; i < 5; i++)
            {
                System.out.print("Ingrese el nombre del empleado "+(i+1)+": ");
                listaEmpleados[i] = sc.nextLine();
            }

            fw.write("- LISTA DE EMPLEADOS -\n-----------------------------------\n");
            for (int i = 0; i < 5; i++)
            {
                fw.write("ID: " + (i+1) + " - " + listaEmpleados[i] + "\n");
            }

            fw.flush();

            int valor;
            while ((valor = fr.read()) != -1)
            {
                System.out.print((char)valor);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    // Minuto 52:30 Video-Tutoria 30/09/2025 RandomAccessFile
    // Minuto 53:06 Segunda parte ejercicio
    // Minuto 53:56 Tercera parte
    public static void PropuestaEjercicio6()
    {
        Scanner sc = new Scanner(System.in);
        File miArchivo = new File("miCarpetaPrivada"+File.separator+"miFichero2.txt");

        try
        {
            miArchivo.createNewFile();
            RandomAccessFile raf = new RandomAccessFile(miArchivo, "rw");

            String[] apellidos = {"Fernandez", "Gil", "Sanchez", "Ramos", "Garcia", "Llopart", "Castelblanque"};
            int[] dep = {10, 20, 10, 10, 30, 30, 20};
            double[] salario = {100.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0};

            StringBuffer buffer = null;

            for (int i = 0; i < apellidos.length; i++)
            {
                raf.writeInt(i+1);
                buffer = new StringBuffer(apellidos[i]);
                buffer.setLength(15);
                raf.writeChars(buffer.toString());
                raf.writeInt(dep[i]);
                raf.writeDouble(salario[i]);
            }

            raf.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            RandomAccessFile raf = new RandomAccessFile(miArchivo, "rw");

            int id, dep, posicion;
            double salario;
            char[] apellido = new char[15];
            char aux;

            int identificador = 5;

            posicion = (identificador - 1) * 46; // a partir de tal posicion, que muestre cada fila de 46 caracteres en el fichero

            while (true)
            {
                raf.seek(posicion);
                id = raf.readInt();

                for (int i = 0; i < apellido.length; i++)
                {
                    aux = raf.readChar();
                    apellido[i] = aux;
                }

                String apellidos = new String(apellido);
                dep = raf.readInt();
                salario = raf.readDouble();

                if (id > 0)
                    System.out.printf("ID: %d | Apellido: %s | Departamento: %d | Salario: %.2f\n", id,apellidos.trim(), dep, salario);

                posicion = posicion + 46;

                if (raf.getFilePointer() == raf.length())
                    break;
            }
            raf.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}