package thundercats.codeconnectserver.domain.education;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import thundercats.codeconnectserver.domain.education.Education;

public class EducationTest {

    Education education = new Education("State University", "City", "1/1/00",
            "12/1/00", "Computer Science", true, 3.50);

    @Test
    void constructorTest01(){
        String expected = education.toString();
        String actual = "State University, City, 1/1/00, 12/1/00, Computer Science, true, 3.50";
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void setterTest(){
        education.setSchoolName("Private University");
        education.setLocation("Town Center");
        education.setStartDate("1/2/00");
        education.setEndDate("12/2/00");
        education.setFieldOfStudy("Information Technology");
        education.setIsGraduated(false);
        education.setGradePointAvg(3.24);
        String expected = education.toString();
        String actual = "Private University, Town Center, 1/2/00, 12/2/00, Information Technology, false, 3.24";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void getterTest00(){
        String expected = education.getSchoolName();;
        String actual = "State University";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void getterTest01(){
        String expected = education.getLocation();
        String actual = "City";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void getterTest02(){
        String expected = education.getStartDate();
        String actual = "1/1/00";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void getterTest03(){
        String expected = education.getEndDate();
        String actual = "12/1/00";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void getterTest04(){
        String expected = education.getFieldOfStudy();
        String actual = "Computer Science";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void getterTest05(){
        Boolean expected = education.getIsGraduated();
        Boolean actual = true;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void getterTest06(){
        Double expected = education.getGradePointAvg();
        Double actual = 3.50;
        Assertions.assertEquals(expected, actual);

    }


}
