// J'ai fait tous les imports pour manipuler des dates,
// mais ils ne seront peut être pas tous nécessaires
import java.util.Date;
//import java.util.Calendar;
//import java.util.TimeZone;
//import java.text.DateFormat;
//import java.text.DateFormatSymbols;

public class Event {
	int id;
	String title;
	String description;
	Date createDate;
	Date startDate;
	Date endDate;
	int duration;
	// Date modifFate;
	Date cancelDate;
	int maxNbParticipant;
	String address;
	
	public static void main(String[] args) {
	}
	
	public Event() {	//Constructeur vide
	}
	
	public void init(int id, String title, String desc, Date createDate, Date startDate, Date endDate, int duration, int maxNbParticipant, String address, Date cancelDate) {
		this.id = id;
		this.title = title;
		this.description = desc;
		this.createDate = createDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.maxNbParticipant = maxNbParticipant;
		this.address = address;
		this.cancelDate = cancelDate;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public int getMaxNbParticipant() {
		return maxNbParticipant;
	}

	public void setMaxNbParticipant(int maxNbParticipant) {
		this.maxNbParticipant = maxNbParticipant;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", description=" + description + ", createDate=" + createDate
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", duration=" + duration + ", cancelDate="
				+ cancelDate + ", maxNbParticipant=" + maxNbParticipant + ", address=" + address + "]";
	}
}
