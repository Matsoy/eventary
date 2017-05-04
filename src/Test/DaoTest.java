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
		System.out.println("\n\t########## test de RoomDAO");
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
		
		
		System.out.println("\n\t########## test de BuildingDAO");
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
		
		
		System.out.println("\n\t########## test de SiteDAO");
		SiteDAO dao3 = new SiteDAO();
		System.out.println("\n\t##### test de findAll");
		ArrayList<Site> sites = new ArrayList<Site>();
		sites = dao3.findAll();
		for(Site s: sites){
			System.out.println(s.toString());
		}
		System.out.println("\n\t##### test de find");
		Site site3 = dao3.find(3);
		System.out.println(site3.toString());
		
		
		System.out.println("\n\t########## test de SchoolDAO");
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
	}
}
