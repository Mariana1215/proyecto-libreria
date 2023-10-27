/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfarces;

import modelos.Usuario;

/**
 *
 * @author LENOVO
 */
public interface DAOLoginInterfaz {
    
    Usuario buscarUsuario(String usuario, String contrasenia);
    
}
