
//José Ayala y Mónica Alcañiz

package alquilerBici;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AlquilerBici {

	private JFrame alquilerBici;
	private JTable tableUsuario;
	private JTable tableBici;
	private JTextField textFieldNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlquilerBici window = new AlquilerBici();
					window.alquilerBici.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AlquilerBici() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		alquilerBici = new JFrame();
		alquilerBici.setTitle("Alquilar Bici");
		alquilerBici.getContentPane().setBackground(new Color(255, 235, 205));
		alquilerBici.setBounds(100, 100, 743, 580);
		alquilerBici.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alquilerBici.getContentPane().setLayout(null);
		
		JLabel lbltitulo = new JLabel("Byke on the go");
		lbltitulo.setForeground(new Color(153, 0, 51));
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setFont(new Font("Broadway", Font.ITALIC, 30));
		lbltitulo.setBounds(219, 24, 263, 87);
		alquilerBici.getContentPane().add(lbltitulo);
		
		
		
		tableUsuario = new JTable();
		tableUsuario.setBorder(new EmptyBorder(1, 1, 1, 1));
		tableUsuario.setBounds(10, 279, 226, -84);
		alquilerBici.getContentPane().add(tableUsuario);
		
	
		tableBici = new JTable();
		tableBici.setBounds(10, 435, 226, -84);
		alquilerBici.getContentPane().add(tableBici);
		
		JLabel lblcrearUsuario = new JLabel("Crear Usuario");
		lblcrearUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		lblcrearUsuario.setBounds(363, 155, 84, 14);
		alquilerBici.getContentPane().add(lblcrearUsuario);
		
		JLabel lblnombreUsuario = new JLabel("Nombre");
		lblnombreUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		lblnombreUsuario.setBounds(401, 190, 46, 14);
		alquilerBici.getContentPane().add(lblnombreUsuario);
		
		JLabel lblidUsuario = new JLabel("idUsuario");
		lblidUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		lblidUsuario.setBounds(401, 215, 66, 14);
		alquilerBici.getContentPane().add(lblidUsuario);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(507, 184, 86, 20);
		alquilerBici.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JComboBox comboBoxidUsuario = new JComboBox();
		comboBoxidUsuario.setBounds(507, 207, 86, 22);
		alquilerBici.getContentPane().add(comboBoxidUsuario);
		
		JLabel lblAlquilarBici = new JLabel("Alquilar Bici");
		lblAlquilarBici.setFont(new Font("Arial", Font.BOLD, 12));
		lblAlquilarBici.setBounds(363, 312, 84, 14);
		alquilerBici.getContentPane().add(lblAlquilarBici);
		
		JLabel lblidBici = new JLabel("idBici");
		lblidBici.setFont(new Font("Arial", Font.BOLD, 12));
		lblidBici.setBounds(401, 346, 46, 14);
		alquilerBici.getContentPane().add(lblidBici);
		
		JLabel lblidUsuarioBici = new JLabel("idUsuario");
		lblidUsuarioBici.setFont(new Font("Arial", Font.BOLD, 12));
		lblidUsuarioBici.setBounds(401, 371, 66, 14);
		alquilerBici.getContentPane().add(lblidUsuarioBici);
		
		JComboBox comboBoxidBici = new JComboBox();
		comboBoxidBici.setBounds(507, 338, 86, 22);
		alquilerBici.getContentPane().add(comboBoxidBici);
		
		JComboBox comboBoxidUsuarioBici = new JComboBox();
		comboBoxidUsuarioBici.setBounds(507, 363, 86, 22);
		alquilerBici.getContentPane().add(comboBoxidUsuarioBici);
		
		
		JLabel lblDevolverBici = new JLabel("Devolver Bici");
		lblDevolverBici.setFont(new Font("Arial", Font.BOLD, 12));
		lblDevolverBici.setBounds(363, 434, 84, 14);
		alquilerBici.getContentPane().add(lblDevolverBici);
		
		JLabel lblidUsuarioDevolver = new JLabel("idUsuario");
		lblidUsuarioDevolver.setFont(new Font("Arial", Font.BOLD, 12));
		lblidUsuarioDevolver.setBounds(401, 467, 66, 14);
		alquilerBici.getContentPane().add(lblidUsuarioDevolver);
		
		JLabel lbliddevolverBici = new JLabel("idBici");
		lbliddevolverBici.setFont(new Font("Arial", Font.BOLD, 12));
		lbliddevolverBici.setBounds(401, 497, 46, 14);
		alquilerBici.getContentPane().add(lbliddevolverBici);
		
		JComboBox comboBoxidBiciDevolver = new JComboBox();
		comboBoxidBiciDevolver.setBounds(507, 459, 86, 22);
		alquilerBici.getContentPane().add(comboBoxidBiciDevolver);
		
		JComboBox comboBoxidUsuarioBiciDevolver = new JComboBox();
		comboBoxidUsuarioBiciDevolver.setBounds(507, 489, 86, 22);
		alquilerBici.getContentPane().add(comboBoxidUsuarioBiciDevolver);
		
		JScrollPane scrollPaneUsuario = new JScrollPane(tableUsuario);
		scrollPaneUsuario.setBounds(10, 180, 281, 117);
		alquilerBici.getContentPane().add(scrollPaneUsuario);
		
		JScrollPane scrollPaneBici = new JScrollPane(tableBici);
		scrollPaneBici.setBounds(10, 337, 281, 117);
		alquilerBici.getContentPane().add(scrollPaneBici);
		
		
		JButton btnMostrarBici = new JButton("Mostrar Bicis");
		btnMostrarBici.setFont(new Font("Arial", Font.BOLD, 12));
		
		
		btnMostrarBici.setBounds(74, 303, 153, 23);
		alquilerBici.getContentPane().add(btnMostrarBici);
		
		JButton btnmostrarUsuario = new JButton("Mostrar Usuario");
		btnmostrarUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		btnmostrarUsuario.setBounds(74, 146, 153, 23);
		alquilerBici.getContentPane().add(btnmostrarUsuario);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alquilerBici.dispose();
			}
		});
		
	
		btnSalir.setBounds(628, 24, 89, 23);
		alquilerBici.getContentPane().add(btnSalir);
		
		


	}
}
