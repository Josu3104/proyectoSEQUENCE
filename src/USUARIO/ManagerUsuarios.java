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

    private RandomAccessFile RAF = null;
    private File F;
    private final String path = "Usuarios";
    public static ArrayList<Usuario> users;

    public ManagerUsuarios() throws IOException, ClassNotFoundException {
        F = new File(path);
        this.createUserFolder();
        createDefaults();
      

    }

    private void createUserFolder() throws FileNotFoundException {
        if (!F.exists()) {

            F.mkdir();
            System.out.println("Folder Usuarios ");
        }
        RAF = new RandomAccessFile(path + "/usuarios.onion", "rw");

    }

    private void createDefaults() throws IOException {

        Usuario usOne = new Usuario("ERICK", "Player 1", "default");
        Usuario usTwo = new Usuario("IAN", "Player 2", "default");
        Usuario usThree = new Usuario("VALERIE", "Player 3", "default");
        Usuario usFour = new Usuario("SANTIAGO", "Player 4", "default");

        ByteArrayOutputStream ByteCereal = new ByteArrayOutputStream();
        ObjectOutputStream ObjectCereal = new ObjectOutputStream(ByteCereal);

        Serializer(usOne);
        Serializer(usTwo);
        Serializer(usThree);
        Serializer(usFour);

    }
//SERIALIZAR

    public void Serializer(Usuario user) throws IOException {
        ByteArrayOutputStream ByteCereal = new ByteArrayOutputStream();
        ObjectOutputStream ObjectCereal = new ObjectOutputStream(ByteCereal);

        RAF.seek(RAF.length());
        ObjectCereal.writeObject(user);
        byte[] spaghetifier = ByteCereal.toByteArray();
        RAF.writeInt(spaghetifier.length);
        RAF.write(spaghetifier);

    }

    public Usuario SearchUser(String username) throws IOException, ClassNotFoundException {
        return DeSerializer(username, 0);
    }
    //RECURSIVA
    //DESERIALIZAR
// i + 4 +tamaño
    private Usuario DeSerializer(String username, long index) throws IOException, ClassNotFoundException {
        ObjectInputStream ObjectCereal;
        ByteArrayInputStream ByteCereal;
        byte[] temp;
        Usuario tempUser;

        if (index < RAF.length()) {
            

            RAF.seek(index);
            int ObjectSize = RAF.readInt();
            temp = new byte[ObjectSize];
            RAF.readFully(temp);

            ByteCereal = new ByteArrayInputStream(temp);
            ObjectCereal = new ObjectInputStream(ByteCereal);
            tempUser = (Usuario) ObjectCereal.readObject();

            if (tempUser!=null&&tempUser.getUsername().equals(username)) {
                return tempUser;
            } else {
                return DeSerializer(username, index+4+ObjectSize);
            }

        }
        System.out.println("Not found");
        return null;

    }

   
}
