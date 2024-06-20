package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class BookingPage extends Base{

    By hotelNameList = By.xpath("//div[@data-testid='title']");
    By popUp = By.xpath("//button[@aria-label='Dismiss sign in information.']");

    public ArrayList<String> getHotelNameList() {
       return getElementTextList(hotelNameList);
    }

    public void closePopUp()
    {
        ClickOn(popUp);
    }


}
