/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package USUARIO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Josue Gavidia
 */
public class ManagerUsuarios {

    private RandomAccessFile RAF;
    private File F;
    private final String path = "Usuarios";
    public static ArrayList<Usuario> users;

    public ManagerUsuarios() throws IOException, ClassNotFoundException {
        F = new File(path);
        RAF = new RandomAccessFile(path + "/usuarios.onion", "rw");
        this.createUserFolder();
        createDefaults();
        Search();

    }

    private void createUserFolder() throws FileNotFoundException {
        if (!F.exists()) {

            F.mkdir();
            RAF = new RandomAccessFile(path + "/usuarios.onion", "rw");
            System.out.println("CREADO");
            return;
        }
        System.out.println("EXISTE");
    }
//SERIALIZAR
    private void createDefaults() throws IOException {

        Usuario usOne = new Usuario("PlayerOne", "default");
        Usuario usTwo = new Usuario("PlayerTwo", "default");
        Usuario usThree = new Usuario("PlayerThree", "default");
        Usuario usFour = new Usuario("PlayerFour", "default");

        ByteArrayOutputStream ByteCereal = new ByteArrayOutputStream();
        ObjectOutputStream ObjectCereal = new ObjectOutputStream(ByteCereal);

        RAF.seek(0);
        ObjectCereal.writeObject(usOne);
        byte[] spaghetifier1 = ByteCereal.toByteArray();
        RAF.writeInt(spaghetifier1.length);
        RAF.write(spaghetifier1);
        ByteArrayOutputStream ByteCereal2 = new ByteArrayOutputStream();
        ObjectOutputStream ObjectCereal2 = new ObjectOutputStream(ByteCereal2);

        ObjectCereal2.writeObject(usTwo);
        byte[] spaghetifier2 = ByteCereal2.toByteArray();
        RAF.writeInt(spaghetifier2.length);
        RAF.write(spaghetifier2);
        ByteArrayOutputStream ByteCereal3 = new ByteArrayOutputStream();
        ObjectOutputStream ObjectCereal3 = new ObjectOutputStream(ByteCereal3);

        ObjectCereal3.writeObject(usThree);
        byte[] spaghetifier3 = ByteCereal3.toByteArray();
        RAF.writeInt(spaghetifier3.length);
        RAF.write(spaghetifier3);
        ByteArrayOutputStream ByteCereal4 = new ByteArrayOutputStream();
        ObjectOutputStream ObjectCereal4 = new ObjectOutputStream(ByteCereal4);

        ObjectCereal4.writeObject(usFour);
        byte[] spaghetifier4 = ByteCereal4.toByteArray();
        RAF.writeInt(spaghetifier4.length);
        RAF.write(spaghetifier4);

    }
 //DESERIALIZAR
    public void Search() throws IOException, ClassNotFoundException {
        ObjectInputStream ObjectCereal;
        ByteArrayInputStream ByteCereal;
        byte[] temp;
        Usuario tempUser;

        RAF.seek(0);

        temp = new byte[RAF.readInt()];
        RAF.readFully(temp);

        ByteCereal = new ByteArrayInputStream(temp);
        ObjectCereal = new ObjectInputStream(ByteCereal);

        tempUser = (Usuario) ObjectCereal.readObject();
        System.out.println(tempUser.name + " " + tempUser.password);
        RAF.seek(RAF.getFilePointer());
        temp = new byte[RAF.readInt()];
        RAF.readFully(temp);
        ByteCereal = new ByteArrayInputStream(temp);
        ObjectCereal = new ObjectInputStream(ByteCereal);
        tempUser = (Usuario) ObjectCereal.readObject();
        System.out.println(tempUser.name + " " + tempUser.password);
        RAF.seek(RAF.getFilePointer());
        temp = new byte[RAF.readInt()];
        RAF.readFully(temp);
        ByteCereal = new ByteArrayInputStream(temp);
        ObjectCereal = new ObjectInputStream(ByteCereal);
        tempUser = (Usuario) ObjectCereal.readObject();
        System.out.println(tempUser.name + " " + tempUser.password);
        RAF.seek(RAF.getFilePointer());
        temp = new byte[RAF.readInt()];
        RAF.readFully(temp);
        ByteCereal = new ByteArrayInputStream(temp);
        ObjectCereal = new ObjectInputStream(ByteCereal);
        tempUser = (Usuario) ObjectCereal.readObject();
        System.out.println(tempUser.name + " " + tempUser.password);

    }
}
