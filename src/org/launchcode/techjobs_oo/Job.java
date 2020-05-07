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
     *name without throwing errors. Just resulted in an old if statement block that works after several revisions,
     * this one I am leaving is the most recent committed. My first attempt seemed like it would have failed
     * and it definitely did when it came to inputting "Data not available" on job3 printout. This is my 4th iteration
     * and I think I am content with it.
    ***/
    @Override
    public String toString() {

        if (this.name == null && this.employer == null && this.location == null && this.positionType == null && this.coreCompetency == null) {
            return "OOPS! This job does not seem to exist.";
        }
        if(getName() == "") { setName("Data not available");}
        if(employer.getValue() == "") {setEmployer(new Employer("Data not available"));}
        if(location.getValue() == "") {setLocation(new Location("Data not available"));}
        if(positionType.getValue() == "") {setPositionType(new PositionType("Data not available"));}
        if(coreCompetency.getValue() == "") {setCoreCompetency(new CoreCompetency("Data not available"));}

        return ("*****\nID: " + this.getId() + "\n"
                + "Name: " + this.getName() + "\n"
                + "Employer: " + this.getEmployer() + "\n"
                + "Location: " + this.getLocation() + "\n"
                + "Position Type: " + this.getPositionType() + "\n"
                + "Core Competency: " + this.getCoreCompetency() + "\n*****\n");
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
