# Trade Statistics

* Trade Statistics is a Java application that calculates trade statistics based on JSON input data.

## Installation and Usage

#### Requirements

- Java 19 or higher

#### Dependencies 

- To run the application on Windows machines, the following command can be used to create a runnable JAR file:
```bash
mvn package
```
- The resulting JAR file can be run using the following command:

```bash
java -jar SmartPulse-Internship-TradeStatistics-jar-with-dependencies.jar
```

#### Getting Started

1. Clone the repository:
```bash
git clone https://github.com/ecenazg/TradeStatistics.git
```

2. Navigate to the project directory:
```bash
cd TradeStatistics
```

## Running the App in an IDE

If you want to run the TradeStatistics application in an IDE, follow these steps:

1. Open the Main.java file located at src/main/java/io/smartpulse/internship/Main.java.
2. Run the Main.java file in your IDE.

## Running the App with Docker

To run the Trade Statistics application using Docker, follow these steps:

1. Make sure you have Docker installed on your machine.
2. Clone the TradeStatistics repository to your local machine.
3. Navigate to the root directory of the cloned repository.
4. Build a Docker container using the following command:
```bash
sh build.sh
```
- This command will create a Docker container named "trade-statistics" based on the Dockerfile in the root directory of the project. The first build may take longer as dependencies are downloaded.

5. Run the Docker container using the following command:
```bash
sh run.sh
```
- This command will start a Docker container named "TradeStatistics" based on the "trade-statistics" Docker image that you just built.

6. You can now access the TradeStatistics application by clicking on the related image.
> Note: The TradeStatistics application may take a few seconds to start up initially, so if you do not see the application immediately, wait a few moments and try again.
7. When you are finished using the TradeStatistics application, you can stop the Docker container using the following command:
```bash
docker stop TradeStatistics
```
- This command will stop the "TradeStatistics" container.

8. If you want to remove the Docker container completely, use the following command:
```bash
docker rm TradeStatistics
```
- This command will remove the "TradeStatistics" container.

### Code Overview

* The Trade Statistics application uses Java 19 and the Connection class is implemented as a singleton. The dates can be modified in the main/resource/config.properties file, which is read as a parameter. Alternatively, you can also provide the dates as input parameters.

* Lombok Library

The Lombok library was used in this project to reduce boilerplate code. The Contract class contains the annotations @Data and @AllArgsConstructor, which automatically generate getter/setter methods and constructors for all fields in the class. 
