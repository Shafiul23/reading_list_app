# Developer Log

15/11/22
* Used https://start.spring.io/ to create template for project and synced it with github. 
* Created docker-compose file with mongodb and mongo express containers
* Updated application.properties to match info in docker file
* Created model for book, including title, author, description, read status
* Created BookRepository interface using MongoRepository
* First run of application successful, inserted first book
* Attempted to implement unique title requirement 
  * First run unsuccessful 
  * Could either create a title variable in ProjectApplication or just use book.getTitle() for the system to recognise it
* Created service layer of application in BookService
* Created api layer of application in BookController
  * Can now view all existing books in book list
  * Can now view specific books ids
  * Can now input new books to the list (no frontend, used postman)
* Error with put requests, cannot change information inside book objects
  * After about 30 mins, found that error was that the server was not restarted so postman did not recognise the put method

## Testing
* Created BookControllerTests with help from a guide online
  * Had an issue where Mock Beans were not being created so every test was failing
  * h2 database (relational sql database) used to run tests but was receiving dependency not found error
    * This was solved by right clicking project -> maven -> reload project

16/11/22
* Tried 6 different test classes using multiple sources, e.g., h2 databases, jpa tests, test containers, etc
  * All of these resulted in failures and required me to change the source code to work
    * Changing the source code led to different errors (e.g., changing optional<> in BookRepository to List<>)
    * Attempted to use @DataMongoTest annotation, used for spring boot apps that use mongodb
        * This uses an in-memory embedded MongoDB
        * At first, the tests kept failing and returned a "fail to load application context" error
        * Upon reviewing the documentation, I tried to disable the embedded MongoDB auto-config to use the real server
        * This passed the first test that bootstraps the test data with mongo template
* Changed ProjectApplication
  * No longer needed to input book objects from this class as I have implemented a post method in the controller class
  * This also meant that I could remove the Optional from BookRepository which was causing many problems
* After 100s of unsuccessful runs, the BookControllerTests now run 
  * To make this work, I removed the BookService class which was causing a lot of errors
    * It's functions were replaced in the controller class
  * Next, I removed the custom method findByBookTitle() in BookRepository, which cleared up a lot of the errors
    * At the cost of slighlty lower functionality, the programme now runs and can be tested
    * This will be mentioned in the application review 
  * Finally, I was receiving an error that had an issue with my database.
    * After searching the error on stackoverflow, I found the solution which was to exclude DataSourceAutoConfiguration
      * This was found in the SpringBootApplication tag, and its default settings were taking priority