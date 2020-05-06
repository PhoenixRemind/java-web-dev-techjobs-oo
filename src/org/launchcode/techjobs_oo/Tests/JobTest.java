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



    @Before
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
    }

}
