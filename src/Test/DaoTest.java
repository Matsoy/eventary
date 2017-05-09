package Test;

import java.util.ArrayList;
import database.*;
import model.*;

/**
 * The Class DaoTest.
 */
public class DaoTest {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println("\n\t########################################");
		System.out.println("\t########## test de RoomDAO");
		System.out.println("\t########################################");
		RoomDAO dao1 = new RoomDAO();
		System.out.println("\n\t##### test de findAll");
		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms = dao1.findAll();
		for(Room r: rooms){
			System.out.println(r.toString());
		}
		System.out.println("\n\t##### test de find");
		Room room55 = dao1.find(55);
		System.out.println(room55.toString());


		System.out.println("\n\t########################################");
		System.out.println("\t########## test de BuildingDAO");
		System.out.println("\t########################################");
		BuildingDAO dao2 = new BuildingDAO();
		System.out.println("\n\t##### test de findAll");
		ArrayList<Building> buildings = new ArrayList<Building>();
		buildings = dao2.findAll();
		for(Building b: buildings){
			System.out.println(b.toString());
		}
		System.out.println("\n\t##### test de find");
		Building building2 = dao2.find(2);
		System.out.println(building2.toString());


		System.out.println("\n\t########################################");
		System.out.println("\t########## test de SiteDAO");
		System.out.println("\t########################################");
		SiteDAO dao3 = new SiteDAO();
		System.out.println("\n\t##### test de findAll");
		ArrayList<Site> sites = new ArrayList<Site>();
		sites = dao3.findAll();
		for(Site s: sites){
			System.out.println(s.toString());
		}
		System.out.println("\n\t##### test de find");
		Site site2 = dao3.find(2);
		System.out.println(site2.toString());


		System.out.println("\n\t########################################");
		System.out.println("\t########## test de SchoolDAO");
		System.out.println("\t########################################");
		SchoolDAO dao4 = new SchoolDAO();
		System.out.println("\n\t##### test de findAll");
		ArrayList<School> schools = new ArrayList<School>();
		schools = dao4.findAll();
		for(School s: schools){
			System.out.println(s.toString());
		}
		System.out.println("\n\t##### test de find");
		School school1 = dao4.find(1);
		System.out.println(school1.toString());


		System.out.println("\n\t########################################");
		System.out.println("\t########## test de UserDAO");
		System.out.println("\t########################################");
		UserDAO dao5 = new UserDAO();
		System.out.println("\n\t##### test de findAll");
		ArrayList<User> users = new ArrayList<User>();
		users = dao5.findAll();
		for(User u: users){
			System.out.println(u.toString());
		}
		System.out.println("\n\t##### test de find");
		User user2 = dao5.find("E168011W");
		System.out.println(user2.toString());
		System.out.println("\n\t##### test de connect");
		user2 = dao5.connect("E168011W", UserDAO.generateHash("petitkiwi"));
		System.out.println(user2.toString());
		
		
		System.out.println("\n\t########################################");
		System.out.println("\t########## test de EventDAO");
		System.out.println("\t########################################");
		EventDAO dao6 = new EventDAO();
		System.out.println("\n\t##### test de findAll");
		ArrayList<Event> events = new ArrayList<Event>();
		events = dao6.findAll();
		for(Event e: events){
			System.out.println(e.toString());
		}
		System.out.println("\n\t##### test de find");
		Event event1 = dao6.find(1);
		System.out.println(event1.toString());
	}
}
