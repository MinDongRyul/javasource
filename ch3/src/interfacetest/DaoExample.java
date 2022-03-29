package interfacetest;

public class DaoExample {
	public static void dbWork(DataAccessObject dao) { // DataAccessObject : 인터페이스 명
		dao.select(); // 추상메소드
		dao.insert();
		dao.update();
		dao.delete();
	}

	public static void main(String[] args) {
		dbWork(new OracleDao()); // DataAccessObject dao = new OracleDao(); // OracleDao : 클래스명 
		dbWork(new MysqlDao());  // DataAccessObject dao = new MysqlDao(); 
	}

}
