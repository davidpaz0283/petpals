package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Modelo.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PantallaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField InputNombre;
	private JTextField InputContraseña;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PantallaPrincipal() {
		setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setForeground(new Color(0, 0, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenidos ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto Lt", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(75, 24, 386, 34);
		contentPane.add(lblNewLabel);
		
		InputNombre = new JTextField();
		InputNombre.setBounds(119, 104, 198, 27);
		contentPane.add(InputNombre);
		
		InputContraseña = new JPasswordField();
		InputContraseña.setBounds(119, 161, 198, 27);
		contentPane.add(InputContraseña);
		
		JButton Ingresar = new JButton("Ingresar");
		
		Ingresar.setBounds(129, 218, 170, 27);
		contentPane.add(Ingresar);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de Usuario");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(119, 84, 198, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(119, 142, 198, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel Error = new JLabel("");
		Error.setForeground(new Color(255, 0, 0));
		Error.setBounds(119, 193, 198, 14);
		contentPane.add(Error);
		Error.setVisible(false);
		
		
		
		JButton Registrarse = new JButton("Registrarse");
		Registrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registro registro = new Registro();
				dispose();
				
			}
		});
		Registrarse.setBounds(129, 256, 170, 27);
		contentPane.add(Registrarse);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\David\\Desktop\\petpals.png"));
		btnNewButton.setBounds(291, 0, 192, 98);
		contentPane.add(btnNewButton);
		
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(WIDTH);
			}
		});
		salir.setBounds(372, 258, 89, 23);
		contentPane.add(salir);
		
		Error.setVisible(false);
		Ingresar.addActionListener(new ActionListener() { 	
			public void actionPerformed(ActionEvent e) {
				
				String respuesta = Usuario.IniciarSesion(InputNombre.getText(),InputContraseña.getText());
				 if(respuesta.equals("rol:1")) {
					 
					 Home home = new Home(InputNombre.getText());
					 dispose();
					 
				 } else if 
					 (respuesta.equals("rol:2") ) {
						 
						 HomeCuidador homeCuidador = new HomeCuidador(InputNombre.getText());
						 dispose();
						 
				 }else if(respuesta.equals("rol:3")) {
					 
					 ClienteAdm admin = new ClienteAdm();
					 dispose();
				 }{
					 Error.setText(respuesta);
					 Error.setVisible(true);

				 }
				
			}
		
			});
	}
}

