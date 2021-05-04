import javax.swing.*;
import java.awt.*;

class CommentSection {
	public static void main(String args[]) {

		JFrame frame = new JFrame("Comments");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);

		JMenuBar menuB = new JMenuBar();
		JMenu menuB1 = new JMenu("FILE");
		JMenu menuB2 = new JMenu("Help");
		menuB.add(menuB1);
		menuB.add(menuB2);
		JMenuItem menuB11 = new JMenuItem("Open");
		JMenuItem menuB22 = new JMenuItem("Save as");
		menuB1.add(menuB11);
		menuB2.add(menuB22);

		JPanel panel = new JPanel();
		JLabel label = new JLabel("Leave Comment");
		JTextField textF = new JTextField(10);
		JButton send = new JButton("Send");
		JButton reset = new JButton("Delete");
		panel.add(label);
		panel.add(textF);
		panel.add(send);
		panel.add(reset);

		JTextArea textA = new JTextArea();

		frame.getContentPane().add(BorderLayout.SOUTH, panel);
		frame.getContentPane().add(BorderLayout.NORTH, menuB);
		frame.getContentPane().add(BorderLayout.CENTER, textA);
		frame.setVisible(true);
	}
}
