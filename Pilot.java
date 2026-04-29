/**
 * Pilot crew member who can boost ship speed and perform navigation duties.
 */
public class Pilot extends CrewMember implements Boostable {

    private int shipSpeed;

    /**
     * Creates a new pilot.
     *
     * @param name the pilot's name
     * @param hp the pilot's health points
     * @param role the pilot's role description
     * @param shipSpeed the pilot's current ship speed
     */
    public Pilot(String name, int hp, String role, int shipSpeed) {
        super(name, hp, role);
        setShipSpeed(shipSpeed);
    }

    /**
     * Uses the pilot's special ability.
     */
    @Override
    public void useAbility() {
        System.out.println(getName() + " performs a precision maneuver at speed " + shipSpeed + ".");
    }

    /**
     * Returns a description of the pilot's role.
     *
     * @return the role description
     */
    @Override
    public String describeRole() {
        return "Pilot: " + getRole();
    }

    /**
     * Activates the pilot's boost ability.
     */
    @Override
    public void activateBoost() {
        shipSpeed += 10;
        System.out.println(getName() + " activates boost. Ship speed is now " + shipSpeed + ".");
    }

    public int getShipSpeed() {
        return shipSpeed;
    }

    public void setShipSpeed(int shipSpeed) {
        if (shipSpeed < 0) {
            throw new IllegalArgumentException("Ship speed cannot be negative");
        }
        this.shipSpeed = shipSpeed;
    }
}
