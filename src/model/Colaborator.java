

package model;
/**
 * The Colaborator class represents a collaborator and contains information
 * about their status and name.
 */

public class Colaborator{
    private String collaboratorStatus;
    private String collaboratorName;
 
/**
     * Creates a new Colaborator object with the given status and name.
     *
     * @param collaboratorStatus the status of the collaborator
     * @param collaboratorName the name of the collaborator
     */

public Colaborator (String collaboratorStatus , String collaboratorName){
    this.collaboratorStatus=collaboratorStatus;
    this.collaboratorName= collaboratorName;
}

/**
     * Returns the status of the collaborator.
     *
     * @return the status of the collaborator
     */
public String getCollaboratorStatus(){
    return collaboratorStatus
}


/**
     * Sets the status of the collaborator.
     *
     * @param collaboratorStatus the new status of the collaborator
     */
public void setCollaboratorStatus(String collaboratorStatus){
    this.setCollaboratorStatus= collaboratorStatus;
}

 /**
     * Returns the name of the collaborator.
     *
     * @return the name of the collaborator
     */
public String getCollaboratorName(){
    return collaboratorName
}


 /**
     * Sets the name of the collaborator.
     *
     * @param collaboratorName the new name of the collaborator
     */
public void setCollaboratorName(String collaboratorName){
    this.setCollaboratorName=collaboratorName;
}

}