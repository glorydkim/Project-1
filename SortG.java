/* Glory Kim
 * UMUC CMSC 350 Project 3
 * Files: BST.java, Fraction.java, SortG.java
 */

import java.awt.event.*;

import javax.swing.*;

public class SortG implements ActionListener {

	private JButton ev;
	private JLabel msg, r;


	private JTextField result, input;
	private JRadioButton r1, r2, r3, r4;

	private JFrame frame;

	public SortG() {

		frame = new JFrame();

		ev = new JButton("Perform Sort");

		result = new JTextField();
		input = new JTextField();
		msg = new JLabel("Original List");
		r = new JLabel ("Sorted List");
		result.setEditable(false);


		msg.setBounds(20, 10, 160, 30);
		input.setBounds(110, 10, 250, 30);
		result.setBounds(110, 50, 250, 30);
		r.setBounds(20, 50, 70, 30);
		ev.setBounds(180, 90, 200, 30);

		ButtonGroup group1 = new ButtonGroup();
		ButtonGroup group2 = new ButtonGroup();
		r1 = new JRadioButton("Ascending",true);
		r2 = new JRadioButton("Descending");
		r3 = new JRadioButton("Integer",true);
		r4 = new JRadioButton("Fraction");
		group1.add(r1);
		group1.add(r2);
		group2.add(r3);
		group2.add(r4);

		r1.setBounds(20, 130, 130, 30);
		r2.setBounds(20, 160, 130, 30);
		r3.setBounds(250, 130, 130, 30);
		r4.setBounds(250, 160, 130, 30);

		

		frame.add(result);
		frame.add(r);
		frame.add(input);
		frame.add(msg);
		frame.add(ev);
		frame.add(r1);
		frame.add(r2);
		frame.add(r3);
		frame.add(r4);

		frame.setSize(500, 240);
		frame.setLayout(null);
		frame.setVisible(true);

		ev.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {

		String action = ae.getActionCommand();

		if (action.equals("Perform Sort")){

			String exp = input.getText();
			try
			{
				BST b = new BST();
				String s[] = exp.split(" ");
				if (r3.isSelected())
				{
					for (int i=0; i<s.length; i++)
					{
						b.insert(Integer.parseInt(s[i]));
					}
				}
				else
				{
					for (int i=0; i<s.length; i++)
					{
						Fraction f = new Fraction(s[i]);
						b.insert(f);
					}
				}
				String res = b.inOrderTraversal()+"";
				if (r2.isSelected())
					{
						if (r4.isSelected())
						{
							String n = "";
							String ns[] = res.split(" ");
							for (int i=ns.length-1; i>=0; i--)
							{
								n+=ns[i]+" ";
							}
							res=n;

						}
						else
						{
							res = new StringBuffer(res).reverse().toString();
						}
					}
				result.setText(res);
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(null,"Non-numeric Input");
				result.setText("");
			}
		}
			
	}

	public static void main(String args[]) {

		new SortG();
	}
}











