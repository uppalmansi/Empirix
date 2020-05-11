# Empirix
This Git Repo contains the required test cases of Empirix Cloud Platform.

This maven project contains 4 test cases that can be executed via
  a. testng.xml file
  b. pom.xml file
  c. run.bat file
 
 Project Structure
  a. browserHandling package: will deal with browser related classes
  b. configFiles package: contains 2 files
      a. config.properties: to define the overall properties
      b. log4j.properties: for logging information
  c. pageObjectModel package: contains the common repo for all the objects
  d. pages package: contains the page classes that defines the functions that uses objects to perform operation
  e. propertyReader package: defines the classes that deals with config, log4j files
  f. tests package: defines the test classes containing TestNg annotation
  
  For running the project, please run any of the above defined file.
 
