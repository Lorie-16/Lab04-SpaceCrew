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
     * @throws IllegalArgumentException if name or role are invalid or hp is negative
     */
    public CrewMember(String name, int hp, String role) {
        validateString(name, "name");
        validateString(role, "role");
        validateHp(hp);
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
        if (amount <= 0) {
            System.out.println(getName() + " cannot recharge by " + amount + " HP.");
            return;
        }

        hp += amount;
        System.out.println(getName() + " recharged " + amount + " HP.");
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
        validateString(name, "name");
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        validateHp(hp);
        this.hp = hp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        validateString(role, "role");
        this.role = role;
    }

    private static void validateHp(int hp) {
        if (hp < 0) {
            throw new IllegalArgumentException("HP cannot be negative");
        }
    }

    private static void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("" + fieldName + " cannot be empty");
        }
    }
}
