package Exercise2;

public class StateDemo {

    public static void main(String[] args) {

        PackageDecorator pkg = new PackageDecorator(new Package());
        PackageDecorator pkg2 = new PackageDecorator(new Package());

        pkg.attach(new ObserverImpl());
        pkg2.attach(new ObserverImpl());

        pkg.printStatus();
        pkg.nextState(); // Ordered -> Delievered
        pkg.printStatus();
        pkg.nextState(); // Delievered -> Recieved
        pkg.printStatus();
        
        System.out.println("\n ========== \n");

        pkg2.setState(new DeliveredState());
        pkg2.printStatus();
        pkg2.nextState(); // Delievered -> Recieved
        pkg2.printStatus();
    }
}
