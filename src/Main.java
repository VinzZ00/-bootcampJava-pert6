import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Main implements ActionListener {

	private final int hgap = 0, vgap = 0;
	JFrame f = new JFrame();
	
	public Main() {
		// TODO Auto-generated constructor stub
		// output di console, CLI
		System.out.println("hello world");
		
		// Output menjadi sebuah Frame, GUI (Graphical User Interface)
		
		
		// default layout manager adalah BorderLayout.
		
		/*
		 *  frame : JFrame
		 *  panel : JPanel
		 *  label : JLabel
		 *  text Field : JTextField
		 *  text Area : JTextArea
		 *  Optionpane : JOptionPane
		 *  table : JTable
		 *  ScrollPane : JScrollPane
		 *  tab pane : JtabbedPane
		 *  Radio button : JRadioButton
		 *  button Group (wajib di pake di radio button) : ButtonGroup
		 *  Check Box : JCheckBox
		 *  ComboBox : JComboBox
		 *  PasswordField : JPasswordField
		 *  etc
		 */
		// 1
//		addComponentBorderLayout();
		// 2
//		addComponentGridLayout();
		// 3
//		latihanGridLayout();
		
		f.setSize(500,500);
		f.setEnabled(true);
		f.setVisible(true);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setTitle("Main Frame");
		f.setResizable(true);
		f.setLocationRelativeTo(null);
		
	}
	
	public void addComponentGridLayout() {
		f.setLayout(new GridLayout(3,2,10,10));
		
		for (int i = 0; i < 6; i++) {
			f.add(new JButton("Button ke " + (i+1)));
		}
	}
	
	public void latihanGridLayout() {
		
		
		f.setLayout(new GridLayout(3,1));
		JPanel[] panels = new JPanel[3];
		
		
		;
		
		for (int i = 1; i < panels.length; i++) {
			panels[i] = new JPanel();
		}
		panels[0] = initpanel1(hgap, vgap);
		for (int i = 0; i < panels.length; i++) {
			panels[i].setBackground(Color.cyan.darker());
		}
		
		panels[1].setBorder(new EmptyBorder(0,10,0,10));
		panels[2].setBorder(new EmptyBorder(0,10,10,10));
		
		
		f.add(panels[0]);
		
		panels[1].setLayout(new GridLayout(1,3));
		JPanel p = new JPanel();
		p.setBackground(Color.cyan.darker());
		panels[1].add(new JLabel("Horizontal Gap"));
		panels[1].add(new JLabel("Vertical Gap"));
		panels[1].add(p);
		f.add(panels[1]);
		
		panels[2].setLayout(new GridLayout(1,3));
		
		Integer[] comboBoxText = {0,1,2,3,4,5,6,7,8,9,10};
		
		JComboBox<Integer> horizontal = new JComboBox<>(comboBoxText);
		
		panels[2].add(horizontal);
		
		JSpinner verticalSpinner = new JSpinner(new SpinnerNumberModel(0, 0, null, 1)); 
		
		panels[2].add(verticalSpinner);
		
		JButton submitButton = new JButton("Apply gaps");
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int hgap = (int) horizontal.getSelectedItem();
				int vgap = (int) verticalSpinner.getValue();

				f.remove(panels[0]);
				
				panels[0] = initpanel1(hgap, vgap);
				f.add(panels[0],0);
				
				f.repaint();
				f.revalidate();
			}
		});
		
		panels[2].add(submitButton);
		
		f.add(panels[2]);
		
		
		
	}
	
	public void addComponentBorderLayout() {
		
		// Border Layout
		f.setLayout(new BorderLayout());
				f.add(new JButton("North"), BorderLayout.NORTH);
				

				// panel center
				JPanel centerPane = new JPanel();
				centerPane.setBackground(Color.CYAN.darker());
				JButton but = new JButton("center");
	
				centerPane.add(but);	
				
				f.add(centerPane, BorderLayout.CENTER);
				
				f.add(new JButton("South"), BorderLayout.SOUTH);
				
				
	}
	
	public JPanel initpanel1(int hgap, int vgap) {
		JPanel panel = new JPanel(new GridLayout(3,2, hgap, vgap));
		panel.setBorder(new EmptyBorder(10,10,0,10));
		panel.setBackground(Color.cyan.darker());
		JButton[] but = new JButton[3];
		
		for (int i = 0; i < but.length; i++) {
			but[i] = new JButton("Button " + i);
		}
		
		for (JButton jButton : but) {
			panel.add(jButton);
		}
		
		JButton button4 = new JButton("Long-named button 4");
		panel.add(button4);
		
		JButton button5 = new JButton("5");
		panel.add(button5);
		
		return panel;
	}
	
	public static void main(String[] args) {
		
		new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
