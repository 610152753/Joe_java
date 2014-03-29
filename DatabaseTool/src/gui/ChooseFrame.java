package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

//VS4E -- DO NOT REMOVE THIS LINE!
public class ChooseFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel0;
	private JButton jButton0;
	private JButton jButton1;
	private JLabel jLabel1;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public ChooseFrame() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJLabel0(), new Constraints(new Leading(105, 10, 10), new Leading(22, 10, 10)));
		add(getJLabel1(), new Constraints(new Leading(70, 208, 12, 12), new Leading(89, 10, 10)));
		add(getJButton0(), new Constraints(new Leading(59, 10, 10), new Leading(153, 10, 10)));
		add(getJButton1(), new Constraints(new Leading(185, 10, 10), new Leading(153, 27, 12, 12)));
		setSize(320, 240);
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Please choose you operation !");
		}
		return jLabel1;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("UPDATE");
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
			jButton0.setText("SELECT");
			jButton0.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
				}
			});
		}
		return jButton0;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("DATABASE TOOL");
		}
		return jLabel0;
	}

	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Main entry of the class.
	 * Note: This class is only created so that you can easily preview the result at runtime.
	 * It is not expected to be managed by the designer.
	 * You can modify it as you like.
	 */
	public static void main(String[] args) {
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ChooseFrame frame = new ChooseFrame();
				frame.setDefaultCloseOperation(ChooseFrame.EXIT_ON_CLOSE);
				frame.setTitle("Choose Option");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	private void jButton0MouseMouseClicked(MouseEvent event) {
		SelectFrame lf = new SelectFrame();
		lf.setDefaultCloseOperation(SelectFrame.EXIT_ON_CLOSE);
		lf.setTitle("SELECT");
		lf.getContentPane().setPreferredSize(lf.getSize());
		lf.pack();
		lf.setLocationRelativeTo(null);
		lf.setVisible(true);
		this.dispose();
		
		
		
		
	}

	private void jButton1MouseMouseClicked(MouseEvent event) {
		UpdateFrame uf = new UpdateFrame();
		uf.setDefaultCloseOperation(UpdateFrame.EXIT_ON_CLOSE);
		uf.setTitle("UPDATE");
		uf.getContentPane().setPreferredSize(uf.getSize());
		uf.pack();
		uf.setLocationRelativeTo(null);
		uf.setVisible(true);
		this.dispose();
		
		
	}

}
