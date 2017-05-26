package view;

import javax.swing.JComboBox;

public class EventaryComboBox<E> extends JComboBox<E>{

	private static final long serialVersionUID = 1L;
		
	public EventaryComboBox() {
		super();
		this.setBackground(Frame.colorEventary);
	}
}
