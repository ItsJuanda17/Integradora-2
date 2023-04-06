package model;

/**
 * Represents a manager with a name and cellphone number.
 */
public class Manager {
    private String managerName;
    private String managerCellPhone;

    /**
     * Constructs a Manager object with the given name and cellphone number.
     *
     * @param managerName the name of the manager
     * @param managerCellPhone the cellphone number of the manager
     */
    public Manager(String managerName, String managerCellPhone) {
        this.managerName = managerName;
        this.managerCellPhone = managerCellPhone;
    }

    /**
     * Returns the name of the manager.
     *
     * @return the name of the manager
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * Sets the name of the manager.
     *
     * @param managerName the new name of the manager
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    /**
     * Returns the cellphone number of the manager.
     *
     * @return the cellphone number of the manager
     */
    public String getManagerCellphone() {
        return managerCellPhone;
    }

    /**
     * Sets the cellphone number of the manager.
     *
     * @param managerCellPhone the new cellphone number of the manager
     */
    public void setManagerCellphone(String managerCellPhone) {
        this.managerCellPhone = managerCellPhone;
    }
}
