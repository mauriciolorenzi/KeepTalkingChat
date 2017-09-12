package chat;
import java.rmi.*;
import java.rmi.server.*;

import javax.swing.JOptionPane;
 
public class StartServer {
	public static void main(String[] args) {
		try {
		 		
			String ip = JOptionPane.showInputDialog("Digite o IP: ");
			String port = JOptionPane.showInputDialog("\nDigite a porta: ");
		 	
				//System.setSecurityManager(new RMISecurityManager());
			 	java.rmi.registry.LocateRegistry.createRegistry(Integer.parseInt(port));
			 	
			 	IServer server = new Server();
			 				 				 
//				IServer stub = (IServer) UnicastRemoteObject.exportObject(server, 9999); 	
				
			 	//System.setProperty("java.rmi.server.hostname", ip);
			 	
				Naming.rebind("rmi://" + ip + ":" + port + "/chat", server);
				System.out.println("[System] Chat Server is ready at ip => " + ip + " and port => " + port);
				
			}catch (Exception e) {
					System.out.println("Chat Server failed: " + e);
			}
	}
}