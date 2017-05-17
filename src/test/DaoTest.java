package test;

import java.util.ArrayList;

import database.BuildingDAO;
import database.EventDAO;
import database.OrgaMemberDAO;
import database.OrganizationDAO;
import database.ParticipationDAO;
import database.RoomDAO;
import database.SchoolDAO;
import database.SiteDAO;
import database.UserDAO;
import database.WaitingDAO;
import model.Association;
import model.Building;
import model.Department;
import model.Event;
import model.Room;
import model.School;
import model.Site;
import model.User;

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
		System.out.println("\n\t##### test de findAll");
		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms = RoomDAO.findAll();
		for(Room r: rooms){
			System.out.println(r.toString());
		}
		System.out.println("\n\t##### test de find");
		Room room55 = RoomDAO.find(55);
		System.out.println(room55.toString());


		System.out.println("\n\t########################################");
		System.out.println("\t########## test de BuildingDAO");
		System.out.println("\t########################################");
		System.out.println("\n\t##### test de findAll");
		ArrayList<Building> buildings = new ArrayList<Building>();
		buildings = BuildingDAO.findAll();
		for(Building b: buildings){
			System.out.println(b.toString());
		}
		System.out.println("\n\t##### test de find");
		Building building2 = BuildingDAO.find(2);
		System.out.println(building2.toString());


		System.out.println("\n\t########################################");
		System.out.println("\t########## test de SiteDAO");
		System.out.println("\t########################################");
		System.out.println("\n\t##### test de findAll");
		ArrayList<Site> sites = new ArrayList<Site>();
		sites = SiteDAO.findAll();
		for(Site s: sites){
			System.out.println(s.toString());
		}
		System.out.println("\n\t##### test de find");
		Site site2 = SiteDAO.find(2);
		System.out.println(site2.toString());


		System.out.println("\n\t########################################");
		System.out.println("\t########## test de SchoolDAO");
		System.out.println("\t########################################");
		System.out.println("\n\t##### test de findAll");
		ArrayList<School> schools = new ArrayList<School>();
		schools = SchoolDAO.findAll();
		for(School s: schools){
			System.out.println(s.toString());
		}
		System.out.println("\n\t##### test de find");
		School school1 = SchoolDAO.find(1);
		System.out.println(school1.toString());


		System.out.println("\n\t########################################");
		System.out.println("\t########## test de UserDAO");
		System.out.println("\t########################################");
		System.out.println("\n\t##### test de findAll");
		ArrayList<User> users = new ArrayList<User>();
		users = UserDAO.findAll();
		for(User u: users){
			System.out.println(u.toString());
		}
		System.out.println("\n\t##### test de find");
		User user2 = UserDAO.find("E168011W");
		System.out.println(user2.toString());
		System.out.println("\n\t##### test de connect");
		user2 = UserDAO.connect("E168011W", UserDAO.generateHash("petitkiwi"));
		System.out.println(user2.toString());


		System.out.println("\n\t########################################");
		System.out.println("\t########## test de EventDAO");
		System.out.println("\t########################################");
		System.out.println("\n\t##### test de findAll");
		ArrayList<Event> events = new ArrayList<Event>();
		events = EventDAO.findAll();
		for(Event e: events){
			System.out.println(e.toString());
		}
		System.out.println("\n\t##### test de find");
		Event event1 = EventDAO.find(1);
		System.out.println(event1.toString());


		System.out.println("\n\t########################################");
		System.out.println("\t########## test de OrganizationDAO");
		System.out.println("\t########################################");
		System.out.println("\n\t##### test de findAllAsso");
		ArrayList<Association> associations = new ArrayList<Association>();
		associations = OrganizationDAO.findAllAsso();
		for(Association a: associations){
			System.out.println(a.toString());
		}
		System.out.println("\n\t##### test de findAllDpt");
		ArrayList<Department> departments = new ArrayList<Department>();
		departments = OrganizationDAO.findAllDpt();
		for(Department d: departments){
			System.out.println(d.toString());
		}
		System.out.println("\n\t##### test de assoInWhichUserIsMember");
		ArrayList<Association> associations2 = new ArrayList<Association>();
		associations2 = OrganizationDAO.assoInWhichUserIsMember("E168011W");
		for(Association a: associations2){
			System.out.println(a.toString());
		}
		System.out.println("\n\t##### test de dptInWhichUserIsMember");
		ArrayList<Department> departments2 = new ArrayList<Department>();
		departments2 = OrganizationDAO.dptInWhichUserIsMember("E168011W");
		for(Department d: departments2){
			System.out.println(d.toString());
		}


		System.out.println("\n\t########################################");
		System.out.println("\t########## test de OrgaMemberDAO");
		System.out.println("\t########################################");
		System.out.println("\n\t##### test de find");
		ArrayList<User> orga2 = new ArrayList<User>();
		orga2 = OrgaMemberDAO.find(2);
		for(User am: orga2){
			System.out.println(am.toString());
		}


		System.out.println("\n\t########################################");
		System.out.println("\t########## test de ParticipationDAO");
		System.out.println("\t########################################");
		System.out.println("\n\t##### test de eventParticipants");
		ArrayList<User> participation1 = new ArrayList<User>();
		participation1 = ParticipationDAO.eventParticipants(1);
		for(User p: participation1){
			System.out.println(p.toString());
		}
		
		
		System.out.println("\n\t########################################");
		System.out.println("\t########## test de WaitingDAO");
		System.out.println("\t########################################");
		System.out.println("\n\t##### test de WaitingsForAnEvent");
		ArrayList<User> waitings1 = new ArrayList<User>();
		waitings1 = WaitingDAO.waitingsForAnEvent(1);
		for(User w: waitings1){
			System.out.println(w.toString());
		}



	}
}
