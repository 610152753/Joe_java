package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

public class SqlErrorFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton jButton0;
	private JLabel jLabel1;
	public SqlErrorFrame() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJButton0(), new Constraints(new Leading(70, 86, 30, 20), new Leading(95, 30, 20)));
		add(getJLabel1(), new Constraints(new Leading(70, 150, 12, 12), new Leading(26, 41, 10, 10)));
//		add(getJLabel2(), new Constraints(new Leading(70, 150, 12, 12), new Leading(26, 41, 10, 10)));
		setSize(320, 240);
	}
	
	
//	private JLabel getJLabel1(){
//		if (jLabel1 == null){
//			jLabel1 = new JLabel();
//		}
//		return jLabel1;
//	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Your Sql Error!");
			jLabel1.setForeground(Color.red);
		}
		return jLabel1;
	}
	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("ok");
			jButton0.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
				}
			});
		}
		return jButton0;
	}
	
//	public static void main(String[] args) {
//		SqlErrorFrame sef = new SqlErrorFrame();
//		sef.setTitle("SQL ERROR");
//		sef.setDefaultCloseOperation(SqlErrorFrame.EXIT_ON_CLOSE);
//		sef.getContentPane().setPreferredSize(null);
//		sef.pack();
//		sef.setLocationRelativeTo(null);
//		sef.setVisible(true);
//	}
		

	
	
	private void jButton0MouseMouseClicked(MouseEvent event) {
		
		this.dispose();
	}
}
