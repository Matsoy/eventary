package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.SwingUtilities;

import database.SchoolDAO;
import model.Association;
import model.Context;
import model.Department;
import model.Event;
import model.Organization;
import model.Room;
import model.School;
import model.User;
import view.CreateEventPanel;
import view.Frame;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionCreateEventForm.
 * Cette action va permettre la vérification des différents
 * champs du formulaire de la création d'un événement.
 * Lorsque que l'utilisateur clic sur le bouton lié à cette action,
 * il y a vérification des champs, et appel aux méthodes du model
 * en conséquence, ainsi qu'une mise à jour de la vue.
 */
public class ActionCreateEventForm extends AbstractAction{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The view. */
	CreateEventPanel view;

	/** The model. */
	Context model;

	/**
	 * Instantiates a new action create event form.
	 *
	 * @param model the model
	 * @param view the view
	 */
	ActionCreateEventForm(Context model, CreateEventPanel view){
		this.view = view;
		this.model = model;
		this.putValue(Action.NAME, "Valider");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		try {

			// parser String -> java.util.Date
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

			// titre
			String eventName = this.view.getTitreField().getText().replaceAll("\"","'");

			// desc
			String description = this.view.getDescField().getText().replaceAll("\"","'");

			// date de debut
			String startDate = this.view.getDateDebutField().getText()+":00";


			Date parsedStartDate = formatter.parse(startDate);

			// date de fin
			String endDate = this.view.getDateFinField().getText()+":00";
			Date parsedEndDate = formatter.parse(endDate);

			// nb de participants max
			int maxParticipant = Integer.parseInt(this.view.getNbParticipantsField().getText());

			//lieu
			String PlaceType = this.getSelectedButtonText(this.view.getLieuGroup());
			Room room = null;
			String address = "";
			if (PlaceType.equals("Dans une école")) { // si dans une ecole
				room = this.view.getRooms().get((this.view.getRoomBox().getSelectedIndex())-1);
			}
			else { // si à une adresse extérieure
				address = this.view.getLieuField().getText().replaceAll("\"","'");
			}

			// organisateur
			Organization organization = null; // id orga si event au nom de l'orga
			User organizer = this.model.getCurrentUser();
			String OrganizerType = this.getSelectedButtonText(this.view.getOrganisateurGroup());
			if(OrganizerType.equals("Une association")){ // si une asso
				organization = this.view.getAssos().get((this.view.getAssoBox().getSelectedIndex())-1);
			}
			else if(OrganizerType.contains("département")) { // si un dpt
				organization = this.view.getDpts().get(0);
			}				

			if(Event.createEvent(eventName, description, parsedStartDate, parsedEndDate, maxParticipant, organizer, organization, room, address)){
				this.view.getFrame().getHomePanel().setContainerCentral(this.view.getFrame().getCreateEventPanel());
				this.view.getFrame().getCreateEventPanel().displayForm((ArrayList<Association>)model.getCurrentUser().getListeAsso(), (ArrayList<Department>)model.getCurrentUser().getListeDpt(), (ArrayList<School>)SchoolDAO.findAll());
				this.view.getFrame().displayMessage("Evénement créé avec succès",new Color(135, 233, 144));
				SwingUtilities.updateComponentTreeUI(this.view.getFrame());
			}
			else{
				this.view.getFrame().displayMessage("Erreur dans le formulaire", Frame.colorEventaryError);
			}

		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			this.view.getFrame().displayMessage("Erreur dans le formulaire", Frame.colorEventaryError);
		}
	}

	/**
	 * Gets the selected button text.
	 *
	 * @param buttonGroup the button group
	 * @return the selected button text
	 */
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}





}
