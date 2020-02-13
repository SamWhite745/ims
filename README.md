# Inventory Management System - League of Legends Skin Shop

This is a project to demonstrate the skills I have learned over the first five weeks of my training. I have used GCP to host a virtual machine, which in turn is hosting a Jenkins server which watches my Master branch on github.
It also automatically runs tests and uses sonarqube for code checking. Finally, if it passes SonarQube it pushes to nexus, an artifact repository.

Test Coverage at 40.0%
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Download and install the following programs.

```
[Java JDK 1.8+](https://www.java.com/en/download/)
[Maven](https://maven.apache.org/install.html)
[MySQL server](https://www.mysql.com/downloads/)
```

* Windows 10
After installing java and maven, you need to add the respective bins to your path environment variable.
A guide to this can be found [here](https://mkyong.com/maven/how-to-install-maven-in-windows/) 

### Installing

To get the program running, firstly download the .jar file from the Nexus Artifact Repository.
Once its downloaded and the prerequisites are installed, run the following command to start the IMS:
```
java -jar **jar name**
```
## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

Explain what these tests test, why and how to run them

```
Give an example
```

### Integration Tests 
Explain what these tests test, why and how to run them

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

To use this in an industrial environment, it requires either a local hosted or cloud based database. Currently, the url to the connected database is hardcoded in, but could be changed very easily or even changed to user input to allow connection to different databases such as a development or a public database. 

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Sam White** - [SamWhite745](https://github.com/SamWhite745) 


## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

## Acknowledgments

* Chris Perrins - Teaching the content and providing code examples 
* Tyler E- aka the rubber ducky 
* Elliot D - Large contributions to Risk Assessment 
* You - for taking the time to go through this README 