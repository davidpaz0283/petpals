package Vistas;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {
public static void main (String [] args) {
	
	ImageIcon iconBienvenidos = new ImageIcon(Main.class.getResource("/images/petpals.png"));
	JOptionPane.showMessageDialog(null, "", "Bienvenidos ", 0, iconBienvenidos);
	
	ImageIcon iconDespedida = new ImageIcon(Main.class.getResource("/images/gracias.jpg"));
	JOptionPane.showMessageDialog(null, "","Gracias por confiar en nosotros", 0, iconDespedida);
}
}