# Bills


## Program Logic

The small program creates interaction among User and Store objects following the below sequence:

* `Store`, `User`, and `Item` are created 
* `Store` put items on sale by calling `putOnSale(Item item)` function
* `User` enter stores by calling `enter(Store store)` function
* `User` add ttems to basket by calling `addToBasket(Item item)` function
* `User` can enter into other stores add items from other stores into the same basket
* `User` call `getSum()` to get net bill of the basket

## Build and Run

The program uses [Ant](http://ant.apache.org), a project managed by the Apache
Foundation that interprets commands in an XML file to essentially run
the Java command line tools. First download and install [Ant](https://ant.apache.org/bindownload.cgi) on local machine.

### Command Line
Enter the root directory containing `build.xml` and run the following command to compile codes. 

```bash
$> ant compile
```

The java main function lies in `src/test/Simulation.java`. Type the following command to run simulation. 

```bash
$> ant simulate
```

Type in the following command to run unit tests.

```bash
$> ant unittest
```

## Coverage Report
We use Eclipse IDE to generate coverage report for the tests.

### Eclipse 

Clone the git repository. Open Eclipse and import the program by selecting 
```
File --> import --> Git --> Projects from Git --> Existing Local Repository
```
Add the Bill repository by clicking `Add` and `Browse`. 

In the next page select 
```
import using the New Project Wizard --> Java --> Java Project from Existing Ant Buildfile
```
Browse the ant buildfile and link it to `Bill/build.xml`.

After importing the project, select
```
Run --> Run Configurations --> Junit
```
Check the "Run all tests in the selected project, package, or source folder" and set the link to `Bill` package.
Change "test runner" to Junit4 and we are ready to run.




Li Wendi
