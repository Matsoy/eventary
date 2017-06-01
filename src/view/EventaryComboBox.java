package view;

import javax.swing.JComboBox;

// TODO: Auto-generated Javadoc
/**
 * The Class EventaryComboBox.
 * 
 * JComboBox personnalisée pour l'application
 *
 * @param <E> the element type
 */
public class EventaryComboBox<E> extends JComboBox<E>{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
		
	/**
	 * Instantiates a new eventary combo box.
	 */
	public EventaryComboBox() {
		super();
		this.setBackground(Frame.colorEventary);
	}
}
