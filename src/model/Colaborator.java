package model;

public class Colaborator{
    private String collaboratorStatus;
    private String collaboratorName;
 


public Colaborator (String collaboratorStatus , String collaboratorName){
    this.collaboratorStatus=collaboratorStatus;
    this.collaboratorName= collaboratorName;
}

public String getCollaboratorStatus(){
    return collaboratorStatus
}

public void setCollaboratorStatus(String collaboratorStatus){
    this.setCollaboratorStatus= collaboratorStatus;
}

public String getCollaboratorName(){
    return collaboratorName
}

public void setCollaboratorName(String collaboratorName){
    this.setCollaboratorName=collaboratorName;
}

}