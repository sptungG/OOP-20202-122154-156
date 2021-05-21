package hust.soict.globalict.swing;

import java.awt.*;       // Using layouts
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class LookAndFeelDemo extends JFrame{
	public LookAndFeelDemo() {
		addDemoComponents();
		addLookAndFeelComboBox();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(380,100);
		setVisible(true);
	}
	void addDemoComponents() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Label:"));
		cp.add(new JTextField("Text Field"));
		cp.add(new JRadioButton("Radio Button"));
		cp.add(new JButton("Button"));
	}
	void addLookAndFeelComboBox() {
		Container cp = getContentPane();
		cp.add(new JLabel("Change Look and Feel Here: "));
		//create the combo box
		LookAndFeelInfo[] lafInfos = UIManager.getInstalledLookAndFeels();
		String[] lafNames = new String[lafInfos.length];
		for(int i=0; i<lafInfos.length; i++) {
			lafNames[i] = lafInfos[i].getName();
		}
		 JComboBox cbLookAndFeel = new JComboBox(lafNames);
		 cp.add(cbLookAndFeel);
		 //handle change look and feel
		 JFrame frame = this;
		 cbLookAndFeel.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent ae) {
				 int index = cbLookAndFeel.getSelectedIndex();
				 try {
					 UIManager.setLookAndFeel(lafInfos[index].getClassName());
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
				 SwingUtilities.updateComponentTreeUI(frame);
				 setTitle(lafInfos[index].getName() + " Look And Feel");
			 }
		 });
	}
	public static void main(String[] args) {
		new LookAndFeelDemo();
	}
}