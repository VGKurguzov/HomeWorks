public class Surgeon implements IDoctor {
    @Override
    public void heal() {
        System.out.println("The surgeon does the surgery...");
    }

    @Override
    public void say() {
        System.out.println("I am a surgeon!");
    }
}
