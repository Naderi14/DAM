package Extra;

public class Prueba {
    static Lector lector1 = new Lector("Daniel Pinto");
    static Lector lector2 = new Lector("Juan Francisco");
    static Lector lector3 = new Lector ("Pepe Butano");

    public static void main(String[] args) {
        Biblioteca.librosEnBiblioteca();

        lector3.cuantosLibrosTengo();
        lector3.cogerLibroDeBiblioteca(8);
        lector3.dejarLibroDeBiblioteca(4);
        lector3.cuantosLibrosTengo();
        Biblioteca.librosEnBiblioteca();

        lector3.getMisLibretas();
        lector3.setLibretas(50);
        lector3.getMisLibretas();

        /*Biblioteca.librosEnBiblioteca();

        lector1.cogerLibroDeBiblioteca(2);

        Biblioteca.librosEnBiblioteca();

        lector2.cogerLibroDeBiblioteca(3);

        Biblioteca.librosEnBiblioteca();

        lector1.cuantosLibrosTengo();
        lector2.cuantosLibrosTengo();

        lector2.dejarLibroDeBiblioteca(2);
        lector2.cuantosLibrosTengo();

        Biblioteca.librosEnBiblioteca();


        lector1.setLibretas(10);
        lector1.getMisLibretas();

        lector2.getMisLibretas();*/

        // ===========================================================
    }

    // BIBLIOTECA PÚBLICA //
    public static class Biblioteca {
        static int libros = 10;

        public static void librosEnBiblioteca()
        {
            System.out.println("<- La biblioteca tiene " + libros + " libros disponibles ->");
        }
    }

    // ACCIONES DE CADA LECTOR //
    public static class Lector {
        private String nombre;
        private int cantLibretas = 0;
        private int cantLibrosDeBiblioteca = 0;

        public Lector (String nombre)
        {
            this.nombre = nombre;
        }

        public void setLibretas(int cantidad)
        {
            cantLibretas = cantidad;
        }

        public void getMisLibretas()
        {
            System.out.println("<- El lector " + nombre + " tiene " + cantLibretas + " libretas ->");
        }

        public void cogerLibroDeBiblioteca(int cantLibros)
        {
            System.out.println("<- El lector " + nombre + " ha cogido " + cantLibros + " libros de la biblioteca ->");
            cantLibrosDeBiblioteca += cantLibros;
            Biblioteca.libros -= cantLibros;
        }

        public void dejarLibroDeBiblioteca(int cantLibros)
        {
            System.out.println("<- El lector " + nombre + " ha dejado " + cantLibros + " libros de la biblioteca ->");
            cantLibrosDeBiblioteca -= cantLibros;
            Biblioteca.libros += cantLibros;
        }

        public void cuantosLibrosTengo()
        {
            System.out.println("<- El lector " + nombre + " tiene " + cantLibrosDeBiblioteca + " libros de la Biblioteca ->");
        }
    }
}