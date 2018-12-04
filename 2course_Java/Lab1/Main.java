
public class Main {
    public static void main(String[] args) {
    IDoctor doctor1 = new Surgeon();
    IDoctor doctor2 = new NeuroSurgeon();
        System.out.println("Surgeon:");
        doctor1.heal();
        doctor1.say();
        System.out.println("Neurosurgeon:");
        doctor2.say();
        doctor2.heal();


    }
}

