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