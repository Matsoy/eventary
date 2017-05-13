package test;

import java.util.ArrayList;

import database.AssoMemberDAO;
import database.AssociationDAO;
import database.BuildingDAO;
import database.DepMemberDAO;
import database.DepartmentDAO;
import database.EventDAO;
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
		System.out.println("\t########## test de DepartmentDAO");
		System.out.println("\t########################################");
		System.out.println("\n\t##### test de findAll");
		ArrayList<Department> departments = new ArrayList<Department>();
		departments = DepartmentDAO.findAll();
		for(Department d: departments){
			System.out.println(d.toString());
		}
		System.out.println("\n\t##### test de find");
		Department dep1 = DepartmentDAO.find(1);
		System.out.println(dep1.toString());


		System.out.println("\n\t########################################");
		System.out.println("\t########## test de AssociationDAO");
		System.out.println("\t########################################");
		System.out.println("\n\t##### test de findAll");
		ArrayList<Association> associations = new ArrayList<Association>();
		associations = AssociationDAO.findAll();
		for(Association a: associations){
			System.out.println(a.toString());
		}
		System.out.println("\n\t##### test de find");
		Association association4 = AssociationDAO.find(4);
		System.out.println(association4.toString());


		System.out.println("\n\t########################################");
		System.out.println("\t########## test de AssoMemberDAO");
		System.out.println("\t########################################");
		System.out.println("\n\t##### test de find");
		ArrayList<User> assomembers2 = new ArrayList<User>();
		assomembers2 = AssoMemberDAO.find(2);
		for(User am: assomembers2){
			System.out.println(am.toString());
		}


		System.out.println("\n\t########################################");
		System.out.println("\t########## test de DepMemberDAO");
		System.out.println("\t########################################");
		System.out.println("\n\t##### test de find");
		ArrayList<User> depmembers1 = new ArrayList<User>();
		depmembers1 = DepMemberDAO.find(2);
		for(User dm: depmembers1){
			System.out.println(dm.toString());
		}


		System.out.println("\n\t########################################");
		System.out.println("\t########## test de ParticipationDAO");
		System.out.println("\t########################################");
		System.out.println("\n\t##### test de participationsInAnEvent");
		ArrayList<User> participation1 = new ArrayList<User>();
		participation1 = ParticipationDAO.participationsInAnEvent(1);
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
