# Inventory Management System - League of Legends Skin Shop

This is a project to demonstrate the skills I have learned over the first five weeks of my training. I have used GCP to host a virtual machine, which in turn is hosting a Jenkins server which watches my Master branch on github.
It also automatically runs tests and uses sonarqube for code checking. Finally, if it passes SonarQube it pushes to nexus, an artifact repository.

Test Coverage at 40.0+%
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Download and install the following programs.

[Java JDK 1.8+](https://www.java.com/en/download/)
[Maven](https://maven.apache.org/install.html)
[MySQL server](https://www.mysql.com/downloads/)

Windows 10

After installing java and maven, you need to add the respective bins to your path environment variable.
A guide to this can be found [here](https://mkyong.com/maven/how-to-install-maven-in-windows/) 

### Installing

To get the program running, firstly download the .jar file from the Nexus Artifact Repository.
Once its downloaded and the prerequisites are installed, run the following command to start the IMS:
```
java -jar **jar name**
```
## Running the tests

This project contains both Unit and Integration tests. To run Unit test use the command:
```
mvn test
```
and to run the integration tests run the command:
```
mvn integration-test
```

### Unit Tests 

Unit tests are performed on methods that do not call other methods. Examples of these include setters and getters.

```
	@Test
	public void settersTest() {
		assertNotNull(customer.getId());
		assertNotNull(customer.getName());
		
		customer.setId(0);
		assertNotNull(customer.getId());
		
		customer.setName(null);
		assertNull(customer.getName());
	}
```

### Integration Tests 
Integration tests are used for methods that rely on other methods. For example, in my item services class, I call item dao functions. But to make sure the service class works properly, I mock the returns from the DAO

```
	@Test
	public void customerServicesCreate() {
		Customer customer = new Customer("Sam White");
		customerServices.create(customer);
		Mockito.verify(customerDao, Mockito.times(1)).create(customer);
	}
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