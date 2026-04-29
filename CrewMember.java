/**
 * Abstract base class for a crew member in the space combat system.
 */
public abstract class CrewMember {

    private String name;
    private int hp;
    private String role;

    /**
     * Creates a new crew member.
     *
     * @param name the name of the crew member
     * @param hp the starting health points; must not be negative
     * @param role the role of the crew member
     * @throws IllegalArgumentException if hp is negative
     */
    public CrewMember(String name, int hp, String role) {
        if (hp < 0) {
            throw new IllegalArgumentException("HP cannot be negative");
        }
        this.name = name;
        this.hp = hp;
        this.role = role;
    }

    /**
     * Recharges the crew member by adding health points.
     *
     * @param amount the amount of HP to add
     */
    public void recharge(int amount) {
        if (amount > 0) {
            hp += amount;
            System.out.println(name + " recharged " + amount + " HP.");
        }
    }

    /**
     * Performs the crew member's special ability.
     */
    public abstract void useAbility();

    /**
     * Returns a description of the crew member's role.
     *
     * @return the role description
     */
    public abstract String describeRole();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp < 0) {
            throw new IllegalArgumentException("HP cannot be negative");
        }
        this.hp = hp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
