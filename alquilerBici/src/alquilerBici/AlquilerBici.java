
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
import javax.swing.border.LineBorder;
/**
 * Clase AlquilerBici utilizada para realizar un alquiler de una bici
 * @author Mónica Alcañiz y José Ayalá
 *@version 04-04-2023
 */
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
		alquilerBici.setBounds(100, 100, 929, 471);
		alquilerBici.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alquilerBici.getContentPane().setLayout(null);

		JLabel lbltitulo = new JLabel("Byke on the go");
		lbltitulo.setForeground(new Color(153, 0, 51));
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setFont(new Font("Broadway", Font.ITALIC, 40));
		lbltitulo.setBounds(285, 0, 365, 46);
		alquilerBici.getContentPane().add(lbltitulo);

		tableUsuario = new JTable();
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
		lblidUsuarioDevolver.setBounds(694, 292, 88, 14);
		alquilerBici.getContentPane().add(lblidUsuarioDevolver);

		JComboBox comboBoxIdUsuarioDevolver = new JComboBox();
		comboBoxIdUsuarioDevolver.setBounds(785, 288, 86, 22);
		alquilerBici.getContentPane().add(comboBoxIdUsuarioDevolver);

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

		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 16));
		lblUsuario.setBounds(110, 70, 81, 14);
		alquilerBici.getContentPane().add(lblUsuario);

		JLabel lblBici = new JLabel("BICICLETA");
		lblBici.setFont(new Font("Arial", Font.BOLD, 16));
		lblBici.setBounds(437, 70, 93, 14);
		alquilerBici.getContentPane().add(lblBici);

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

					comboBoxidBiciAlquilar.removeAllItems();

					while (rs.next()) {
						Object[] row = new Object[2];
						row[0] = rs.getInt("idbici");
						row[1] = rs.getString("disponibilidad");

						modelBici.addRow(row);
						comboBoxidBiciAlquilar.addItem(rs.getInt("idbici"));

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
		btnMostrarBici.doClick();

		JButton btnmostrarUsuario = new JButton("Mostrar Usuario");
		btnmostrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					modelUsuario.setRowCount(0);
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");

					comboBoxidUsuarioAlquilar.removeAllItems();
					comboBoxIdUsuarioDevolver.removeAllItems();

					while (rs.next()) {
						Object[] row = new Object[3];
						row[0] = rs.getInt("idusuario");
						row[1] = rs.getString("nombre");
						row[2] = rs.getInt("bici_idbici");
						modelUsuario.addRow(row);
						comboBoxidUsuarioAlquilar.addItem(rs.getInt("idusuario"));
						comboBoxIdUsuarioDevolver.addItem(rs.getInt("idusuario"));
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
		btnmostrarUsuario.doClick();

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
				String nombreUsuario = textFieldNombre.getText();
				if (nombreUsuario.isEmpty()) {
					JOptionPane.showMessageDialog(null, "La casilla nombre está vacía");
				} else {

					try {

						Connection con = ConnectionSingleton.getConnection();
						PreparedStatement ins_pstmt = con
								.prepareStatement("INSERT INTO usuario (nombre, idusuario)  VALUES (?,?)");
						ins_pstmt.setString(1, textFieldNombre.getText());
						ins_pstmt.setInt(2, Integer.parseInt(textFieldCrearUsuario.getText()));
						int rowsInserted = ins_pstmt.executeUpdate();
						ins_pstmt.close();
						btnmostrarUsuario.doClick();
						JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
						textFieldNombre.setText("");
						textFieldCrearUsuario.setText("");

					} catch (SQLIntegrityConstraintViolationException error) {
						JOptionPane.showMessageDialog(null, "No pueden haber entradas duplicadas");
						textFieldNombre.setText("");
						textFieldCrearUsuario.setText("");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "El formato del id no es válido", "Error",
								JOptionPane.ERROR_MESSAGE);
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

					PreparedStatement foreign = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
					foreign.executeUpdate();

					PreparedStatement updtBici = con
							.prepareStatement("UPDATE bici SET disponibilidad = 1 WHERE idbici = ?;");
					updtBici.setInt(1, (int) comboBoxidBiciAlquilar.getSelectedItem());
					updtBici.executeUpdate();
					updtBici.close();

					PreparedStatement updtUsuario = con
							.prepareStatement("UPDATE usuario SET bici_idbici = ? WHERE idusuario = ?");
					updtUsuario.setInt(1, (int) comboBoxidBiciAlquilar.getSelectedItem());
					updtUsuario.setInt(2, (int) comboBoxidUsuarioAlquilar.getSelectedItem());
					updtUsuario.executeUpdate();
					updtUsuario.close();

					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
					modelUsuario.setRowCount(0);
					comboBoxidBiciAlquilar.removeAllItems();
					comboBoxidUsuarioAlquilar.removeAllItems();
					while (rs.next()) {
						Object[] row = new Object[3];
						row[0] = rs.getInt("idusuario");
						row[1] = rs.getString("nombre");
						row[2] = rs.getInt("bici_idbici");
						modelUsuario.addRow(row);

					}

					// Actualizacion de bicis

					modelBici.setRowCount(0);
					Statement stmt3 = con.createStatement();
					ResultSet rs3 = stmt3.executeQuery("SELECT * FROM bici");

					while (rs3.next()) {
						Object[] row = new Object[2];
						row[0] = rs3.getInt("idbici");
						row[1] = rs3.getString("disponibilidad");
						modelBici.addRow(row);

					}

					JOptionPane.showMessageDialog(null, "Bici alquilada correctamente");

				} catch (SQLIntegrityConstraintViolationException error) {
					JOptionPane.showMessageDialog(null, "No pueden haber entradas duplicadas");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Formato no válido", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NullPointerException e3) {
					JOptionPane.showMessageDialog(null, "Hay entradas vacías", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAlquilar.setBounds(704, 170, 160, 23);
		alquilerBici.getContentPane().add(btnAlquilar);

		comboBoxidBiciAlquilar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt4 = con.createStatement();
					ResultSet rs4 = stmt4.executeQuery("SELECT idbici FROM bici WHERE disponibilidad = 0");
					comboBoxidBiciAlquilar.removeAllItems();
					while (rs4.next()) {
						comboBoxidBiciAlquilar.addItem(rs4.getInt("idbici"));
					}
				} catch (SQLException e1) {

				}
			}
		});

		comboBoxidUsuarioAlquilar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt2 = con.createStatement();

					ResultSet rs2 = stmt2.executeQuery("SELECT idusuario FROM usuario WHERE bici_idbici IS NULL");
					comboBoxidUsuarioAlquilar.removeAllItems();
					while (rs2.next()) {
						comboBoxidUsuarioAlquilar.addItem(rs2.getInt("idusuario"));
					}
				} catch (SQLException e1) {

				}
			}
		});

		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.setFont(new Font("Arial", Font.BOLD, 12));
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = ConnectionSingleton.getConnection();

					PreparedStatement foreign = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
					foreign.executeUpdate();

					PreparedStatement dele_pstmt2 = con.prepareStatement(
							"UPDATE bici SET disponibilidad = 0 WHERE idbici = (SELECT bici_idbici FROM usuario WHERE idusuario = ?);");
					dele_pstmt2.setInt(1, (int) comboBoxIdUsuarioDevolver.getSelectedItem());

					dele_pstmt2.executeUpdate();
					dele_pstmt2.close();

					PreparedStatement dele_pstmt = con
							.prepareStatement("UPDATE usuario SET bici_idbici = NULL WHERE idusuario = ?");
					dele_pstmt.setInt(1, (int) comboBoxIdUsuarioDevolver.getSelectedItem());
					dele_pstmt.executeUpdate();
					dele_pstmt.close();

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

					// Actualizacion de bicis

					modelBici.setRowCount(0);
					Statement stmt3 = con.createStatement();
					ResultSet rs3 = stmt3.executeQuery("SELECT * FROM bici");

					comboBoxIdUsuarioDevolver.removeAllItems();

					while (rs3.next()) {
						Object[] row = new Object[2];
						row[0] = rs3.getInt("idbici");
						row[1] = rs3.getString("disponibilidad");
						modelBici.addRow(row);

					}

					JOptionPane.showMessageDialog(null, "Bici devuelta correctamente");

				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Formato no válido", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NullPointerException e3) {
					JOptionPane.showMessageDialog(null, "Hay entradas vacías", "Error", JOptionPane.ERROR_MESSAGE);
				}

				// btnMostrarBici.doClick();
