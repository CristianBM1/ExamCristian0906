/*
 * Examen Entornos de desarrollo - Enunciado
 */

package Cheese;
/**
 * Imports del paquete
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase para gestionar listas de productos
 * @author loned
 *
 */
public class ListaProductos {

	/**
	 * nombre de la lista de productos
	 */
	public String nombreLista;
    /**
     * Estructura HashMap para almacenar los productos de la lista de productos
     * @see "HashMap java doc"
     */
    private HashMap<String, Producto> listaP = new HashMap<String, Producto>();
    
    /**
     * Cuenta calculada con el número de productos contenidos en la lista
     */
    private int n = 0;
    
    private int getNumProductos() {
        return n;
    }

    private void setNumProductos(int n) {
        this.n = n;
    }
    /**
     * Comprueba si la cadena pasada es valida ( no está vacía)
     * 
     * @param campo cadena a analizar
     * @return True: Cadena vacía, False: Cadena correcta
     */
    private boolean parametro_vacio(String campo){
    
        if ((campo.replace(" ","").isEmpty()) || (campo == null))  return true; else return false;
    }
    
    /**
     * Si la cadena es valida lo nombra como 'noNamed'. Osino devuelve la variable 'nombre'.
     * @param nombre cadena entregada
     */
    
    public ListaProductos(String nombre) {
    	if (parametro_vacio(nombre)) {
    		this.nombreLista = "noNamed";
    	}
    	else {
    	this.nombreLista = nombre;
    	}
    }
    
    /**
     * Te devuelve todos los productos registrados
     * @return devuelve los nombres de los productos
     */
    
    public int totalProductos(){
            return this.getNumProductos();
    }
      
    /**
     * Agrega un nuevo producto a la lista
     * @param prod producto
     * @return Si ese producto existe te devuelve null. Osino crea uno y lo a�ade a 'listaP'. Tendr� un codigo para identificarlo
     */
    
    public Producto registraProducto(Producto prod) {
        
        if (listaP.containsKey(prod.getcode())) {
           return null;
        }else if (parametro_vacio(prod.getcode())) {
        	return null;
        }
        listaP.put(prod.getcode(), prod);
        n++;
        this.setNumProductos(n);
        return prod;
    }

    /**
     * Elimina un producto apartir del codigo
     * Primero usa el metodo 'encuentraProducto' para ver si ese codigo existe y lo guarda en la variable 'prod'.
     * @param codigo del producto
     * @return Si prod es diferente de null elimina ese codigo de 'listaP'. Osino te devuelve otra vez el codigo.
     */
    
    public Producto descartaProducto(String codigo) { 
        
        Producto prod = encuentraProducto(codigo);
        if (prod != null) {
	        listaP.remove(codigo);
	        n--;
	        this.setNumProductos(n);
        }else if(parametro_vacio(codigo)) {
        	return null;
        }
        return prod;
    }

    /**
     * Comprueba si el codigo pasado tiene una clave. 
     * @param codigo para extraer su clave
     * @return Si la clave no esta en 'listaP' te devuelve null. Osino la devuelve el codigo, que esta en 'listaP'.
     */
    
    public Producto encuentraProducto(String codigo) { 
        Producto prod = null;
        
        if (!listaP.containsKey(codigo)) {
            return prod;
        }else if (parametro_vacio(codigo)) {
        	return null;
        }else{
            return listaP.get(codigo);
        }
    }
/**
 * Devuelve un array con los productos registrados en la lista
 * @return array de productos
 */
    public ArrayList<Producto> recuperaProductos() {
        ArrayList<Producto> prodsList = new ArrayList<>();
        prodsList.addAll(listaP.values());
        return prodsList;
    }
    

}
