package verger;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

public class Excel_to_table_verger extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//			UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//			//org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//		} catch (Exception e) {
//
//		}
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Excel_to_table frame = new Excel_to_table();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Excel_to_table_verger() throws IOException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, 985, 747);
		//setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		DefaultTableModel m = new DefaultTableModel();
		/*--------------------------------------------------------------------------*/
		File excelFile = new File("C:\\Users\\Chalhoub\\Desktop\\All_Seasons.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new  XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIt = sheet.iterator();
		int i = 0, j;
		
		String[] line = new String[7];
		while(rowIt.hasNext()) {
			Row row = rowIt.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			j=0;
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				//if(cell.toString().length() != 0)
				if(i>0 && j==3) {
					line[j] = cell.toString();
					line[j] += " $";
					j++;
				}
				else
				line[j++] = cell.toString();
			}
			if(i == 0) {
				m.setColumnIdentifiers(line);
			}
			else {
				m.addRow(line);
			}
			i++;
		}
	
		workbook.close();
		fis.close();
		contentPane.setLayout(new BorderLayout(0, 0));
		table = new JTable(m);
		table.setShowGrid(true);
		/*UIManager.put("Table.background", Color.RED);
		UIManager.put("Table.alternateRowColor", Color.PINK);*/
		table.setFont(new Font("serif", Font.PLAIN, 15));
		table.setRowHeight(30);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(150);
		columnModel.getColumn(3).setPreferredWidth(50);
		columnModel.getColumn(4).setPreferredWidth(100);
		columnModel.getColumn(5).setPreferredWidth(80);
		columnModel.getColumn(6).setPreferredWidth(150);
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
		
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane,BorderLayout.CENTER);
		
		btnAdd = new JButton("ADD");
		contentPane.add(btnAdd, BorderLayout.SOUTH);
		
		
	}
	
}
