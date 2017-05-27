package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Organization;

// TODO: Auto-generated Javadoc
/**
 * The Class OrgaItemPanel.
 */
public class OrgaItemPanel extends JPanel{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event. */
	Organization organisation;

	/** The frame. */
	Frame frame;


	/**
	 * Instantiates a new event item panel.
	 *
	 * @param frame the frame
	 * @param orga the orga
	 */
	public OrgaItemPanel(Frame frame, Organization orga){
		super();
		this.frame = frame;
		this.organisation = orga;
		this.setMaximumSize(new Dimension(800,60));
		this.setLayout(new FlowLayout());

		String orgaName = orga.getName();
		JLabel name = new JLabel(orgaName);
		if (orgaName.length()<=45){
			name.setFont(new Font("Impact", Font.PLAIN, 40));
		} else {
			name.setFont(new Font("Impact", Font.PLAIN, 30));
		}
		this.add(name);
	}

	/**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
	public Frame getFrame() {
		return frame;
	}

	/**
	 * Gets the organisation.
	 *
	 * @return the organisation
	 */
	public Organization getOrganisation() {
		return organisation;
	}
}
