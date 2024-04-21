package jTableEstudiantes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import jTableEstudiantes.controller.ControladorEstiduante;
import jTableEstudiantes.views.DatosTablaEstudiante;
import jTableEstudiantes.views.PanelEstudiante;

import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSplitPane;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Princial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelEstudiante panel;
	
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel dtm = null;
	private Object datosEnTabla[][] = DatosTablaEstudiante.getDatosDeTabla();
	private String titulosEnTabla[] = DatosTablaEstudiante.getTitulosColumnas();
	
	private int indiceFilaSel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Princial frame = new Princial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Princial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setResizeWeight(0.4);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		contentPane.add(splitPane, gbc_splitPane);
		
		panel = new PanelEstudiante();
		splitPane.setRightComponent(panel);
		
		this.dtm = getDefaultTableModelNoEditable();
		table = new JTable(dtm);
		scrollPane = new JScrollPane(table);
		
		splitPane.setLeftComponent(scrollPane);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				muestraEstudianteSeleccionado();
			}
		});
	
	}
	
	/**
	 * 
	 */
	private void muestraEstudianteSeleccionado() {
		
		indiceFilaSel = table.getSelectedRow();
		int idFilaSel = (Integer) table.getValueAt(indiceFilaSel, 0);
		panel.muestraEnPantalla(ControladorEstiduante.getInstance().findById(idFilaSel));
	}
	
	/**
	 * 
	 * @return
	 */
	private DefaultTableModel getDefaultTableModelNoEditable () {
		DefaultTableModel dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {
			
			/**
			 * Sobreescribimos el metodo para evitar la edicion del campo "Id"
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 0) {
					return false;
				}
				return true;
			}		
		};
		return dtm;
	}

	
	/**
	 * 
	 */
	public void actualizarTabla() {
		dtm = getDefaultTableModelNoEditable();
		table = new JTable(dtm);
	}
	
	

}
