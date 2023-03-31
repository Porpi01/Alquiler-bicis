
//José Ayala y Mónica Alcañiz

package alquilerBici;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
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
		alquilerBici.setBounds(100, 100, 743, 705);
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
		lblcrearUsuario.setBounds(363, 155, 153, 14);
		alquilerBici.getContentPane().add(lblcrearUsuario);
		
		JLabel lblnombreUsuario = new JLabel("Nombre");
		lblnombreUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		lblnombreUsuario.setBounds(401, 190, 81, 14);
		alquilerBici.getContentPane().add(lblnombreUsuario);
		
		
		JLabel lblidUsuario = new JLabel("idUsuario");
		lblidUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		lblidUsuario.setBounds(401, 215, 115, 14);
		alquilerBici.getContentPane().add(lblidUsuario);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(507, 184, 86, 20);
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
		lblAlquilarBici.setBounds(363, 348, 84, 14);
		alquilerBici.getContentPane().add(lblAlquilarBici);
		
		JLabel lblidBici = new JLabel("idBici");
		lblidBici.setFont(new Font("Arial", Font.BOLD, 12));
		lblidBici.setBounds(401, 382, 46, 14);
		alquilerBici.getContentPane().add(lblidBici);
		
		JLabel lblidUsuarioBici = new JLabel("idUsuario");
		lblidUsuarioBici.setFont(new Font("Arial", Font.BOLD, 12));
		lblidUsuarioBici.setBounds(401, 407, 88, 14);
		alquilerBici.getContentPane().add(lblidUsuarioBici);
		
		JComboBox comboBoxidBici = new JComboBox();
		comboBoxidBici.setBounds(507, 374, 86, 22);
		alquilerBici.getContentPane().add(comboBoxidBici);
		
		JComboBox comboBoxidUsuarioBici = new JComboBox();
		comboBoxidUsuarioBici.setBounds(507, 399, 86, 22);
		alquilerBici.getContentPane().add(comboBoxidUsuarioBici);
		
		
		JLabel lblDevolverBici = new JLabel("Devolver Bici");
		lblDevolverBici.setFont(new Font("Arial", Font.BOLD, 12));
		lblDevolverBici.setBounds(363, 470, 153, 14);
		alquilerBici.getContentPane().add(lblDevolverBici);
		
		JLabel lblidUsuarioDevolver = new JLabel("idUsuario");
		lblidUsuarioDevolver.setFont(new Font("Arial", Font.BOLD, 12));
		lblidUsuarioDevolver.setBounds(401, 503, 88, 14);
		alquilerBici.getContentPane().add(lblidUsuarioDevolver);
		
		JComboBox comboBoxidBiciDevolver = new JComboBox();
		comboBoxidBiciDevolver.setBounds(507, 495, 86, 22);
		alquilerBici.getContentPane().add(comboBoxidBiciDevolver);
		
		JScrollPane scrollPaneUsuario = new JScrollPane(tableUsuario);
		scrollPaneUsuario.setBounds(10, 180, 281, 117);
		alquilerBici.getContentPane().add(scrollPaneUsuario);
		
		JScrollPane scrollPaneBici = new JScrollPane(tableBici);
		scrollPaneBici.setBounds(10, 337, 281, 117);
		alquilerBici.getContentPane().add(scrollPaneBici);
		
		JLabel lblIdbicicrear = new JLabel("idBiciCrear");
		lblIdbicicrear.setFont(new Font("Dialog", Font.BOLD, 12));
		lblIdbicicrear.setBounds(401, 299, 115, 14);
		alquilerBici.getContentPane().add(lblIdbicicrear);
		
		textFieldcrearBici = new JTextField();
		textFieldcrearBici.setColumns(10);
		textFieldcrearBici.setBounds(507, 293, 86, 20);
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
		
		
		btnMostrarBici.setBounds(74, 303, 153, 23);
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
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(507, 209, 86, 20);
		alquilerBici.getContentPane().add(textFieldUsuario);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
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
		btnCrearUsuario.setBounds(507, 144, 160, 23);
		alquilerBici.getContentPane().add(btnCrearUsuario);
		
		JButton btnAlquilar = new JButton("Alquilar");
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
		btnAlquilar.setBounds(509, 337, 160, 23);
		alquilerBici.getContentPane().add(btnAlquilar);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		btnDevolver.setBounds(507, 459, 160, 23);
		alquilerBici.getContentPane().add(btnDevolver);
		
		JLabel lblCrearBici = new JLabel("Crear Bici");
		lblCrearBici.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCrearBici.setBounds(363, 262, 153, 14);
		alquilerBici.getContentPane().add(lblCrearBici);
		
		JButton btnCrearBici = new JButton("Crear Bici");
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
		btnCrearBici.setBounds(507, 253, 160, 23);
		alquilerBici.getContentPane().add(btnCrearBici);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(74, 461, 153, 23);
		alquilerBici.getContentPane().add(btnBorrar);
		
		JLabel lblelegirProducto = new JLabel("Elegir producto:");
		lblelegirProducto.setBounds(31, 565, 160, 15);
		alquilerBici.getContentPane().add(lblelegirProducto);
		
		
		


	}
}
