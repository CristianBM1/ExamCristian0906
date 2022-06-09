/*
*	grupo  : 1 GDAM
*	alumno : cristian bermudez moral
*	n.exp. : 7249
*	fecha  : 09/06/2022
 */
package Cheese;

/**
 * Clase main del examen
 * @author ___
 */
public class Main {
	/**
	 * Método main del examen
	 * @param args Argumentos para linea de comandos
	 * @author ___
	 */
     public static void main(String[] args) {
    
         System.out.println("1º Gdam: Entornos de desarrollo");
         Producto producto1 = new Producto("001","LecheExtreme�a", 5, 4.50);
         Producto producto2 = new Producto("002","LecheAsturiana", 7, 7.50);
         ListaProductos lista1 = new ListaProductos("nombre");
         lista1.registraProducto(producto1);
         lista1.registraProducto(producto2);
         producto1.imprime_etiqueta();
         producto2.imprime_etiqueta();
     }
}
