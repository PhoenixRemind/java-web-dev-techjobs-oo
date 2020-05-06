package org.launchcode.techjobs_oo;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;
    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job (){
        id = nextId;
        nextId ++;
    }

    public Job (String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    /***
     *I liked the look of the previous block of code here because I thought I was being fancy, but could not find
     *a way to update the appropriate field when the data was not available. It would only ever allow me to use
     *name without throwing errors. Just resulted in an old if statement block that works.
    ***/
    @Override
    public String toString() {
        String str= "\nID: " + this.id;;

        if (this.name == null && this.employer == null && this.location == null && this.positionType == null && this.coreCompetency == null) {
            return str = "OOPS! This job does not seem to exist.";
        }

        if (this.name == "") {
            str = str + "\nName: " + "Data not available" ;
        } else {
            str = str + "\nName: " + this.name ;
        }

        if (this.employer.getValue() == "") {
            str = str + "\nEmployer: " + "Data not available" ;
        } else {
            str = str + "\nEmployer: " + this.employer ;
        }

        if (this.location.getValue() == "") {
            str = str + "\nLocation: " + "Data not available" ;
        } else {
            str = str + "\nLocation: " + this.location ;
        }

        if (this.positionType.getValue() == "") {
            str = str + "\nPosition Type: " + "Data not available" ;
        } else {
            str = str + "\nPosition Type: " + this.positionType ;
        }

        if (this.coreCompetency.getValue() == "") {
            str = str + "\nCore Competency: " + "Data not available\n" ;
        } else {
            str = str + "\nCore Competency: " + this.coreCompetency + "\n" ;
        }

        return str;
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
