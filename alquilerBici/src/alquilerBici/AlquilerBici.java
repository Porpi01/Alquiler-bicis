
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
	private JTextField textFieldCrearUsuario;
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
		alquilerBici.setBounds(100, 100, 929, 574);
		alquilerBici.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alquilerBici.getContentPane().setLayout(null);
		
		JLabel lbltitulo = new JLabel("Byke on the go");
		lbltitulo.setForeground(new Color(153, 0, 51));
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setFont(new Font("Broadway", Font.ITALIC, 40));
		lbltitulo.setBounds(285, 0, 365, 46);
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
						JOptionPane.showMessageDialog(null, "El nombre no tiene un formato correcto");
					}
	        	}
	        	
	        	
	        });
		
		JLabel lblAlquilarBici = new JLabel("ALQUILAR BICI");
		lblAlquilarBici.setFont(new Font("Arial", Font.BOLD, 16));
		lblAlquilarBici.setBounds(704, 70, 181, 14);
		alquilerBici.getContentPane().add(lblAlquilarBici);
		
		JLabel lblidBici = new JLabel("idBici");
		lblidBici.setFont(new Font("Arial", Font.BOLD, 12));
		lblidBici.setBounds(694, 109, 84, 14);
		alquilerBici.getContentPane().add(lblidBici);
		
		JLabel lbliduUsuarioAlquilar = new JLabel("idUsuario");
		lbliduUsuarioAlquilar.setFont(new Font("Arial", Font.BOLD, 12));
		lbliduUsuarioAlquilar.setBounds(694, 134, 88, 14);
		alquilerBici.getContentPane().add(lbliduUsuarioAlquilar);
		
		JComboBox comboBoxidBiciAlquilar = new JComboBox();
		comboBoxidBiciAlquilar.setBounds(785, 101, 86, 22);
		alquilerBici.getContentPane().add(comboBoxidBiciAlquilar);
		
		JComboBox comboBoxidUsuarioAlquilar = new JComboBox();
		comboBoxidUsuarioAlquilar.setBounds(785, 126, 86, 22);
		alquilerBici.getContentPane().add(comboBoxidUsuarioAlquilar);
		
		
		JLabel lblDevolverBici = new JLabel("DEVOLVER BICI");
		lblDevolverBici.setFont(new Font("Arial", Font.BOLD, 16));
		lblDevolverBici.setBounds(704, 251, 153, 14);
		alquilerBici.getContentPane().add(lblDevolverBici);
		
		JLabel lblidUsuarioDevolver = new JLabel("idUsuario");
		lblidUsuarioDevolver.setFont(new Font("Arial", Font.BOLD, 12));
		lblidUsuarioDevolver.setBounds(694, 322, 88, 14);
		alquilerBici.getContentPane().add(lblidUsuarioDevolver);
		
		JComboBox comboBoxidBiciDevolver = new JComboBox();
		comboBoxidBiciDevolver.setBounds(785, 314, 86, 22);
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
		
	
		JLabel lblborrarUsuario = new JLabel("Borrar usuario:");
		lblborrarUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		lblborrarUsuario.setBounds(10, 432, 106, 15);
		alquilerBici.getContentPane().add(lblborrarUsuario);
		
		JComboBox comboBoxborrarUsuario = new JComboBox();
		comboBoxborrarUsuario.setBounds(141, 455, 86, 22);
		alquilerBici.getContentPane().add(comboBoxborrarUsuario);
		

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
		
		JLabel lblIdbiciDevolver = new JLabel("idBici");
		lblIdbiciDevolver.setFont(new Font("Arial", Font.BOLD, 12));
		lblIdbiciDevolver.setBounds(694, 292, 88, 14);
		alquilerBici.getContentPane().add(lblIdbiciDevolver);
		
		JComboBox comboBoxidBiciDevolver_1 = new JComboBox();
		comboBoxidBiciDevolver_1.setBounds(785, 284, 86, 22);
		alquilerBici.getContentPane().add(comboBoxidBiciDevolver_1);
		
		
		DefaultTableModel modelUsuario = new DefaultTableModel();
		modelUsuario.addColumn("Código");
		modelUsuario.addColumn("Nombre");
		modelUsuario.addColumn("Bici alquilada");
		
		
		DefaultTableModel modelBici = new DefaultTableModel();
		modelBici.addColumn("Código");
		modelBici.addColumn("Estado");
		
	
		JButton btnborrarBici = new JButton("Borrar Bici");
		btnborrarBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = ConnectionSingleton.getConnection();
					PreparedStatement dele_pstmt = con.prepareStatement("DELETE FROM bici WHERE idbici = ? ");
					dele_pstmt.setInt(1,(int) comboBoxborrarBici.getSelectedItem()); 
									 

					int rowsDeleted = dele_pstmt.executeUpdate();
					dele_pstmt.close();
					
					 Statement stmt = con.createStatement();
					    ResultSet rs = stmt.executeQuery("SELECT * FROM bici");
					    modelBici.setRowCount(0);
					    
					    comboBoxborrarBici.removeAllItems();
					    comboBoxidBiciAlquilar.removeAllItems();
					    while (rs.next()) {
					    	Object[] row = new Object[2];
							row[0] = rs.getInt("idbici");
							row[1] = rs.getString("disponibilidad");
							modelBici.addRow(row);
					       
					     comboBoxborrarBici.addItem(rs.getInt("idbici"));
					     comboBoxidBiciAlquilar.addItem(rs.getInt("idbici"));
					    
					     
					    }
					
					JOptionPane.showMessageDialog(null, "Bici eliminada correctamente");

				} catch (SQLException e3) {
					 JOptionPane.showMessageDialog(null, e3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}catch(NullPointerException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Formato del id no correcto", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnborrarBici.setFont(new Font("Arial", Font.BOLD, 12));
		btnborrarBici.setBounds(407, 488, 153, 23);
		alquilerBici.getContentPane().add(btnborrarBici);
		
		
		JButton btnMostrarBici = new JButton("Mostrar Bicis");
		btnMostrarBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					modelBici.setRowCount(0);
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM bici");


					comboBoxidBiciAlquilar.removeAllItems();
					comboBoxborrarBici.removeAllItems();
					
					while (rs.next()) {
						Object[] row = new Object[2];
						row[0] = rs.getInt("idbici");
						row[1] = rs.getString("disponibilidad");
						

						modelBici.addRow(row);
						comboBoxidBiciAlquilar.addItem(rs.getInt("idbici"));
						comboBoxborrarBici.addItem(rs.getInt("idbici"));
						

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

					comboBoxidUsuarioAlquilar.removeAllItems();
					comboBoxborrarUsuario.removeAllItems();
					
					while (rs.next()) {
						Object[] row = new Object[3];
						row[0] = rs.getInt("idusuario");
						row[1] = rs.getString("nombre");
						row[2] = rs.getInt("bici_idbici");
						modelUsuario.addRow(row);
						comboBoxidUsuarioAlquilar.addItem(rs.getInt("idusuario"));
						comboBoxborrarUsuario.addItem(rs.getInt("idusuario"));
						
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
		
	
		btnSalir.setBounds(789, 22, 89, 23);
		alquilerBici.getContentPane().add(btnSalir);
		
		textFieldCrearUsuario = new JTextField();
		textFieldCrearUsuario.setColumns(10);
		textFieldCrearUsuario.setBounds(141, 366, 86, 20);
		alquilerBici.getContentPane().add(textFieldCrearUsuario);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreUsuario =  textFieldNombre.getText();
				if(nombreUsuario.isEmpty()) {
					JOptionPane.showMessageDialog(null, "La casilla nombre está vacía");
				}else {
				
				try {

					Connection con = ConnectionSingleton.getConnection();
					PreparedStatement ins_pstmt = con.prepareStatement("INSERT INTO usuario (nombre, idusuario)  VALUES (?,?)");
					ins_pstmt.setString(1, textFieldNombre.getText());
					ins_pstmt.setInt(2, Integer.parseInt(textFieldCrearUsuario.getText()));
					int rowsInserted = ins_pstmt.executeUpdate();
					ins_pstmt.close();

					JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
					
					
					textFieldNombre.setText("");
					textFieldCrearUsuario.setText("");
					
					Statement stmt = con.createStatement();
					
					ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
					modelUsuario.setRowCount(0);
					
					comboBoxidUsuarioAlquilar.removeAllItems();
					comboBoxborrarUsuario.removeAllItems();
					while (rs.next()) {
						Object[] row = new Object[3];
						row[0] = rs.getInt("idusuario");
						row[1] = rs.getString("nombre");
						row[2] = rs.getInt("bici_idbici");
						

						modelUsuario.addRow(row);
						comboBoxidUsuarioAlquilar.addItem(rs.getInt("idusuario"));
						comboBoxborrarUsuario.addItem(rs.getInt("idusuario"));
					}
						

				} catch (SQLIntegrityConstraintViolationException error) {
					JOptionPane.showMessageDialog(null, "No pueden haber entradas duplicadas");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "El formato del id no es válido", "Error", JOptionPane.ERROR_MESSAGE);
				}

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
				    int idUsuario = (int) comboBoxidUsuarioAlquilar.getSelectedItem();
				    ResultSet rsUsuario = con.createStatement().executeQuery("SELECT bici_idbici FROM usuario WHERE idusuario = " + idUsuario);
				    
				    int idBiciAlquilar = (int) comboBoxidBiciAlquilar.getSelectedItem();
				    ResultSet rsBici = con.createStatement().executeQuery("SELECT disponibilidad FROM bici WHERE idbici = " +idBiciAlquilar);
				   
				    if(rsUsuario.next()) {
				    	 int biciId = rsUsuario.getInt("bici_idbici");
					        if (biciId != 0) {
					            JOptionPane.showMessageDialog(null, "Este usuario ya tiene una bici alquilada", "Error", JOptionPane.ERROR_MESSAGE);
					           
					        }else if(rsBici.next()) {
					        	 int disponibilidad = rsBici.getInt("disponibilidad");
							        if (disponibilidad != 0) {
							            JOptionPane.showMessageDialog(null, "Esta bici ya está alquilada", "Error", JOptionPane.ERROR_MESSAGE);
							           
							        }else {
					        	 PreparedStatement upd_pstmt = con.prepareStatement("UPDATE bici SET disponibilidad = 1 WHERE idbici = ?");
								    upd_pstmt.setInt(1, idBiciAlquilar);
								    int rowsUpdated = upd_pstmt.executeUpdate();
								    upd_pstmt.close();

								    PreparedStatement upd_pstmt2 = con.prepareStatement("UPDATE usuario SET bici_idbici = ? WHERE idusuario = ?");
								    upd_pstmt2.setInt(1,idBiciAlquilar);
								    upd_pstmt2.setInt(2, idUsuario);
								    int rowsUpdated2 = upd_pstmt2.executeUpdate();
								    upd_pstmt2.close();

								    PreparedStatement sel_pstmt = con.prepareStatement("SELECT idbici FROM bici WHERE disponibilidad = 0");
								    ResultSet rowsSelected = sel_pstmt.executeQuery();
								    sel_pstmt.close();

								    modelBici.setRowCount(0);
								    comboBoxidBiciAlquilar.removeAllItems();

								    while (rowsSelected.next()) {
								        int idBici = rowsSelected.getInt("idbici");
								        comboBoxidBiciAlquilar.addItem(idBici);
								        
								        Object[] row = new Object[2];
								        row[0] = idBici;
								        row[1] = "Disponible";
								        modelBici.addRow(row);
								    }
								    
								    ResultSet rs = con.createStatement().executeQuery("SELECT * FROM usuario");
								    modelUsuario.setRowCount(0);
								    
								    comboBoxidUsuarioAlquilar.removeAllItems();
									comboBoxborrarUsuario.removeAllItems();
								    while (rs.next()) {
								        Object[] row = new Object[3];
								        row[0] = rs.getInt("idusuario");
								        row[1] = rs.getString("nombre");
								        row[2] = rs.getInt("bici_idbici");
								        modelUsuario.addRow(row);
								        comboBoxidUsuarioAlquilar.addItem(rs.getInt("idusuario"));
										comboBoxborrarUsuario.addItem(rs.getInt("idusuario"));
								    }
								    
								    ResultSet rs2 = con.createStatement().executeQuery("SELECT * FROM bici");
								    modelBici.setRowCount(0);
									comboBoxidBiciAlquilar.removeAllItems();
									comboBoxborrarBici.removeAllItems();
									
									while (rs2.next()) {
										Object[] row = new Object[2];
										row[0] = rs2.getInt("idbici");
										row[1] = rs2.getString("disponibilidad");
										

										modelBici.addRow(row);
										comboBoxidBiciAlquilar.addItem(rs2.getInt("idbici"));
										comboBoxborrarBici.addItem(rs2.getInt("idbici"));
										

									}
									   JOptionPane.showMessageDialog(null, "Bici alquilada correctamente");
					        	
					        }
				    	
				    }
				    }

				} catch (SQLIntegrityConstraintViolationException error) {
				    JOptionPane.showMessageDialog(null, "No pueden haber entradas duplicadas");
				} catch (SQLException e) {
				    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e2) {
				    JOptionPane.showMessageDialog(null, "Formato no válido", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (NullPointerException e3) {
					 JOptionPane.showMessageDialog(null, "Hay entradas vacías", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAlquilar.setBounds(704, 170, 160, 23);
		alquilerBici.getContentPane().add(btnAlquilar);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.setFont(new Font("Arial", Font.BOLD, 12));
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				 Connection con = ConnectionSingleton.getConnection();
				    int idUsuario = (int) comboBoxidBiciDevolver_1.getSelectedItem();
				    ResultSet rsUsuario = con.createStatement().executeQuery("SELECT bici_idbici FROM usuario WHERE idusuario = " + idUsuario);
				    
				    int idBiciDevolver = (int) comboBoxidBiciDevolver_1.getSelectedItem();
				    ResultSet rsBici = con.createStatement().executeQuery("SELECT disponibilidad FROM bici WHERE idbici = " +idBiciDevolver);
				   
				    if(rsUsuario.next()) {
				    	 int biciId = rsUsuario.getInt("bici_idbici");
					        if (biciId != 0) {
					            JOptionPane.showMessageDialog(null, "Este usuario ya tiene una bici alquilada", "Error", JOptionPane.ERROR_MESSAGE);
					           
					        }else if(rsBici.next()) {
					        	 int disponibilidad = rsBici.getInt("disponibilidad");
							        if (disponibilidad != 0) {
							            JOptionPane.showMessageDialog(null, "Esta bici ya está alquilada", "Error", JOptionPane.ERROR_MESSAGE);
							           
							        }else {
					        	 PreparedStatement upd_pstmt = con.prepareStatement("UPDATE bici SET disponibilidad = 0 WHERE idbici = ?");
								    upd_pstmt.setInt(1, idBiciDevolver);
								    int rowsUpdated = upd_pstmt.executeUpdate();
								    upd_pstmt.close();

								    PreparedStatement upd_pstmt2 = con.prepareStatement("UPDATE usuario SET bici_idbici = ? WHERE idusuario = ?");
								    upd_pstmt2.setInt(1,idBiciDevolver);
								    upd_pstmt2.setInt(2, idUsuario);
								    int rowsUpdated2 = upd_pstmt2.executeUpdate();
								    upd_pstmt2.close();

								    PreparedStatement sel_pstmt = con.prepareStatement("SELECT idbici FROM bici WHERE disponibilidad = 0");
								    ResultSet rowsSelected = sel_pstmt.executeQuery();
								    sel_pstmt.close();
								    
						

								    modelBici.setRowCount(0);
								    comboBoxidBiciAlquilar.removeAllItems();

								    while (rowsSelected.next()) {
								        int idBici = rowsSelected.getInt("idbici");
								        comboBoxidBiciAlquilar.addItem(idBici);
								        
								        Object[] row = new Object[2];
								        row[0] = idBici;
								        row[1] = "Disponible";
								        modelBici.addRow(row);
								    }
								    
								    
								    
								    ResultSet rs = con.createStatement().executeQuery("SELECT * FROM usuario");
								    modelUsuario.setRowCount(0);
								    
								    comboBoxidUsuarioAlquilar.removeAllItems();
									comboBoxborrarUsuario.removeAllItems();
								    while (rs.next()) {
								        Object[] row = new Object[3];
								        row[0] = rs.getInt("idusuario");
								        row[1] = rs.getString("nombre");
								        row[2] = rs.getInt("bici_idbici");
								        modelUsuario.addRow(row);
								        comboBoxidUsuarioAlquilar.addItem(rs.getInt("idusuario"));
										comboBoxborrarUsuario.addItem(rs.getInt("idusuario"));
								    }
								    
								    ResultSet rs2 = con.createStatement().executeQuery("SELECT * FROM bici");
								    modelBici.setRowCount(0);
									comboBoxidBiciAlquilar.removeAllItems();
									comboBoxborrarBici.removeAllItems();
									
									while (rs2.next()) {
										Object[] row = new Object[2];
										row[0] = rs2.getInt("idbici");
										row[1] = rs2.getString("disponibilidad");
										

										modelBici.addRow(row);
										comboBoxidBiciAlquilar.addItem(rs2.getInt("idbici"));
										comboBoxborrarBici.addItem(rs2.getInt("idbici"));
										

									}
									   JOptionPane.showMessageDialog(null, "Bici alquilada correctamente");
					        	
					        }
				    	
				    }
				    }

				} catch (SQLIntegrityConstraintViolationException error) {
				    JOptionPane.showMessageDialog(null, "No pueden haber entradas duplicadas");
				} catch (SQLException e) {
				    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e2) {
				    JOptionPane.showMessageDialog(null, "Formato no válido", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (NullPointerException e3) {
					 JOptionPane.showMessageDialog(null, "Hay entradas vacías", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnDevolver.setBounds(704, 349, 160, 23);
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
					
					comboBoxidBiciAlquilar.removeAllItems();
					comboBoxborrarBici.removeAllItems();
					
					while (rs.next()) {
						Object[] row = new Object[2];
						row[0] = rs.getInt("idbici");
						row[1] = rs.getString("disponibilidad");
						modelBici.addRow(row);
						comboBoxidBiciAlquilar.addItem(rs.getInt("idbici"));
						comboBoxborrarBici.addItem(rs.getInt("idbici"));
					}
					
					textFieldcrearBici.setText("");
					
				} catch (SQLIntegrityConstraintViolationException error) {
					JOptionPane.showMessageDialog(null, "No pueden haber entradas duplicadas");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Formato no válido", "Error", JOptionPane.ERROR_MESSAGE);
				}

				
			}
		});
		btnCrearBici.setBounds(407, 400, 153, 23);
		alquilerBici.getContentPane().add(btnCrearBici);
		
		JButton btnBotonBorrarUsuario = new JButton("Borrar Usuario");
		btnBotonBorrarUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		btnBotonBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection con = ConnectionSingleton.getConnection();
					PreparedStatement dele_pstmt = con.prepareStatement("DELETE FROM usuario WHERE idusuario = ? ");
					dele_pstmt.setInt(1,(int) comboBoxborrarUsuario.getSelectedItem()); 
									 

					int rowsDeleted = dele_pstmt.executeUpdate();
					dele_pstmt.close();
					
					 Statement stmt = con.createStatement();
					    ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
					    modelUsuario.setRowCount(0);
					    
					    comboBoxborrarUsuario.removeAllItems();
					    comboBoxidUsuarioAlquilar.removeAllItems();
					    while (rs.next()) {
					    	Object[] row = new Object[3];
							row[0] = rs.getInt("idusuario");
							row[1] = rs.getString("nombre");
							row[2] = rs.getInt("bici_idbici");
							modelUsuario.addRow(row);
					        comboBoxborrarUsuario.addItem(rs.getInt("idusuario"));
					        comboBoxidUsuarioAlquilar.addItem(rs.getInt("idusuario"));
					    }
					
					JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");

				} catch (SQLException e3) {
					 JOptionPane.showMessageDialog(null, e3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}catch(NullPointerException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Hay entradas vacías", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		btnBotonBorrarUsuario.setBounds(74, 498, 153, 23);
		alquilerBici.getContentPane().add(btnBotonBorrarUsuario);
		
		
		
		
		
		


	}
}
