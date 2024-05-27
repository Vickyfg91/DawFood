/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auxiliar;

import controladores.ProductosJpaController;
import controladores.TpvJpaController;
import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import entidades.Productos;
import entidades.Tpv;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Victoria
 */
public class TareasCrud {

    private static final EntityManagerFactory crud = Persistence.createEntityManagerFactory("com.mycompany_DawFoodVicky_jar_1.0-SNAPSHOTPU");
    private static final ProductosJpaController proJpa = new controladores.ProductosJpaController(crud);
    private static final TpvJpaController tpvJpa = new TpvJpaController(crud);
    
    //Método para incluir un producto en la 
    public static void incluirProducto(Productos nuevoProducto) throws Exception{
        proJpa.create(nuevoProducto);
    }
    
    //Método para crear la lista de productos para visualizarlo en las tabals
    public static List<Productos> crearListaProducto() {
        return proJpa.findProductosEntities();
    }
    
    //Método que recibe un int id para eliminar un producto de la bbdd
    public static void borrarProducto (int id) throws NonexistentEntityException, IllegalOrphanException{
        proJpa.destroy(id);
    }
    
    //Método que recibe un producto y usa el método edit para modificarlo
    public static void editarProducto (Productos productos) throws NonexistentEntityException, Exception{
        proJpa.edit(productos);
    }
    
    //Método que recibe una id y usa el método find para buscar por id
    public static Productos buscarPordId (int id){
        return proJpa.findProductos(id);
    }
    
    //Método para inicializar el tpv
    public static Tpv inicializaTpv(int id){
        return tpvJpa.findTpv(id);
    }
    
    
    
}
