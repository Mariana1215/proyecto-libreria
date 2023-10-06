/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;


import DAO.DAOLogin;
import modelos.Usuario;


/**
 *
 * @author Manuela Gomez
 */
public class ControladorLogin {


    DAOLogin DAOlogin;

    public ControladorLogin() {
        this.DAOlogin = new DAOLogin();
    }
    
    public Usuario buscarUsuario(String usuario, String contrasenia) {
        return DAOlogin.buscarUsuario(usuario, contrasenia);
    }

    

    }
