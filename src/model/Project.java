package model;

import java.util.Calendar;

public class Proyecto {
    // Atributos
    private String proyectName;
    private String clientName;
    private String clientPhone;
    private Manager manager;
    private double budget;
    private Calendar startDate;
    private Calendar endDate;
    private Stage[] stages;
    private Stage currentStage;
    public static final int SIZE_STAGES = 6;
    private int counterStage = 0;

    // Constructores
    public Proyecto(String proyectName, String clientName, String clientPhone, double budget, String managerName, String managerPhone) {
        this.proyectName = proyectName;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.budget = budget;

    manager = new Manager(managerName, managerPhone);
    stages = new Stage[SIZE_STAGES];
    for (int i = 0; i < SIZE_STAGES; i++) {
        switch (i) {
            case 0:
                stages[i] = new Stage("START", true);
                break;
            case 1:
                stages[i] = new Stage("ANALYSIS", false);
                break;
            case 2:
                stages[i] = new Stage("DESIGN", false);
                break;
            case 3:
                stages[i] = new Stage("EXECUTION", false);
                break;
            case 4:
                stages[i] = new Stage("CLOSE AND FOLLOW-UP", false);
                break;
            case 5:
                stages[i] = new Stage("PROJECT CONTROL", false);
                break;
            default:
                break;
        }
    }
    currentStage = stages[counterStage];

    }

    // Métodos getters
    public String getProyectName() {
        return proyectName;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public Manager getManager() {
        return manager;
    }

    public double getBudget() {
        return budget;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public Stage[] getStages() {
        return stages;
    }

    public Stage getCurrentStage() {
        return currentStage;
    }

    // Métodos setters
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    // Otros métodos
    public boolean setCurrentStage() {
        counterStage++;
        boolean statusCurrentStage = false;
        Calendar date = Calendar.getInstance();
        currentStage.setRealEndDate(date);
        currentStage.setIsActive(statusCurrentStage);
        boolean newStage = true;
        try {
            currentStage = stages[counterStage];
            currentStage.setRealStartDate(date);
            currentStage.setIsActive(newStage);
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }
}
