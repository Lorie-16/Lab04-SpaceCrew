/**
 * Gunner crew member who manages weapon fire during combat.
 */
public class Gunner extends CrewMember {

    private String weaponType;
    private int ammo;

    /**
     * Creates a new gunner.
     *
     * @param name the gunner's name
     * @param hp the gunner's health points
     * @param role the gunner's role description
     * @param weaponType the type of weapon carried
     * @param ammo the starting ammunition count
     */
    public Gunner(String name, int hp, String role, String weaponType, int ammo) {
        super(name, hp, role);
        this.weaponType = weaponType;
        this.ammo = ammo;
    }

    /**
     * Uses the gunner's ability to fire the weapon.
     */
    @Override
    public void useAbility() {
        if (ammo <= 0) {
            System.out.println(getName() + " has no ammo left to fire.");
            return;
        }
        ammo--;
        System.out.println(getName() + " fires the " + weaponType + ". Ammo left: " + ammo + ".");
    }

    /**
     * Returns a description of the gunner's role.
     *
     * @return the role description
     */
    @Override
    public String describeRole() {
        return "Gunner: " + getRole();
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
}
