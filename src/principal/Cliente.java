/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

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
        
        final String HOST = "192.168.1.70";
        final int puerto = 4444;
        DataInputStream entrar;
        DataOutputStream salir;
        
        try{
            Socket socket = new Socket(HOST,puerto);
            System.out.println("CLIENTE coNECTADO");
            entrar = new DataInputStream(socket.getInputStream());
            salir = new DataOutputStream(socket.getOutputStream());
            salir.writeUTF("enviando mensaje desde el CLIENTEEEE....");
            String mensaje = entrar.readUTF();
            System.out.println("Mostrando mensaje del servidor: --->>> "+mensaje);
            socket.close();
            
            
        }catch(Exception e){
            
        }
    }
    
}
