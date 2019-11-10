/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteActualizado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Emmanuel
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i = 0;
        while (true) {

            final String HOST = "192.168.1.70";
            final int PUERTO = 4444;
            DataInputStream entrar;
            DataOutputStream salir;
            i++;
            try {
                Socket socket = new Socket(HOST, PUERTO);
                entrar = new DataInputStream(socket.getInputStream());
                salir = new DataOutputStream(socket.getOutputStream());
                salir.writeUTF(JOptionPane.showInputDialog(null, "Escribe mensaje desde el cliente:"));
                String mensaje = entrar.readUTF();
                System.out.println("Servidor num  " + i + ": " + mensaje);
                socket.close();

            } catch (Exception e) {

            }
        }
    }
}
