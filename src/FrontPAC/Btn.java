package FrontPAC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Btn extends JButton {

	private final  String ID;
	Btn(String ID){
		super(ID);
		this.ID=ID;
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UI.setScreen(getID());
			}
		});
	}
	private String getID() {
		return this.ID;
	}
	
}
