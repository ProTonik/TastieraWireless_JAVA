package Server;

public class DirectionS {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getDir() {
		return dir;
	}

	public void setDir(boolean dir) {
		this.dir = dir;
	}

	public String toString() {
		return this.name + "," + this.dir;
	}

	private String name;
	private boolean dir;

	public DirectionS(String name, boolean dir) {
		this.name = name;
		this.dir = dir;
	}

}