//				btnmostrarUsuario.doClick();

			}
		});
		btnDevolver.setBounds(711, 322, 160, 23);
		alquilerBici.getContentPane().add(btnDevolver);

		comboBoxIdUsuarioDevolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt2 = con.createStatement();

					ResultSet rs2 = stmt2.executeQuery("SELECT idusuario FROM usuario WHERE bici_idbici != 0");
					comboBoxIdUsuarioDevolver.removeAllItems();
					while (rs2.next()) {
						comboBoxIdUsuarioDevolver.addItem(rs2.getInt("idusuario"));
					}

				} catch (SQLException e1) {

				}
			}
		});

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
					PreparedStatement ins_pstmt = con
							.prepareStatement("INSERT INTO bici (idbici, disponibilidad)  VALUES (?,0)");
					ins_pstmt.setInt(1, Integer.parseInt(textFieldcrearBici.getText()));
					int rowsInserted = ins_pstmt.executeUpdate();
					ins_pstmt.close();
					JOptionPane.showMessageDialog(null, "Bici creada correctamente");
					textFieldcrearBici.setText("");

				} catch (SQLIntegrityConstraintViolationException error) {
					textFieldcrearBici.setText("");
					JOptionPane.showMessageDialog(null, "No pueden haber entradas duplicadas");

				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Formato no válido", "Error", JOptionPane.ERROR_MESSAGE);
				}
				btnMostrarBici.doClick();
			}
		});
		btnCrearBici.setBounds(407, 400, 153, 23);
		alquilerBici.getContentPane().add(btnCrearBici);

	}
}
