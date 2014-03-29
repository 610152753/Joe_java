package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import editData.UpdateData;

//VS4E -- DO NOT REMOVE THIS LINE!
public class UpdateFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JTextField jTextField0;
	private JButton jButton0;
	private JButton jButton1;
//	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public UpdateFrame() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJLabel0(), new Constraints(new Leading(81, 10, 10), new Leading(39, 10, 10)));
		add(getJLabel1(), new Constraints(new Leading(40, 10, 10), new Leading(84, 10, 10)));
		add(getJTextField0(), new Constraints(new Leading(76, 201, 10, 10), new Leading(82, 12, 12)));
		add(getJButton0(), new Constraints(new Leading(109, 10, 10), new Leading(169, 10, 10)));
		add(getJButton1(), new Constraints(new Leading(211, 78, 10, 10), new Leading(169, 12, 12)));
		setSize(320, 240);
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

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("UPDATE");
			jButton0.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
				}
			});
		}
		return jButton0;
	}

	private JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField();
			
		}
		return jTextField0;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("SQL:");
		}
		return jLabel1;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("UPDATE OPERATION");
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
//				UpdateFrame frame = new UpdateFrame();
//				frame.setDefaultCloseOperation(UpdateFrame.EXIT_ON_CLOSE);
//				frame.setTitle("UpdateFrame");
//				frame.getContentPane().setPreferredSize(frame.getSize());
//				frame.pack();
//				frame.setLocationRelativeTo(null);
//				frame.setVisible(true);
//			}
//		});
//	}

	private void jButton1MouseMouseClicked(MouseEvent event) {
		ChooseFrame cf = new ChooseFrame();
		cf.setDefaultCloseOperation(ChooseFrame.EXIT_ON_CLOSE);
		cf.setTitle("ChooseOpration");
		cf.getContentPane().setPreferredSize(cf.getSize());
		cf.pack();
		cf.setLocationRelativeTo(null);
		cf.setVisible(true);
		this.dispose();
		
	}

	private void jButton0MouseMouseClicked(MouseEvent event) {
		String sql = jTextField0.getText();
		
		if(sql == null || "".equals(sql)){
			jLabel1.setForeground(Color.red);
		}else{
			jLabel1.setForeground(Color.black);
			
			
		}
		
		if (";".equals(sql.substring(sql.length()-1,sql.length()))){
			System.out.println("substring");
			sql = sql.substring(0, sql.length()-1);
			
		}
		
		UpdateData.upData(sql);
		
	}

}
