package controler;

import view.Frame;

public class Controler {
	ConnectionControler connectionControler;
	Frame frame;

	public Controler(){
		this.frame = new Frame();
		this.connectionControler = new ConnectionControler(this.frame.getConnectionPanel());
	}

}
