/**
 * Represents an object that can be repaired.
 */
public interface Repairable {

    /**
     * Repairs the ship or system by the specified amount.
     *
     * @param amount the repair amount to apply
     */
    void repairShip(int amount);
}
