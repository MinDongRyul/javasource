package access;

public class Car {
	private int speed;
	private boolean stop;
	private Car(int speed, boolean stop) {
		super();
		this.speed = speed;
		this.stop = stop;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	// boolean 타입은 getter가 is로 만들어짐
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	
}
