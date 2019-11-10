/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Emmanuel
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ServerSocket server = null;
        final int PUERTO = 4444;
        Socket socket = null;
        DataInputStream entrar;
        DataOutputStream salir;
        String leerMensaje = "";
        int i = 0;

        try {
            server = new ServerSocket(PUERTO);
           
            while (true) {
                i++;
                socket = server.accept();
                entrar = new DataInputStream(socket.getInputStream());
                salir = new DataOutputStream(socket.getOutputStream());
                leerMensaje = entrar.readUTF(); //mensaje del cliente
                System.out.println("Mensaje num " + i + " del CLIENTE: " + leerMensaje);
                String mensaje = JOptionPane.showInputDialog(null, "escribe mensaje desde el servidor:");
                salir.writeUTF(mensaje);
                socket.close();

            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
