package model;

public class Manager {
    private String name;

    private String cellPhone;


public Manager (String name , String cellphone){

    this.name=name;
    this.cellPhone=cellPhone;

}

public String getName(){
    return name;
}

public String setName(String name){

    this.name = name;

}

public String getCellphone(){
    return cellPhone;
}

public String setCellphone(String cellPhone){
    this.cellphone = cellPhone;
}

}