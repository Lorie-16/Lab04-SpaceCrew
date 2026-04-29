import java.util.ArrayList;

/**
 * Main class for the Space Combat Crew System simulation.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<CrewMember> crew = new ArrayList<>();

        Pilot pilot = new Pilot("Ari", 100, "Starship Pilot", 50);
        Gunner gunner = new Gunner("Beck", 85, "Heavy Weapons Specialist", "Plasma Cannon", 5);
        Engineer engineer = new Engineer("Clara", 90, "Chief Engineer", 7);

        crew.add(pilot);
        crew.add(gunner);
        crew.add(engineer);

        int totalHp = 0;
        int pilotCount = 0;
        int gunnerCount = 0;
        int engineerCount = 0;

        for (CrewMember member : crew) {
            System.out.println("\n--- Crew Member ---");
            System.out.println(member.describeRole());
            member.useAbility();
            member.recharge(10);
            totalHp += member.getHp();

            if (member instanceof Boostable) {
                Boostable boostable = (Boostable) member;
                boostable.activateBoost();
            }

            if (member instanceof Repairable) {
                Repairable repairable = (Repairable) member;
                repairable.repairShip(5);
            }

            if (member instanceof Pilot) {
                pilotCount++;
            } else if (member instanceof Gunner) {
                gunnerCount++;
            } else if (member instanceof Engineer) {
                engineerCount++;
            }
        }

        System.out.println("\n=== Crew Summary ===");
        System.out.println("Total crew members: " + crew.size());
        System.out.println("Total HP: " + totalHp);
        System.out.println("Pilots: " + pilotCount);
        System.out.println("Gunners: " + gunnerCount);
        System.out.println("Engineers: " + engineerCount);
    }
}
