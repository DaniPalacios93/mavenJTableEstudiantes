package jTableEstudiantes.views;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.filechooser.FileFilter;

import jTableEstudiantes.Princial;
import jTableEstudiantes.controller.ControladorEstiduante;
import jTableEstudiantes.entities.Estudiante;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelEstudiante extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private byte[] imagenGuardada;
	private JLabel titulo;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	private JTextField jtfTipologiaSexo;
	private JTextField jtfColor;
	private JScrollPane jscrollImg;
	private JColorChooser jColorChooser;
	private JPopupMenu popup;
	private JButton btnSave;
	
	

	/**
	 * Create the panel.
	 */
	public PanelEstudiante() {
		setLayout(new BorderLayout(0, 0));
		
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		titulo = new JLabel("");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_jlbTitulo = new GridBagConstraints();
		gbc_jlbTitulo.gridwidth = 2;
		gbc_jlbTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_jlbTitulo.gridx = 0;
		gbc_jlbTitulo.gridy = 0;
		panel.add(titulo, gbc_jlbTitulo);
		
		JLabel lblNewLabel_1 = new JLabel("id:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		jtfId.setEditable(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		popup = getPopUpMenu();
		
		jscrollImg = new JScrollPane();
		jscrollImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showPopup(e);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				showPopup(e);
			}
			
			  /**
             * M�todo llamado cuando se detecta el evento de rat�n, mostrar� el men�
             * @param e
             */
            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(),
                            e.getX(), e.getY());
                }
            }
		});
		GridBagConstraints gbc_jscrollImg = new GridBagConstraints();
		gbc_jscrollImg.gridheight = 4;
		gbc_jscrollImg.insets = new Insets(0, 0, 5, 0);
		gbc_jscrollImg.fill = GridBagConstraints.BOTH;
		gbc_jscrollImg.gridx = 2;
		gbc_jscrollImg.gridy = 1;
		panel.add(jscrollImg, gbc_jscrollImg);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido 1:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfApellido1 = new JTextField();
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 3;
		panel.add(jtfApellido1, gbc_jtfApellido1);
		jtfApellido1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Apellido 2:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfApellido2 = new JTextField();
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 4;
		panel.add(jtfApellido2, gbc_jtfApellido2);
		jtfApellido2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 5;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		
		//BTN CAMBIAR IMAGEN
		JButton btnCambiarImagen = new JButton("Cambiar imagen");
		btnCambiarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();
			}
		});
		
		jtfTipologiaSexo = new JTextField();
		GridBagConstraints gbc_jtfTipologiaSexo = new GridBagConstraints();
		gbc_jtfTipologiaSexo.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTipologiaSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTipologiaSexo.gridx = 1;
		gbc_jtfTipologiaSexo.gridy = 5;
		panel.add(jtfTipologiaSexo, gbc_jtfTipologiaSexo);
		jtfTipologiaSexo.setColumns(10);
		GridBagConstraints gbc_btnCambiarImagen = new GridBagConstraints();
		gbc_btnCambiarImagen.anchor = GridBagConstraints.NORTH;
		gbc_btnCambiarImagen.insets = new Insets(0, 0, 5, 0);
		gbc_btnCambiarImagen.gridx = 2;
		gbc_btnCambiarImagen.gridy = 5;
		panel.add(btnCambiarImagen, gbc_btnCambiarImagen);
		
		JLabel lblNewLabel_5 = new JLabel("Dni:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 6;
		panel.add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Direccion:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 7;
		panel.add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 8;
		panel.add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Telefono:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 9;
		panel.add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Color preferido:");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 10;
		panel.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		jtfColor = new JTextField();
		jtfColor.setEditable(false);
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 5, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 10;
		panel.add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);
		
		JButton btnSelectColor = new JButton("Cambiar color");
		btnSelectColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaColor();
			}
		});
		GridBagConstraints gbc_btnSelectColor = new GridBagConstraints();
		gbc_btnSelectColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelectColor.gridx = 2;
		gbc_btnSelectColor.gridy = 10;
		panel.add(btnSelectColor, gbc_btnSelectColor);
		
		btnSave = new JButton("Guardar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateEntry();
				
				
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 12;
		panel.add(btnSave, gbc_btnSave);
		
	}
	
	/**
	 * 
	 * @return
	 */
	private JPopupMenu getPopUpMenu () {
		JPopupMenu menu = new JPopupMenu();
		JMenuItem infoDimenciones = new JMenuItem(cargaInfoDimensiones());
		JMenuItem cambiarImagen = new JMenuItem("cambiarImagen");
		
		cambiarImagen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();
			}
		});
		
		menu.add(infoDimenciones);
		menu.addSeparator();
		menu.add(cambiarImagen);
		
		return menu;
	}
	
	/**
	 * 
	 * @return
	 */
	private String cargaInfoDimensiones() {
		
		if (imagenGuardada != null && imagenGuardada.length > 0) {
			ImageIcon icono = new ImageIcon(imagenGuardada);
			return "Dimensiones: " + icono.getIconWidth() + " x " + icono.getIconHeight();
			
		}else {
			return "sin imagen";
		}
	}

	/**
	 * 
	 */
	private void seleccionaImagen () {
		JFileChooser jfileChooser = new JFileChooser();
		
		// Configurando el componente
		
		// Tipo de selección que se hace en el diálogo
		jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Sólo selecciona ficheros

		// Filtro del tipo de ficheros que puede abrir
		jfileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png *.gif";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() &&
						(f.getAbsolutePath().toLowerCase().endsWith(".jpg") || 
								f.getAbsolutePath().toLowerCase().endsWith(".jpeg")|| 
								f.getAbsolutePath().toLowerCase().endsWith(".png")|| 
								f.getAbsolutePath().toLowerCase().endsWith(".gif")))) 
					return true;
				return false;
			}
		});
		
		// Abro el diálogo para la elección del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);
		
		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = jfileChooser.getSelectedFile();
			
			if (fichero.isFile()) {
				try {
					this.imagenGuardada = Files.readAllBytes(fichero.toPath());
					setImagen(imagenGuardada);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 
	 * @param icon
	 * @return
	 */
	private boolean isImagenValida(ImageIcon icon) {
		
		if(icon.getIconHeight() > 100 || icon.getIconWidth() > 100) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 */
	private void seleccionaColor () {
		Color color = jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		
		// Si el usuario pulsa sobre aceptar, el color elegido no será nulo
		if (color != null) {
			String strColor = "#"+Integer.toHexString(color.getRGB()).substring(2);
			this.jtfColor.setText(strColor);
			this.panel.setBackground(color);
		}
	}
	
	
	/**
	 * 
	 * @param o
	 */
	public void muestraEnPantalla(Estudiante o) {
		
		if(o != null) {
			this.setJtfId(o.getId());
			this.setJtfNombre(o.getNombre());
			this.setJtfApellido1(o.getApellido1());
			this.setJtfApellido2(o.getApellido2());
			this.setJtfDni(o.getDni());
			this.setJtfDireccion(o.getDireccion());
			this.setJtfEmail(o.getEmail());
			this.setJtfTelefono(o.getTelefono());
			this.setJtfTipologiaSexo(o.getIdTipologiaSexo());
			this.setImagen(o.getImagen());
			this.setColor(o.getColorFavorito());
		}
	}
	
	/**
	 * 
	 */
	private void updateEntry() {
		
		Estudiante estudiante = new Estudiante();
		
		estudiante.setId(getJtfId());
		estudiante.setNombre(getJtfNombre());
		estudiante.setApellido1(getJtfApellido1());
		estudiante.setApellido2(getJtfApellido2());
		estudiante.setDni(getJtfDni());
		estudiante.setDireccion(getJtfDireccion());
		estudiante.setEmail(getJtfEmail());
		estudiante.setTelefono(getJtfTelefono());
		estudiante.setIdTipologiaSexo(getJtfTipologiaSexo());
		estudiante.setImagen(getImagen());
		estudiante.setColorFavorito(getColor());
		
		ControladorEstiduante.getInstance().updateEstudiante(estudiante);
	}
	
	
	
	
	
	///GETTERS & SETTERS
	
	public int getJtfTipologiaSexo() {
		return Integer.parseInt(this.jtfTipologiaSexo.getText());
	}
	
	public void setJtfTipologiaSexo(int tipologiaSexo) {
		this.jtfTipologiaSexo.setText("" + tipologiaSexo);;
	}
	
	public int getJtfId() {
		return Integer.parseInt(this.jtfId.getText());
	}
	
	public void setJtfId(int id) {
		this.jtfId.setText("" + id);
	}
	
	public String getJtfNombre() {
		return this.jtfNombre.getText();
	}
	
	public void setJtfNombre(String nombre) {
		this.jtfNombre.setText(nombre);
	}
	
	public String getJtfApellido1() {
		return this.jtfApellido1.getText();
	}
	
	public void setJtfApellido1(String apellido1) {
		this.jtfApellido1.setText(apellido1);
	}
	
	public String getJtfApellido2() {
		return this.jtfApellido2.getText();
	}
	
	public void setJtfApellido2(String apellido2) {
		this.jtfApellido2.setText(apellido2);
	}
	
	public String getJtfDni() {
		return this.jtfDni.getText();
	}
	
	public void setJtfDni(String dni) {
		this.jtfDni.setText(dni);
	}
	
	public String getJtfDireccion() {
		return this.jtfDireccion.getText();
	}
	
	public void setJtfDireccion(String direccion) {
		this.jtfDireccion.setText(direccion);
	}
	
	public String getJtfEmail() {
		return this.jtfEmail.getText();
	}
	
	public void setJtfEmail(String email) {
		this.jtfEmail.setText(email);
	}
	
	public String getJtfTelefono() {
		return this.jtfTelefono.getText();
	}
	
	public void setJtfTelefono(String tlf) {
		this.jtfTelefono.setText(tlf);
	}
	
	public void setColor(String color) {
		this.jtfColor.setText(color);
		if(color == null || color.equals("null")) {
			this.panel.setBackground(null);
		}
		else {
			this.panel.setBackground(Color.decode(color));
		}
	}

	public String getColor() {
		return jtfColor.getText();
	}
	
	public byte[] getImagen() {
		return imagenGuardada;
	}
	
	public void setImagen(byte[] img) {
		
		imagenGuardada = img;
		popup = getPopUpMenu();
		
		if (imagenGuardada != null && imagenGuardada.length > 0) {
			ImageIcon icono = new ImageIcon(imagenGuardada);
			if(!isImagenValida(icono)) {
				JOptionPane.showMessageDialog(null, "La imagen es demasiado grande, max 100x100");
				return;
			}
			JLabel lblIcono = new JLabel(icono);
			jscrollImg.setViewportView(lblIcono);
		}
		else {
			JLabel lblIcono = new JLabel("Sin imagen");
			jscrollImg.setViewportView(lblIcono);
			imagenGuardada = null;
		}
	}
}
