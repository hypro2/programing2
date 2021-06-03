package card;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Button extends JButton implements ActionListener {
	private Frame view;
	private Blackjack model;
	
	/** CountButton - ��ư ��Ʈ�ѷ� 
	 * @param label - ��ư�� �ٴ� �� 
	 * @param m - ������ �� 
	 * @param v - ������ �� */
	public Button(String label, Blackjack m, Frame v) {
		super(label);
		view = v;
		model = m;
		addActionListener(this);
	}
	
	/** actionPerformed - '��ư ������' �׼� �̺�Ʈ�� ó�� 
	 * @param e - �̺�Ʈ */
	//������ ������ ��ư���� �ؾߵ�...
	public void actionPerformed(ActionEvent e) {
		view.update();
	}

}

