package model;

import java.util.Calendar;

public class Stage{

    private String boolean isActive;
    private Calendar plannedStartDate;
    private Calendar plannedEndDate;
    private Calendar realStartDate;
    private Calendar realEndDate;
    private Capsule[] capsules;
    public static final int SIZE_CAPSULE = 50;
    private int counterCapsule = 0;

    public Stage(Calendar plannedStartDate , Calendar plannedEndDate){

        this.plannedStartDateStage= plannedStartDateStage;
        this.plannedEndDateStage=plannedEndDateStage;
        this.isActive=false;
        this.capsules= new Capsule[SIZE_CAPSULE];


    }

    public boolean isActive(){
        return isActive;
    }

    public void activate(){
        isActive= true;
        realStartDate = Calendar.getInstance();
    }

    public void desactivate(){
        isActive=false;
        realEndDate= Calendar.getInstance();
    }

    public void addCapsule(Capsule capsule){
        if (counterCapsule < SIZE_CAPSULE){
            capsules[counterCapsule]= capsule;
            counterCapsule++;
        }
        else{
            Sytem.out.println("Stage full ");
        }
    }

    public Capsule[] getCapsules(){
        return capsules;
    }

    public Calendar getPlannedStartDate(){
        return plannedStartDate;
    }
    public Calendar getPlannedEndDate(){
        return plannedEndDate;
    }

    public Calendar getRealStartDate(){
        return realStartDate;
    }
    public Calendar getRealEndDate(){
        return realEndDate;
    }



}