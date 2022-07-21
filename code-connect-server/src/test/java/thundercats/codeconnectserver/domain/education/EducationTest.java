package thundercats.codeconnectserver.domain.education;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import thundercats.codeconnectserver.domain.education.Education;

public class EducationTest {
    @Test
    public void constructorTest01(){
        Education education = new Education("State University", "City", "1/1/00",
                "12/1/00", "Computer Science", true, 3.5);
        String expected = education.toString();
        String actual = "";
        Assertions.assertEquals(expected,actual);
    }

}
