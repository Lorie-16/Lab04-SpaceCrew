/**
 * Engineer crew member who can repair ships and systems.
 */
public class Engineer extends CrewMember implements Repairable {

    private int repairSkill;

    /**
     * Creates a new engineer.
     *
     * @param name the engineer's name
     * @param hp the engineer's health points
     * @param role the engineer's role description
     * @param repairSkill the engineer's repair skill level
     */
    public Engineer(String name, int hp, String role, int repairSkill) {
        super(name, hp, role);
        this.repairSkill = repairSkill;
    }

    /**
     * Uses the engineer's special ability.
     */
    @Override
    public void useAbility() {
        System.out.println(getName() + " performs a repair with skill level " + repairSkill + ".");
    }

    /**
     * Returns a description of the engineer's role.
     *
     * @return the role description
     */
    @Override
    public String describeRole() {
        return "Engineer: " + getRole();
    }

    /**
     * Repairs the ship by the specified amount.
     *
     * @param amount the amount of repair to apply
     */
    @Override
    public void repairShip(int amount) {
        int totalRepair = amount + repairSkill;
        System.out.println(getName() + " repairs the ship for " + totalRepair + " points.");
    }

    public int getRepairSkill() {
        return repairSkill;
    }

    public void setRepairSkill(int repairSkill) {
        this.repairSkill = repairSkill;
    }
}
