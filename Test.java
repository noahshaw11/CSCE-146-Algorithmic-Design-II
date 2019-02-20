
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TacoDB tdb = new TacoDB();
		tdb.addTaco(new Taco());
		tdb.addTaco(new Taco("FABB Special", "FABB", 1.99));
		tdb.printInfo();

	}

}
