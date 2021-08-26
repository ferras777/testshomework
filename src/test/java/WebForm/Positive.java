package WebForm;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Positive extends TestBase {

    Faker faker = new Faker ();

    String firstName = faker.name ().firstName (),
            lastName = faker.name ().lastName (),
            email = faker.internet ().emailAddress (),
            gender = "Female",
            mobile = faker.number ().digits (10),
            dayOfBirth = "25",
            monthOfBirth = "October",
            yearOfBirth = "1998",
            subject = "Computer Science",
            hobby = "Reading",
            picture = "Picture.png",
            currentAddress = faker.address ().fullAddress (),
            state = "Rajasthan",
            city = "Jaipur";

    @Test
    void positiveTest () {

        step ("Open web form", () -> {
            open ("https://demoqa.com/automation-practice-form");
            $ (".practice-form-wrapper").shouldHave (text ("Student Registration Form"));
        });
        step ("Fill data user", () -> {
            $ ("#firstName").val (firstName);
            $ ("#lastName").val (lastName);
            $ ("#userEmail").val (email);
            $ ("#genterWrapper").$ (byText (gender)).click ();
            $ ("#userNumber").val (mobile);
        });
        step ("Fill date of birth", () -> {
            $ ("#dateOfBirthInput").clear ();
            $ (".react-datepicker__month-select").selectOption (monthOfBirth);
            $ (".react-datepicker__year-select").selectOption (yearOfBirth);
            $ (".react-datepicker__day--0" + dayOfBirth).click ();
        });
        step ("Fill a subject", () -> {
            $ ("#subjectsInput").val (subject).pressEnter ();
        });
        step ("Fill a hobbies", () -> $ ("#hobbiesWrapper").$ (byText (hobby)).click ());
        step ("Upload picture", () -> {
            $ ("#uploadPicture").uploadFromClasspath ("img/" + picture);
        });
        step ("Fill an address", () -> {
            $ ("#currentAddress").val (currentAddress);
            $ ("#state").scrollTo ().click ();
            $ ("#stateCity-wrapper").$ (byText (state)).click ();
            $ ("#city").click ();
            $ ("#stateCity-wrapper").$ (byText (city)).click ();
        });
        step ("Submi", () -> {
            $("#submit").click();
        });



    step("Verify successful form submit", () ->{
        $ ("#example-modal-sizes-title-lg").shouldHave (text ("Thanks for submitting the form"));
        $x ("//td[text()='Student Name']").parent ().shouldHave (text (firstName + " " + lastName));
        $x ("//td[text()='Student Email']").parent ().shouldHave (text (email));
        $x ("//td[text()='Gender']").parent ().shouldHave (text (gender));
        $x ("//td[text()='Mobile']").parent ().shouldHave (text (mobile));
        $x ("//td[text()='Date of Birth']").parent ().shouldHave (text (dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $x ("//td[text()='Subjects']").parent ().shouldHave (text (subject));
        $x ("//td[text()='Hobbies']").parent ().shouldHave (text (hobby));
        $x ("//td[text()='Picture']").parent ().shouldHave (text (picture));
        $x ("//td[text()='Address']").parent ().shouldHave (text (currentAddress));
        $x ("//td[text()='State and City']").parent ().shouldHave (text (state + " " + city));
    });
 }

}








