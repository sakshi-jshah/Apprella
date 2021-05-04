import java.util.Iterator;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class CommentSection {
	public static void main(String args[]) {

		JFrame frame = new JFrame("Comments");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);

		JMenuBar menuB = new JMenuBar();
		JMenu menuB1 = new JMenu("Go back");
		JMenu menuB2 = new JMenu("Help");
		menuB.add(menuB1);
		menuB.add(menuB2);
		JMenuItem menuB11 = new JMenuItem("Yes");
		JMenuItem menuB22 = new JMenuItem("Open");
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

		Vector<String> store = new Vector<String>();
		send.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!textF.getText().isEmpty()) {
					store.add(textF.getText());
				}
				textA.selectAll();
				textA.replaceSelection("");
				Iterator<String> value = store.iterator();
				while (value.hasNext()) {
					textA.append(value.next() + "\n");
				}
				textF.setText("");}});
		reset.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (store.size() > 0) {
					store.remove(store.size() - 1);
				}
				textA.selectAll();
				textA.replaceSelection("");
				Iterator<String> value = store.iterator();
				while (value.hasNext()) {
					textA.append(value.next() + "\n");}}});

		frame.getContentPane().add(BorderLayout.SOUTH, panel);
		frame.getContentPane().add(BorderLayout.NORTH, menuB);
		frame.getContentPane().add(BorderLayout.CENTER, textA);
		frame.setVisible(true);
	}
}
