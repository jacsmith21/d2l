# D2L++
The 2017 UNB Atlantic Engineering Competiion Qualifiers repository for team 2.

D2l++ is a full stack web application meant to partially replace the Learning Management System used at UNB called D2L. With D2L++, you can upload your assignments to a specific dropbox and download them (if you have the correct permissions).

You c̶a̶n̶ could find the application running [here](https://d-2-l.heroku.com).

## Setup
1. Setup a MySQL database.
2. Change the `application.properties` file in the `resource` directory to the correct MySQL information.
3. Import this repository as a Maven project in an IDE. We used Intellij IDEA.
4. Run the `QualifiersApplication` class.
