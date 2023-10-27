/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfarces;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public interface DaoInterfaz {
    ArrayList<Object> listarObjeto();
    
    Object buscarObjeto(Object object);
    void agregarObjeto(Object object);
    void editarObjeto(Object object);
    boolean eliminarObjeto(Object object);
    
}
