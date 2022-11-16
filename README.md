# Reading List App

Hello! This project was inspired by a problem I face in my life - keeping track of the books I've read and the books I 
want to read in the future. It is also an opportunity for me to solidify the skills I have learned with new technologies.

The technologies used in this project include Java, Spring Boot, Docker and MongoDB. The aim is to combine these to create
an application where I could create, read, update and delete different items on a list of books. 


### Built With

* [![Java][Java.com]][Java-url]
* [![SpringBoot][spring.io/projects/spring-boot.com]][springboot-url]
* [![Mongodb][Mongodb.com]][Mongodb-url]
* Docker

### User Stories
As a user, 
To keep track of what I want to read,
I want to post books to my reading list 

As a user,
To have more information about the book,
I want the reading list to tell me the title, author, description and if I've read it yet

As a user,
To check my reading list,
I want to be able to get all my books in one place
I also want to be able to specifically search for one book 

As a user, 
To edit current entries,
I want to be able to change details of existing books, such as the read status

As a user, 
To remove books from my list, 
I want to be able to delete a book from the list

### Usage
![Run App](reading_list_screenshots/RunApp.png?raw=true)
To start the application, run ProjectApplication.
![Run Services](reading_list_screenshots/RunServices.png?raw=true)
I then run the docker-compose.yaml file to run the containers mongo-express and mongodb on docker. 
![Reading List Browser](reading_list_screenshots/ReadingListBrowser.png?raw=true)
Here we can see the list of books that exist in the database. It is displayed in JSON format on localhost:8080.
![Single Book Browser](reading_list_screenshots/SingleBookBrowser.png?raw=true)
We can also put in a specific id into the address to return a single book.
![Post Request](reading_list_screenshots/PostReq.png?raw=true)
Switching over to postman, we are able to make post requests to input new books into the database. Postman repeats
the body of the object to indicate that the request was successful.
![Put Request](reading_list_screenshots/PutReq.png?raw=true)
Next, we are able to edit the fields of the object as shown in the example above. The read status has successfully been 
changed from true to false. This is useful as we can tick off books that we've read after putting them in the list. 
![Delete Request](reading_list_screenshots/DelReq.png?raw=true)
If a book is mistakenly added to the list, it can easily be removed as shown above in the postman test. 
![Get Request](reading_list_screenshots/GetReq.png?raw=true)
The get request above shows that the most recent book was successfully removed from the reading list. 
![Passing Tests](reading_list_screenshots/PassingTests.png?raw=true)
To finish off, the BookControllerTests test each method in the controller class, which is responsible for handling the different 
types of requests that the application might receive. 

### Review
This project was fun to code and a great experience with using technologies that are new to me, such as Spring Boot and
Docker. I already had some experience with MongoDB from previous projects, but I hadn't used it with Java and Docker like
I did in this project. The toughest challenge I faced in this project was to get the tests running successfully. I had
encountered several issues and tried multiple different methods to test the code, such as using an embedded MongoDb database,
test containers from Docker, and more. In the end I went with using JUnit 5 and a H2 database, an in-memory relational
database that would allow me to run my tests without needing to access the Mongo database that the application used. To
find out more about my journey with this project, check out `Log.md` located in the same directory as this readme file.

If I was to do this project differently, I would definitely write the tests first as I value the importance of TDD but 
wasn't confident in my testing abilities with these new technologies when starting off with the project. Additionally,
I would perhaps try it again using different technologies, such as an SQL database or Spring Data JPA as I came across
these alternatives during my research, and they seemed interesting. 

This project provides the backend for the reading list application. If I were continuing to develop this project, I would
add some additional features, such as implementing a front end to make it more accessible for users other than myself. I
would do this using React.js, and then deploy the application using a service like Render. Furthermore, I would add some 
extra functionality to the code, allowing users to search for books by title / author, or to display all books that haven't 
been read into one list. 





 <!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[Mongodb.com]:https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white
[Mongodb-url]: https://www.mongodb.com/
[spring.io/projects/spring-boot.com]:https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[springboot-url]: https://spring.io/projects/spring-boot
[Docker.com]:https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white
[Docker-url]: https://www.docker.com/
[Java.com]:https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white
[Java-url]: https://www.java.com/en/
