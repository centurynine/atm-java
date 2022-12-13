public class Manager extends Person{
    
    private String managerId;
    private String managerPassword;
    private boolean haveManager;

    public void setManager(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerId() {
        return managerId;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setHaveManager(Boolean haveManager) {
        this.haveManager = haveManager;
    }

    public boolean getHaveManager() {
        return haveManager;
    }

    public void setAccount(String id, String pin) {
        this.managerId = id;
        this.managerPassword = pin;
    }

}
