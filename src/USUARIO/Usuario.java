/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package USUARIO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Josue Gavidia
 */
public class Usuario implements Serializable{

    protected String name;
    protected int puntos;
    protected Date fechaCreacion;
    protected String password;
    protected ArrayList<String> historial;

    public Usuario(String name, String password) {
        this.name = name;
        puntos = 0;
        fechaCreacion = new Date();
        this.password = password;
    }

}
