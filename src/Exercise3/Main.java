package Exercise3;

import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) throws ExistException{
		Directory root = new Directory("root");
		Directory home = new Directory("home");
		Directory lp = new Directory("lp");
		File f1 = new File("f1",1234);
		File f2 = new File("f2",3445);
		File f3 = new File("f3",6688);
		File f4 = new File("f4",99999);
		root.addChild(f1);
		root.addChild(f2);
		root.addChild(home);
		home.addChild(f3);
		lp.addChild(f4);
		lp.addChild(root);

		// Prove that exercise 2.a works correctly
		Predicate<File> condition = (File f) -> f.getSize() > 5000;
		System.out.println(root.query(condition));
		System.out.println(f1.query(condition));
		System.out.println(f4.query(condition));

		System.out.println("\n ======================== \n");

		// Prove that exercise 2.b works correctly
		PredicateDecorator<File> condDecorator = new PredicateDecorator<>(condition);
		System.out.println(root.query(condDecorator));
		System.out.println(condDecorator.getCountTest());
		System.out.println(f1.query(condDecorator));
		System.out.println(condDecorator.getCountTest());
		System.out.println(f4.query(condDecorator));
		System.out.println(condDecorator.getCountTest());

		System.out.println("\n ======================== \n");

		// Prove that exercises 3.a and 3.b work correctly
		Directory hidden = new Directory("hidden");
		File f5 = new File("f5", 10000);
		hidden.addChild(f5);
		lp.addChild(hidden);
		lp.ls();
	}
}
