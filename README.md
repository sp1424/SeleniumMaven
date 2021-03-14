# SeleniumMaven

What this project does is make a simple HTTP GET request to https://jsonplaceholder.typicode.com/users/1. It uses the Json Data from there to instatiate a Junior Software Developer
object. Then with Selenium a process is automated to fill in a contact form on veroxos.com.

Things to note:
1. This project was build and test on windows using chromedriver.exe. For ease of us I have attached chromedriver.exe to this repository (I do not own it or have created it).
2. If you would be using a different OS (e.g. macOS), there is a constructor in which you can specify a path to the correct executable - Object is ContactFormHandler.
3. The HTTP request is dynamic and not static - in the sense that we can send a HTTP request and not only request the same data. The getDeveloperJsonData(int developerIndex)
   function from the JsonPlaceholderHttpHandler object utilises the developerIndex parameter to send a request with any integer we would want for different results.
4. If the response body is empty from the request sent then the programme tells the user and stops itself from continuing.

Project Structure:
1.Entry Point: VeroxosSelenium.java in browserAutomationEntry package.
2.Http Request (GET): JsonPlaceholderHttpHanlder.java in simpleHTTP package
3.Instatiation of JuniorDeveloper object: (JuniorDeveloper.java) and other required objects from JSON in dataTransferobjects package.
4.Class used for constants to store html used by Selenium: HTMLIdentifiers.java in veroxosWebConstants package.
5.Selenium driver: ContactFormHandler.java in veroxosAutomator package.
