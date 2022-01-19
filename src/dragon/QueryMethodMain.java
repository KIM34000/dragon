package dragon;


public class QueryMethodMain {

	public static void main(String[] args) {
		ConnectionDB.openConnection();
		QueryMethod.readAll();
		QueryMethod.create();
		QueryMethod.deleteByNamePrepared();
		QueryMethod.update();
	}

}
