package exception;

public class CheckedException {
	public static void main(String[] args) {
		// CheckedException
		try {
			Class.forName(null);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
