# Currency converter

## Description
The Currency converter is a Java terminal application that converts values between different currencies using the ExchangeRate-API. The application allows users to choose currency pairs for conversion and input the value to be converted.

## Project structure

```
currency-converter/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── currencyconverter/
│   │   │               ├── models/
│   │   │               │   └── Currency.java
│   │   │               ├── services/
│   │   │               │   └── CurrencyConversionService.java
│   │   │               ├── dtos/
│   │   │               │   └── CurrencyDTO.java
│   │   │               ├── utils/
│   │   │               │   └── ConfigLoader.java
│   │   │               ├── enums/
│   │   │               │   └── MenuOption.java
│   │   │               └── Main.java
│   ├── resources/
│   │   └── config.properties
├── README.md
├── pom.xml (if using Maven)
└── build.gradle (if using Gradle)
```

## Setup

### Prerequisites
- Java 11 or higher
- Maven or Gradle (depending on your build tool preference)
- IntelliJ IDEA or another preferred IDE

### Configuration

#### API key configuration

Create a config.properties file in the src/main/resources directory with the following content:

```
apiKey = YOUR_API_KEY
```

Replace `YOUR_API_KEY` with your actual API key from [ExchangeRate-API](https://www.exchangerate-api.com/docs/overview).

#### Project dependencies

##### Using Maven:

Add the following dependencies to your pom.xml:

```
<dependencies>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.8.8</version>
    </dependency>
    <!-- Add other dependencies as needed -->
</dependencies>
```

###### Using Gradle:

Add the following dependencies to your build.gradle:

```
dependencies {
    implementation 'com.google.code.gson:gson:2.8.8'
    // Add other dependencies as needed
}
```

##### Adding JAR Files Directly:

If you prefer to add the JAR files directly to your project, download the [Gson Jar](https://mvnrepository.com/artifact/com.google.code.gson/gson) and add it to your project

## Running the application

### Build the project:

Use your build tool to compile and build the project. For Maven, run:

```
mvn clean install
```
For Gradle, run:

```
gradle build
```

### Or run the main class from your IDE

## Usage
Upon running the application, you will be presented with a terminal menu to choose conversion options. Follow the prompts to enter the value and perform currency conversion

### Example
Here is an example of how to use the application:

```
**********************
$ Currency Converter $
**********************

Choose a valid option:

1) USD => ARS
2) ARS => USD
3) USD => BRL
4) BRL => USD
5) USD => COP
6) COP => USD
7) Exit

Enter your choice: 1
Enter the amount to convert: 100
Converting 100 USD to ARS results in: 9123.00 ARS
```

