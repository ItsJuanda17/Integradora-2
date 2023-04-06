/**

The Stage class represents a project stage with planned and real start and end dates, and a collection of Capsules.
*/

package model;

import java.util.Calendar;

public class Stage{

    private boolean isActive;
    private Calendar plannedStartDate;
    private Calendar plannedEndDate;
    private Calendar realStartDate;
    private Calendar realEndDate;
    private Capsule[] capsules;
    public static final int SIZE_CAPSULE = 50;
    private int counterCapsule ;

/**
 * Constructs a new Stage object with the specified planned start and end dates.
 *
 * @param plannedStartDate The planned start date of the stage.
 * @param plannedEndDate The planned end date of the stage.
 */
    public Stage(Calendar plannedStartDate , Calendar plannedEndDate){

        this.plannedStartDate= plannedStartDate;
        this.plannedEndDate=plannedEndDate;
        isActive=false;
        capsules = new Capsule[SIZE_CAPSULE];
        initCapsule();
        counterCapsule = 0;


    }
/**
 * Initializes the Capsule array with null values.
 */
    public void initCapsule() {
  
    
    for (int i = 0; i < SIZE_CAPSULE; i++) {
        capsules[i] = new Capsule(null, -1, "", null, null);
      }
    }

/**
 * Adds a new Capsule to the stage with the specified information.
 *
 * @param situationDescription The description of the situation that led to the Capsule being created.
 * @param capsuleType The type of the Capsule.
 * @param authorName The name of the author of the Capsule.
 * @param authorPosition The position of the author of the Capsule.
 * @param lessonLearned The lesson learned from the Capsule.
 */
    public void addCapsule(String situationDescription, int capsuleType, String authorName, String authorPosition, String lessonLearned){
    Capsule newCapsule = new Capsule(situationDescription, capsuleType, authorName, authorPosition, lessonLearned);
    newCapsule.extractLessonHashtags(lessonLearned);
    newCapsule.extractSituationHashtags(situationDescription);
    newCapsule.setSituationDescription(situationDescription);
    newCapsule.setCapsuleType(capsuleType);
    newCapsule.setAuthorPosition(authorPosition);
    newCapsule.setAuthorName(authorName);
    newCapsule.setLessonLearned(lessonLearned);
    
    capsules[counterCapsule] = newCapsule;
    counterCapsule++;

    }
/**
 * Returns whether the stage is currently active or not.
 *
 * @return true if the stage is currently active, false otherwise.
 */
    public boolean isActive(){
        return isActive;
    }

    public void desactivate(boolean isActive){
        this.isActive = isActive;
    }
/**
 * Activates the stage and sets the real start date to the current system time.
 */
    public void activate(){
        isActive= true;
        realStartDate = Calendar.getInstance();
    }


/**
 * Gets the array of capsules in the stage.
 *
 * @return the array of capsules
 */
    public Capsule[] getCapsules(){
        return capsules;
    }

/**
 * Gets the planned start date of the stage.
 *
 * @return the planned start date
 */
    public Calendar getPlannedStartDate(){
        return plannedStartDate;
    }

/**
 * Gets the planned end date of the stage.
 *
 * @return the planned end date
 */
    public Calendar getPlannedEndDate(){
        return plannedEndDate;
    }
/**
 * Gets the real start date of the stage.
 *
 * @return the real start date
 */
    public Calendar getRealStartDate(){
        return realStartDate;
    }

    /**
 * Gets the real end date of the stage.
 *
 * @return the real end date
 */
    public Calendar getRealEndDate(){
        return realEndDate;
    }

    public void setPlannedStartDate(Calendar plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

     public void setPlannedEndDate(Calendar plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }





}