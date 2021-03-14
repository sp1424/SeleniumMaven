package browserAutomationEntry;

import dataTransferObjects.JuniorDeveloper;
import simpleHTTP.JsonPlaceholderHttpHandler;
import veroxosAutomator.ContactFormHandler;
import com.google.gson.*;
import java.io.*;

/**
 * Project entry point
 *
 * @author Sebastian Pira
 */
public class VeroxosSelenium {

    public static void main(String[] args){

        JsonPlaceholderHttpHandler handler = new JsonPlaceholderHttpHandler();
        GsonBuilder builder = new GsonBuilder();

        String developerData = null;

        try{
            developerData = handler.getPersonJsonData(1);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        Gson gson = builder.create();
        JuniorDeveloper developer = gson.fromJson(developerData, JuniorDeveloper.class);

        ContactFormHandler formHandler = new ContactFormHandler("drivers/chromedriver.exe", developer);
        formHandler.initialisePageAndSelenium();
        formHandler.submitContactForm();
    }
}