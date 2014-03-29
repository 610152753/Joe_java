package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import editData.ProcessData;

//VS4E -- DO NOT REMOVE THIS LINE!
public class SelectFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel0;
	private JTextField jTextField0;
	private JLabel jLabel1;
	private JComboBox jComboBox0;
	private JLabel jLabel2;
	private JButton jButton0;
	private JLabel jLabel3;
	private JTextField jTextField1;
	private JButton jButton1;
	private JLabel jLabel4;
	private JComboBox jComboBox1;
//	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public SelectFrame() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJLabel0(), new Constraints(new Leading(26, 10, 10), new Leading(55, 12, 12)));
		add(getJLabel2(), new Constraints(new Leading(115, 10, 10), new Leading(17, 12, 12)));
		add(getJButton0(), new Constraints(new Leading(66, 81, 10, 10), new Leading(232, 10, 10)));
		add(getJButton1(), new Constraints(new Leading(188, 75, 10, 10), new Leading(232, 12, 12)));
		add(getJLabel3(), new Constraints(new Leading(26, 63, 10, 10), new Leading(189, 12, 12)));
		add(getJLabel1(), new Constraints(new Leading(26, 12, 12), new Leading(102, 10, 10)));
		add(getJComboBox0(), new Constraints(new Leading(105, 10, 10), new Leading(100, 10, 10)));
		add(getJLabel4(), new Constraints(new Leading(26, 99, 12, 12), new Leading(143, 12, 12)));
		add(getJComboBox1(), new Constraints(new Leading(131, 10, 10), new Leading(139, 12, 12)));
		add(getJTextField0(), new Constraints(new Leading(52, 261, 10, 10), new Leading(53, 24, 10, 10)));
		add(getJTextField1(), new Constraints(new Leading(103, 179, 12, 12), new Leading(187, 25, 10, 10)));
		setSize(343, 274);
	}

	private JComboBox getJComboBox1() {
		if (jComboBox1 == null) {
			jComboBox1 = new JComboBox();
			jComboBox1.setModel(new DefaultComboBoxModel(new Object[] { "GB2312", "UTF-8","ASCII" }));
			jComboBox1.setDoubleBuffered(false);
			jComboBox1.setBorder(null);
		}
		return jComboBox1;
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Characterset:");
		}
		return jLabel4;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("BACK");
			jButton1.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton1MouseMouseClicked(event);
				}
			});
		}
		return jButton1;
	}

	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			
		}
		return jTextField1;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("CsvName:");
		}
		return jLabel3;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("SELECT");
			jButton0.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
				}
			});
		}
		return jButton0;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("CREATE CSV");
		}
		return jLabel2;
	}

	private JComboBox getJComboBox0() {
		if (jComboBox0 == null) {
			jComboBox0 = new JComboBox();
			jComboBox0.setModel(new DefaultComboBoxModel(new Object[] { ",", ";", "space", "tab" }));
			jComboBox0.setDoubleBuffered(false);
			jComboBox0.setBorder(null);
		}
		return jComboBox0;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("seporator:");
		}
		return jLabel1;
	}

	private JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField();
			
		}
		return jTextField0;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("sql:");
		}
		return jLabel0;
	}

//	private static void installLnF() {
//		try {
//			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
//			UIManager.setLookAndFeel(lnfClassname);
//		} catch (Exception e) {
//			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
//					+ " on this platform:" + e.getMessage());
//		}
//	}

	/**
	 * Main entry of the class.
	 * Note: This class is only created so that you can easily preview the result at runtime.
	 * It is not expected to be managed by the designer.
	 * You can modify it as you like.
	 */
//	public static void main(String[] args) {
//		installLnF();
//		SwingUtilities.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				SelectFrame frame = new SelectFrame();
//				frame.setDefaultCloseOperation(SelectFrame.EXIT_ON_CLOSE);
//				frame.setTitle("LogFrame");
//				frame.getContentPane().setPreferredSize(frame.getSize());
//				frame.pack();
//				frame.setLocationRelativeTo(null);
//				frame.setVisible(true);
//			}
//		});
//	}

	

	private void jButton1MouseMouseClicked(MouseEvent event) {
		ChooseFrame cf = new ChooseFrame();
	
		cf.setTitle("ChooseOpration");
		cf.getContentPane().setPreferredSize(cf.getSize());
		cf.pack();
		cf.setLocationRelativeTo(null);
		cf.setVisible(true);
		this.dispose();
	}

	private void jButton0MouseMouseClicked(MouseEvent event) {
		
		String sql = jTextField0.getText();
		String seporator = (String) jComboBox0.getSelectedItem();
		String csvName = jTextField1.getText();
		String character = (String) jComboBox1.getSelectedItem();
		
		if (sql == null || "".equals(sql)) {
			jLabel0.setForeground(Color.red);
		} else {
			jLabel0.setForeground(Color.black);
		}

		if (csvName == null || "".equals(csvName)) {
			jLabel3.setForeground(Color.red);
		} else {
			jLabel3.setForeground(Color.black);
		}
		
		if (";".equals(sql.substring(sql.length()-1,sql.length()))){
			System.out.println("substring");
			sql = sql.substring(0, sql.length()-1);
			
		}
		
		if(!"".equals(sql) & !"".equals(csvName)){
		 
			
			if (seporator == "space")
			{	
				seporator = " ";
			}else if (seporator == "tab"){
				seporator = "\t";
			}
			
			ProcessData.sqlQuery(csvName,character,seporator,sql);
		}
		
		System.out.println(sql+seporator+csvName+character);
		
	}

}
