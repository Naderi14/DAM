package Extra;

/*. Una empresa que se dedica a la venta de desinfectantes necesita un programa para gestionar las
facturas. En cada factura figura: el código del artículo, la cantidad vendida en litros y el
precio por litro.
Se pide de 5 facturas introducidas: Facturación total, cantidad en litros vendidos del artículo 1
y cuantas facturas se emitieron de más de 600 €.

Luego igual que el anterior pero suponiendo que no se introduce el precio por litro. Solo existen tres
productos con precios:
1- 0,6 €/litro, 2- 3 €/litro y 3- 1,25 €/litro.
*/

import javax.swing.*;
import java.awt.im.spi.InputMethod;
import java.util.*;

public class VentaDesinfectantes
{
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        Dictionary<Integer, Float> dictionaryArticles = new Hashtable<>();
        dictionaryArticles.put(1, 0.6f);
        dictionaryArticles.put(2, 3f);
        dictionaryArticles.put(3, 1.25f);

        List<Hashtable> productsSelled = new ArrayList<>();;

        int cantidadLitrosVendidos, codigoArticulo, contador = 0;
        double facturacionTotal;

        System.out.println("Introduce a continuación los datos de las 5 facturas");
        for (int i = 0; i < 5; i++)
        {
            while (true)
            {
                System.out.println("Introduzca el código de artículo");
                try
                {
                    codigoArticulo = leer.nextInt();
                } catch (Exception e) {
                    System.out.println("Debe ser un valor numerico sin decimales");
                    continue;
                }

                if (codigoArticulo > dictionaryArticles.size() )
                {
                    System.out.println("Codigo de artículo erróneo\n");
                }
                else
                    break;
            }

            while (true)
            {
                System.out.println("Introduzca el número de litros vendidos");
                try
                {
                    cantidadLitrosVendidos = leer.nextInt();
                } catch (Exception e) {
                    System.out.println("Debe ser un valor numerico sin decimales");
                    continue;
                }

                if (cantidadLitrosVendidos < 1)
                {
                    System.out.println("No puede ser que se hayan ventido 0 o menos litros\n");
                }
                else
                    break;
            }

            facturacionTotal = dictionaryArticles.get(codigoArticulo) * cantidadLitrosVendidos;

            Hashtable<String, Double> factura = new Hashtable<>();

            factura.put("codigo", (double)codigoArticulo);
            factura.put("cantidad", (double)cantidadLitrosVendidos);
            factura.put("totalFactura", facturacionTotal);

            productsSelled.add(factura);
        }

        // Mostrar los productos
        for (int i = 0; i < 5; i++)
        {
            System.out.println("Factura " + (i + 1));
            System.out.println("Código del artículo: " + productsSelled.get(i).get("codigo"));
            System.out.println("Cantidad vendida: " + productsSelled.get(i).get("cantidad"));
            System.out.println("Facturación Total: " + Math.round((Double) productsSelled.get(i).get("totalFactura")) + "€\n");

            if ((Double)productsSelled.get(i).get("totalFactura") > 600.0)
                contador++;
        }

        System.out.println("Se han contabilizado " + contador + " facturas de mas de 600€");

        InputMap inputMap = new InputMap();
    }
}
