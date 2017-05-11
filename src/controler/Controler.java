package controler;

public class Controler {
	ConnectionControler connectionControler;

	public Controler(view.Screen view){
		this.connectionControler = new ConnectionControler(view);
	}

}
