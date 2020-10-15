
public class piece {
	int x;
	char y;
	boolean king;
	String display;
	public piece(char a, int b, String c) {
		y = a;
		x = b;
		display = c;
	}
	public void setX(int a) {
		x = a;
	}
	public void setY(char a) {
		y = a;
	}
	public void setDisplay(String a) {
		display = a;
	}
	public int getX() {
		return x;
	}
	public char getY() {
		return y;
	}
	public boolean getKing() {
		return king;
	}
	public String displaypiece() {
		return display;
	}
	public int getPosition() {
		int a = 0;
		if(y == 'A') {
			a += 0;
		}
		if(y =='B') {
			a += 7;
		}
		if(y == 'C') {
			a += 15;
		}
		if(y == 'D') {
			a += 23;
		}
		if(y == 'E') {
			a += 31;
		}
		if(y == 'F') {
			a += 39;
		}
		if(y == 'G') {
			a += 47;
		}
		if(y == 'H') {
			a += 55;
		}
		a += x;
		return a;
	}
}
