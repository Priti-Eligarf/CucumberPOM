package stepdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.checkerframework.checker.units.qual.Time;
import org.junit.Assert;
import pages.BookingPage;

import java.util.ArrayList;

import static stepdefination.SharedSD.getDriver;

public class BookingSD {

BookingPage BP = new BookingPage();


    BookingPage bookingPage = new BookingPage();
    @Given("I am on default locations search result screen")
    public void DefaultLocation(){
        getDriver().navigate().refresh();
        try {
            bookingPage.closePopUp();
        }
        catch (Exception e)
        {

        }
    }


    @Then("I verify {string} is within the search result")
    public void i_verify_is_within_the_search_result(String expectedHotelName) throws InterruptedException {
        //Thread.sleep(20);
        ArrayList<String> hotelList = BP.getHotelNameList();
        System.out.println("Total hotels: "+hotelList.size());
        System.out.println(hotelList);

        boolean flag= false;
        for(String hotelName :hotelList){
            if(hotelName.contains(expectedHotelName))
                flag = true;
        }
        Assert.assertTrue(expectedHotelName+": THis hotel is not present in the list",flag);
    }





}
