
//José Ayala y Mónica Alcañiz

package alquilerBici;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AlquilerBici {

	private JFrame alquilerBici;
	private JTable tableUsuario;
	private JTable tableBici;
	private JTextField textFieldNombre;
	private JTextField textFieldUsuario;
	private JTextField textFieldcrearBici;

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
		alquilerBici.setBounds(100, 100, 644, 788);
		alquilerBici.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alquilerBici.getContentPane().setLayout(null);
		
		JLabel lbltitulo = new JLabel("Byke on the go");
		lbltitulo.setForeground(new Color(153, 0, 51));
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setFont(new Font("Broadway", Font.ITALIC, 40));
		lbltitulo.setBounds(131, 0, 365, 46);
		alquilerBici.getContentPane().add(lbltitulo);
		
		
		
		tableUsuario = new JTable();
		tableUsuario.setBorder(new EmptyBorder(1, 1, 1, 1));
		tableUsuario.setBounds(10, 279, 226, -84);
		alquilerBici.getContentPane().add(tableUsuario);
		
	
		tableBici = new JTable();
		tableBici.setBounds(10, 435, 226, -84);
		alquilerBici.getContentPane().add(tableBici);
		
		JLabel lblcrearUsuario = new JLabel("Crear Usuario:");
		lblcrearUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		lblcrearUsuario.setBounds(10, 322, 153, 14);
		alquilerBici.getContentPane().add(lblcrearUsuario);
		
		JLabel lblnombreUsuario = new JLabel("Nombre");
		lblnombreUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		lblnombreUsuario.setBounds(50, 347, 81, 14);
		alquilerBici.getContentPane().add(lblnombreUsuario);
		
		
		JLabel lblidUsuarioCrear = new JLabel("idUsuario");
		lblidUsuarioCrear.setFont(new Font("Arial", Font.BOLD, 12));
		lblidUsuarioCrear.setBounds(50, 372, 115, 14);
		alquilerBici.getContentPane().add(lblidUsuarioCrear);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(141, 341, 86, 20);
		alquilerBici.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldNombre.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		Pattern pat = Pattern.compile("^[A-Za-zÑñÁáÉéÍíÓóÚúÜü ]{1,50}$");
					Matcher mat = pat.matcher(textFieldNombre.getText());
					if (!mat.matches()) {
						JOptionPane.showMessageDialog(null, "Formato no válido");
					}
	        	}
	        	
	        	
	        });
		
		JLabel lblAlquilarBici = new JLabel("Alquilar Bici");
		lblAlquilarBici.setFont(new Font("Arial", Font.BOLD, 12));
		lblAlquilarBici.setBounds(343, 522, 84, 14);
		alquilerBici.getContentPane().add(lblAlquilarBici);
		
		JLabel lblidBici = new JLabel("idBici");
		lblidBici.setFont(new Font("Arial", Font.BOLD, 12));
		lblidBici.setBounds(379, 547, 46, 14);
		alquilerBici.getContentPane().add(lblidBici);
		
		JLabel lbliduUsuarioAlquilar = new JLabel("idUsuario");
		lbliduUsuarioAlquilar.setFont(new Font("Arial", Font.BOLD, 12));
		lbliduUsuarioAlquilar.setBounds(379, 572, 88, 14);
		alquilerBici.getContentPane().add(lbliduUsuarioAlquilar);
		
		JComboBox comboBoxidBici = new JComboBox();
		comboBoxidBici.setBounds(483, 539, 86, 22);
		alquilerBici.getContentPane().add(comboBoxidBici);
		
		JComboBox comboBoxidUsuarioBici = new JComboBox();
		comboBoxidUsuarioBici.setBounds(483, 564, 86, 22);
		alquilerBici.getContentPane().add(comboBoxidUsuarioBici);
		
		
		JLabel lblDevolverBici = new JLabel("Devolver Bici");
		lblDevolverBici.setFont(new Font("Arial", Font.BOLD, 12));
		lblDevolverBici.setBounds(343, 631, 153, 14);
		alquilerBici.getContentPane().add(lblDevolverBici);
		
		JLabel lblidUsuarioDevolver = new JLabel("idUsuario");
		lblidUsuarioDevolver.setFont(new Font("Arial", Font.BOLD, 12));
		lblidUsuarioDevolver.setBounds(379, 656, 88, 14);
		alquilerBici.getContentPane().add(lblidUsuarioDevolver);
		
		JComboBox comboBoxidBiciDevolver = new JComboBox();
		comboBoxidBiciDevolver.setBounds(483, 648, 86, 22);
		alquilerBici.getContentPane().add(comboBoxidBiciDevolver);
		
		JScrollPane scrollPaneUsuario = new JScrollPane(tableUsuario);
		scrollPaneUsuario.setBounds(10, 95, 281, 182);
		alquilerBici.getContentPane().add(scrollPaneUsuario);
		
		JScrollPane scrollPaneBici = new JScrollPane(tableBici);
		scrollPaneBici.setBounds(343, 95, 281, 182);
		alquilerBici.getContentPane().add(scrollPaneBici);
		
		JLabel lblIdbicicrear = new JLabel("idBiciCrear");
		lblIdbicicrear.setFont(new Font("Dialog", Font.BOLD, 12));
		lblIdbicicrear.setBounds(379, 347, 81, 14);
		alquilerBici.getContentPane().add(lblIdbicicrear);
		
		textFieldcrearBici = new JTextField();
		textFieldcrearBici.setColumns(10);
		textFieldcrearBici.setBounds(483, 341, 86, 20);
		alquilerBici.getContentPane().add(textFieldcrearBici);
		
		
		
		DefaultTableModel modelUsuario = new DefaultTableModel();
		modelUsuario.addColumn("Código");
		modelUsuario.addColumn("Nombre");
		modelUsuario.addColumn("Bici alquilada");
		
		
		DefaultTableModel modelBici = new DefaultTableModel();
		modelBici.addColumn("Código");
		modelBici.addColumn("Estado");
		
		
		
		JButton btnMostrarBici = new JButton("Mostrar Bicis");
		btnMostrarBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					modelBici.setRowCount(0);
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM bici");

					while (rs.next()) {
						Object[] row = new Object[2];
						row[0] = rs.getInt("idbici");
						row[1] = rs.getString("disponibilidad");
						comboBoxidBici.addItem(rs.getInt("idbici"));
						

						modelBici.addRow(row);
					}

					tableBici.setModel(modelBici);
					tableBici.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnMostrarBici.setFont(new Font("Arial", Font.BOLD, 12));
		
		
		btnMostrarBici.setBounds(407, 288, 153, 23);
		alquilerBici.getContentPane().add(btnMostrarBici);
		
		
		
		JButton btnmostrarUsuario = new JButton("Mostrar Usuario");
		btnmostrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					modelUsuario.setRowCount(0);
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");

					while (rs.next()) {
						Object[] row = new Object[3];
						row[0] = rs.getInt("idusuario");
						row[1] = rs.getString("nombre");
						row[2] = rs.getInt("bici_idbici");
						comboBoxidUsuarioBici.addItem(rs.getInt("idusuario"));

						modelUsuario.addRow(row);
					}
					con.close();

					tableUsuario.setModel(modelUsuario);
					tableUsuario.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnmostrarUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		btnmostrarUsuario.setBounds(74, 288, 153, 23);
		alquilerBici.getContentPane().add(btnmostrarUsuario);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alquilerBici.dispose();
			}
		});
		
	
		btnSalir.setBounds(506, 11, 89, 23);
		alquilerBici.getContentPane().add(btnSalir);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(141, 366, 86, 20);
		alquilerBici.getContentPane().add(textFieldUsuario);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {

					Connection con = ConnectionSingleton.getConnection();
					PreparedStatement ins_pstmt = con.prepareStatement("INSERT INTO usuario (nombre, idusuario)  VALUES (?,?)");
					ins_pstmt.setString(1, textFieldNombre.getText());
					ins_pstmt.setInt(2, Integer.parseInt(textFieldUsuario.getText()));
					int rowsInserted = ins_pstmt.executeUpdate();
					ins_pstmt.close();

					JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
					
					
					textFieldNombre.setText("");
					textFieldUsuario.setText("");
					
					Statement stmt = con.createStatement();
					
					ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
					modelUsuario.setRowCount(0);
					
					while (rs.next()) {
						Object[] row = new Object[3];
						row[0] = rs.getInt("idusuario");
						row[1] = rs.getString("nombre");
						row[2] = rs.getInt("bici_idbici");
						

						modelUsuario.addRow(row);
					}
						

				} catch (SQLIntegrityConstraintViolationException error) {
					JOptionPane.showMessageDialog(null, "No pueden haber entradas duplicadas");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Hay casillas vacias", "Error", JOptionPane.ERROR_MESSAGE);
				}

				
			}
		});
		btnCrearUsuario.setBounds(74, 400, 153, 23);
		alquilerBici.getContentPane().add(btnCrearUsuario);
		
		JButton btnAlquilar = new JButton("Alquilar");
		btnAlquilar.setFont(new Font("Arial", Font.BOLD, 12));
		btnAlquilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					Connection con = ConnectionSingleton.getConnection();
					PreparedStatement upd_pstmt = con.prepareStatement("UPDATE bici SET disponibilidad = 1 WHERE idbici = ?");
					upd_pstmt.setInt(1, (int) comboBoxidBici.getSelectedItem());
					int rowsUpdated = upd_pstmt.executeUpdate();
					upd_pstmt.close();
					
					PreparedStatement upd_pstmt2 = con.prepareStatement("UPDATE usuario SET bici_idbici = ? WHERE idusuario = ?");
					upd_pstmt2.setInt(1, (int) comboBoxidBici.getSelectedItem());
					upd_pstmt2.setInt(2, (int) comboBoxidUsuarioBici.getSelectedItem());
					int rowsUpdated2 = upd_pstmt2.executeUpdate();
					upd_pstmt2.close();
					
					PreparedStatement ins_pstmt = con.prepareStatement("SELECT idbici FROM bici WHERE disponibilidad = 0");
					ResultSet rowsInserted = ins_pstmt.executeQuery();
					ins_pstmt.close();				
					
					Statement stmt = con.createStatement();
					
					Statement stmt3 = con.createStatement();

					
					ResultSet rs = stmt.executeQuery("SELECT * FROM bici");
					
					ResultSet rs3 = stmt3.executeQuery("SELECT idbici FROM bici WHERE disponibilidad = 0");
					
					
					
					modelBici.setRowCount(0);
					comboBoxidBici.removeAllItems();
					
					while (rs.next()) {
						Object[] row = new Object[2];
						row[0] = rs.getInt("idbici");
						row[1] = rs.getString("disponibilidad");
						modelBici.addRow(row);
					}
					
					while (rs3.next()) {
						Object[] row = new Object[2];
						row[0] = rs.getInt("idbici");
						row[1] = rs.getString("disponibilidad");
						comboBoxidBici.addItem(rs3.getInt("idbici"));
					}
					
						
						
						Statement stmt2 = con.createStatement();
						
						ResultSet rs2 = stmt2.executeQuery("SELECT * FROM usuario");
						modelUsuario.setRowCount(0);
						
						while (rs2.next()) {
							Object[] row2 = new Object[3];
							row2[0] = rs2.getInt("idusuario");
							row2[1] = rs2.getString("nombre");
							row2[2] = rs2.getInt("bici_idbici");
							

							modelUsuario.addRow(row2);
						}
					
				
					JOptionPane.showMessageDialog(null, "Bici alquilada correctamente");
					

				} catch (SQLIntegrityConstraintViolationException error) {
					JOptionPane.showMessageDialog(null, "No pueden haber entradas duplicadas");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Hay casillas vacias", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnAlquilar.setBounds(400, 597, 160, 23);
		alquilerBici.getContentPane().add(btnAlquilar);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.setFont(new Font("Arial", Font.BOLD, 12));
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		btnDevolver.setBounds(400, 685, 160, 23);
		alquilerBici.getContentPane().add(btnDevolver);
		
		JLabel lblCrearBici = new JLabel("Crear Bici:");
		lblCrearBici.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCrearBici.setBounds(343, 322, 153, 14);
		alquilerBici.getContentPane().add(lblCrearBici);
		
		JButton btnCrearBici = new JButton("Crear Bici");
		btnCrearBici.setFont(new Font("Arial", Font.BOLD, 12));
		btnCrearBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					Connection con = ConnectionSingleton.getConnection();
					PreparedStatement ins_pstmt = con.prepareStatement("INSERT INTO bici (idbici, disponibilidad)  VALUES (?,0)");
					ins_pstmt.setInt(1, Integer.parseInt(textFieldcrearBici.getText()));
					int rowsInserted = ins_pstmt.executeUpdate();
					ins_pstmt.close();

					JOptionPane.showMessageDialog(null, "Bici creada correctamente");
					
					
					Statement stmt = con.createStatement();
					
					ResultSet rs = stmt.executeQuery("SELECT * FROM bici");
					modelBici.setRowCount(0);
					
					while (rs.next()) {
						Object[] row = new Object[2];
						row[0] = rs.getInt("idbici");
						row[1] = rs.getString("disponibilidad");
						
						comboBoxidBici.addItem(rs.getInt("idbici"));
						modelBici.addRow(row);
					}
					
					textFieldcrearBici.setText("");
					
				} catch (SQLIntegrityConstraintViolationException error) {
					JOptionPane.showMessageDialog(null, "No pueden haber entradas duplicadas");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Hay casillas vacias", "Error", JOptionPane.ERROR_MESSAGE);
				}

				
			}
		});
		btnCrearBici.setBounds(407, 400, 153, 23);
		alquilerBici.getContentPane().add(btnCrearBici);
		
		JButton btnBorrarUsuario = new JButton("Borrar Usuario");
		btnBorrarUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		btnBorrarUsuario.setBounds(74, 488, 153, 23);
		alquilerBici.getContentPane().add(btnBorrarUsuario);
		
		JLabel lblborrarUsuario = new JLabel("Borrar usuario:");
		lblborrarUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		lblborrarUsuario.setBounds(10, 432, 106, 15);
		alquilerBici.getContentPane().add(lblborrarUsuario);
		
		JComboBox comboBoxborrarUsuario = new JComboBox();
		comboBoxborrarUsuario.setBounds(141, 455, 86, 22);
		alquilerBici.getContentPane().add(comboBoxborrarUsuario);
		
	
		JButton btnborrarBici = new JButton("Borrar Bici");
		btnborrarBici.setFont(new Font("Arial", Font.BOLD, 12));
		btnborrarBici.setBounds(407, 488, 153, 23);
		alquilerBici.getContentPane().add(btnborrarBici);
		

		
		JLabel lblElegirBici = new JLabel("Elegir bici:");
		lblElegirBici.setFont(new Font("Arial", Font.BOLD, 12));
		lblElegirBici.setBounds(379, 462, 106, 15);
		alquilerBici.getContentPane().add(lblElegirBici);
		
		JComboBox comboBoxborrarBici = new JComboBox();
		comboBoxborrarBici.setBounds(483, 455, 86, 22);
		alquilerBici.getContentPane().add(comboBoxborrarBici);
		
		JLabel lblElegirUsuario = new JLabel("Elegir Usuario");
		lblElegirUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		lblElegirUsuario.setBounds(50, 463, 90, 14);
		alquilerBici.getContentPane().add(lblElegirUsuario);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 16));
		lblUsuario.setBounds(110, 70, 81, 14);
		alquilerBici.getContentPane().add(lblUsuario);
		
		JLabel lblBici = new JLabel("BICICLETA");
		lblBici.setFont(new Font("Arial", Font.BOLD, 16));
		lblBici.setBounds(437, 70, 93, 14);
		alquilerBici.getContentPane().add(lblBici);
		
		JLabel lblBorrarBici = new JLabel("Borrar bici:");
		lblBorrarBici.setFont(new Font("Arial", Font.BOLD, 12));
		lblBorrarBici.setBounds(343, 432, 106, 15);
		alquilerBici.getContentPane().add(lblBorrarBici);
		
		
		


	}
}
