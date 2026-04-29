import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main class for the Space Combat Crew System simulation.
 */
public class Main {

    public static void main(String[] args) {
        List<CrewMember> crew = new ArrayList<>();

        crew.add(new Pilot("Ari", 100, "Starship Pilot", 50));
        crew.add(new Gunner("Beck", 85, "Heavy Weapons Specialist", "Plasma Cannon", 5));
        crew.add(new Engineer("Clara", 90, "Chief Engineer", 7));

        printTitle();
        processCrewMembers(crew);
        printSummary(crew);
    }

    private static void printTitle() {
        System.out.println("=== Space Combat Crew System ===");
        System.out.println("Preparing crew for mission...\n");
    }

    private static void processCrewMembers(List<CrewMember> crew) {
        int index = 1;

        for (CrewMember member : crew) {
            System.out.println("--- Crew Member " + index + " ---");
            System.out.println(member.describeRole());
            member.useAbility();
            member.recharge(10);

            if (member instanceof Boostable) {
                ((Boostable) member).activateBoost();
            }

            if (member instanceof Repairable) {
                ((Repairable) member).repairShip(5);
            }

            index++;
            System.out.println();
        }
    }

    private static void printSummary(List<CrewMember> crew) {
        int totalHp = 0;
        int boostableCount = 0;
        int repairableCount = 0;
        Map<String, List<String>> roleMembers = new HashMap<>();

        for (CrewMember member : crew) {
            totalHp += member.getHp();
            if (member instanceof Boostable) {
                boostableCount++;
            }
            if (member instanceof Repairable) {
                repairableCount++;
            }

            String roleName = member.getClass().getSimpleName();
            roleMembers.computeIfAbsent(roleName, key -> new ArrayList<>()).add(member.getName());
        }

        double averageHp = crew.isEmpty() ? 0 : (double) totalHp / crew.size();

        System.out.println("=== Crew Summary ===");
        System.out.println("Total crew members: " + crew.size());
        System.out.println("Total HP: " + totalHp);
        System.out.printf("Average HP per member: %.1f%n", averageHp);
        System.out.println("Boost-capable members: " + boostableCount);
        System.out.println("Repair-capable members: " + repairableCount);
        System.out.println();
        System.out.println("Role breakdown:");

        for (Map.Entry<String, List<String>> entry : roleMembers.entrySet()) {
            String role = entry.getKey();
            List<String> names = entry.getValue();
            System.out.println("- " + role + " (" + names.size() + "): " + String.join(", ", names));
        }
    }
}
