# issuetracker

Summary:

Issue tracker is an RESTful API app that tracks bugs which users can create, read, update and delete. This is Java Spring Boot Application with a ReactJS frontend that connects to a MySQL database to persist data. 

![alt text](https://github.com/johnny453/issuetracker/blob/main/images/WelcomePage.png)
![alt text](https://github.com/johnny453/issuetracker/blob/main/images/IssuesPage.png)
![alt text](https://github.com/johnny453/issuetracker/blob/main/images/AddIssuesPage.png)
![alt text](https://github.com/johnny453/issuetracker/blob/main/images/EditIssuesPage.png)


Issues to be fixed:
- Spring Boot: 
  - ~~Integration (Controller web mvc) tests: These currently do not work.~~

- ReactJS:
  - When clicking the 'Add Issue' button and navigating back, an empty row is created. 
  - Headers at the top of the table are not aligned properly. 

Features to be added:
- Deploying app to Heroku
- Security to prevent unauthorised access to the database.
- Login page and admin access to restrict certain methods like deleteAllIssues. 
- Search for issues using filters 


