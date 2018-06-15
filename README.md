# SpringUser_Registration

You can find the code for the first task on git at https://github.com/treesa6/SpringUser_Registration
The port for the application is defined as "8010" and the welcome page can be visited at: http://localhost:8010/Welcome

welcome.JPG
On clicking on the "here" link, the user is redirected to the page: http://localhost:8010/home 
After entering the required details, the user can be added if the email ID provided is not already registered on the database.

We can also view all existing registered users by pressing the "Show all registered Users" from the Welcome page/home page.

I have used H2 in memory embedded database, which can be accessed at http://localhost:8010/h2-console

The Spring data JPA(Java persistent API) lets us connect to the ORM(Object Relational Mapping), thus helping entity classes be connected to the database.
Each time the user is added, the new user can be seen in the  updated table at "http://localhost:8010/allUsers" and also viewd in the databse by running the sql script:
"select * from userdetails"

I have added a schema.sql and data.sql file to create the "UserDetails" table(if  it doesn't exist already) and add sample data to the database.

The application is a stand alone application and may not be deployed to the server for running the app.  I have created a spring boot application because of its ease of use, dependency injection, and various other advantages like on startup of the application, spring starts:
The application context(which is a container for different services)
Starts the tomcat sever
Sets up the default config
Can include an embedded database
Performs a class path can for all annotated classes
Can build enterprise java applications
