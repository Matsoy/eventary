package Test;

import java.util.ArrayList;

import database.*;
import model.*;

public class DaoTest {

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
	}
}
