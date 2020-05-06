package org.launchcode.techjobs_oo.Tests;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.PositionType;
import org.launchcode.techjobs_oo.CoreCompetency;
import static org.junit.Assert.*;

public class JobTest {

    Job testJob;
    Job otherTestJob;
    Job testJobStuff;
    Job almostJobStuff;
    Job missingJobStuff;
    String testString;
    String emptyTestString;

    @Before
    public void createTestJob(){
        testJob = new Job();
        otherTestJob = new Job();
        testJobStuff = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType ("Quality Control"), new CoreCompetency("Persistence"));
        almostJobStuff = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType ("Quality Control"), new CoreCompetency("Persistence"));
        missingJobStuff = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType ("Quality Control"), new CoreCompetency("Persistence"));
        testString = testJobStuff.toString();
        emptyTestString = missingJobStuff.toString();
    }

    @Test
    public void testSettingJobId(){
        assertNotEquals(testJob.getId(), otherTestJob.getId());
        assertTrue(testJob.getId()+1 == otherTestJob.getId() || testJob.getId()-1 == otherTestJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        testJobStuff = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", testJobStuff.getName());
        assertEquals("ACME", testJobStuff.getEmployer().getValue());
        assertEquals("Desert", testJobStuff.getLocation().getValue());
        assertEquals("Quality Control", testJobStuff.getPositionType().getValue());
        assertEquals("Persistence", testJobStuff.getCoreCompetency().getValue());
        assertTrue(testJobStuff.getEmployer() instanceof Employer);
        assertTrue(testJobStuff.getLocation() instanceof Location);
        assertTrue(testJobStuff.getPositionType() instanceof PositionType);
        assertTrue(testJobStuff.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(testJobStuff.equals(almostJobStuff));
    }

    @Test
    public void testToStringForBlanks(){
        assertTrue(testString.startsWith("\n"));
        assertTrue(testString.endsWith("\n"));
    }

    @Test
    public void testToStringData(){
        assertTrue(testString.contains("ID: "));
        assertTrue(testString.contains("Name: "));
        assertTrue(testString.contains("Employer: "));
        assertTrue(testString.contains("Location: "));
        assertTrue(testString.contains("Position Type: "));
        assertTrue(testString.contains("Core Competency: "));
    }

    @Test
    public void testToStringEmptyField(){
        assertTrue(emptyTestString.toString().contains("Data not available"));
    }

}
