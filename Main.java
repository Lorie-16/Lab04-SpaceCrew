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
        for (int i = 0; i < crew.size(); i++) {
            CrewMember member = crew.get(i);
            System.out.println("----------------------");
            System.out.println("Crew Member " + (i + 1));
            System.out.println("----------------------");
            System.out.println(member.describeRole());
            member.useAbility();
            member.recharge(10);

            if (member instanceof Boostable) {
                ((Boostable) member).activateBoost();
            }

            if (member instanceof Repairable) {
                ((Repairable) member).repairShip(5);
            }

            System.out.println("------------------------------");
            System.out.println();
        }
    }

    private static String getAbilityOutput(CrewMember member) {
        if (member instanceof Pilot) {
            return member.getName() + " performs a precision maneuver at speed " + ((Pilot) member).getShipSpeed() + ".";
        } else if (member instanceof Gunner) {
            Gunner gunner = (Gunner) member;
            if (gunner.getAmmo() > 0) {
                return member.getName() + " fires the " + gunner.getWeaponType() + ". Ammo left: " + (gunner.getAmmo() - 1) + ".";
            } else {
                return member.getName() + " has no ammo left to fire.";
            }
        } else if (member instanceof Engineer) {
            return member.getName() + " performs a repair with skill level " + ((Engineer) member).getRepairSkill() + ".";
        }
        return "";
    }

    private static String getSpecialOutput(CrewMember member) {
        if (member instanceof Boostable) {
            return member.getName() + " activates boost. Ship speed is now " + (((Pilot) member).getShipSpeed() + 10) + ".";
        } else if (member instanceof Repairable) {
            return member.getName() + " repairs the ship for " + (5 + ((Engineer) member).getRepairSkill()) + " points.";
        }
        return "(None)";
    }

    private static void printSummary(List<CrewMember> crew) {
        int totalHp = 0;
        int boostableCount = 0;
        int repairableCount = 0;
        Map<String, List<String>> roleMembers = new HashMap<>();
        Map<String, Integer> roleCounts = new HashMap<>();

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
            roleCounts.put(roleName, roleCounts.getOrDefault(roleName, 0) + 1);
        }

        double averageHp = crew.isEmpty() ? 0 : (double) totalHp / crew.size();

        System.out.println("--------------------");
        System.out.println(" Crew Summary");
        System.out.println("--------------------");
        System.out.println("Total crew members: " + crew.size());
        System.out.println("Total HP: " + totalHp);
        System.out.printf("Average HP per member: %.1f%n", averageHp);
        System.out.println("Boost-capable members: " + boostableCount);
        System.out.println("Repair-capable members: " + repairableCount);
        System.out.println("------------------------------");
        System.out.println();

        // Role Summary Table
        System.out.println("Role Summary:");
        System.out.println("Role       | Count");
        System.out.println("-----------|------");
        for (Map.Entry<String, Integer> entry : roleCounts.entrySet()) {
            System.out.printf("%-10s | %-5d%n", entry.getKey(), entry.getValue());
        }
        System.out.println();

        // Role Breakdown Table
        System.out.println("Role Breakdown:");
        System.out.println("Role       | Members");
        System.out.println("-----------|--------");
        for (Map.Entry<String, List<String>> entry : roleMembers.entrySet()) {
            String members = String.join(", ", entry.getValue());
            System.out.printf("%-10s | %s%n", entry.getKey(), members);
        }
    }
}
