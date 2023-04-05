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

        this.plannedStartDate= plannedStartDate;
        this.plannedEndDate=plannedEndDate;
        isActive=false;
        capsules = new Capsule[SIZE_CAPSULE];
        initCapsule();


    }

    public void initCapsule() {
  
    
    for (int i = 0; i < SIZE_CAPSULE; i++) {
        capsules[i] = new Capsule(null, -1, "", null, null);
      }
    }

    public void addCapsule(String situationDescription, int capsuleType, String authorName, String authorPosition, String lessonLearned){
    Capsule newCapsule = new Capsule(situationDescription, capsuleType, authorName, authorPosition, lessonLearned);
    newCapsule.extractLessonHashtags(lessonLearned);
    newCapsule.obteinHashtagsSituation(situationDescription);
    newCapsule.setSituationDescription(situationDescription);
    newCapsule.setCapsuleType(capsuleType);
    newCapsule.setAuthorPosition(authorPosition);
    newCapsule.setAuthorName(authorName);
    newCapsule.setLessonLearned(lessonLearned);
    
    capsules[counterCapsule] = newCapsule;
    counterCapsule++;

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