# Aqi-Kotlin
Command Line Interface and library to convert between Air Quality Index (AQI) value and pollutant concentration, using the US EPA AQI calculation method.

Project and Readme are WIP.


## Usage


### Command Line

List pollutants and formats:

    $ java -jar cmd-1.0.jar --list
    $ Pollutants: pm10 (µg/m³), o3 (ppm), co (ppm), no2 (ppb), so2 (ppb), pm25 (µg/m³)
    $ Formats: pm10 (pm10:174), o3 (o3:0.081), co (co:12.9), no2 (no2:431), so2 (so2:89), pm25 (pm25:37.8)
    
Convert pollutant concentration to AQI (default, '--aqi' not required):

    $ java -jar cmd-1.0.jar --aqi pm10:174    
    $ pm10:110 

Convert pollutants concentrations to AQI (default, '--aqi' not required):

    $ java -jar cmd-1.0.jar --aqi pm10:174 no2:431 pm25:37.8
    $ pm10:110 
    $ no2:163 
    $ pm25:107 
    
Convert AQI to pollutant concentration:

    $ java -jar cmd-1.0.jar --cc pm25:137    
    $ pm25:50.1


### Library

Convert pollutant concentration to AQI (take Strings as arguments):

    $ val aqi = Calculator().getAqi("pm25", "107")

Convert AQI to pollutant concentration (take Strings as arguments):

    $ val cc = Calculator().getConcentration("pm10", "174")



## Library Installation

### Maven:

    <dependency>
    <groupId>com.thegrxp.aqikotlin</groupId>
    <artifactId>aqikotlin.library</artifactId>
    <version>1.0</version>
    <type>pom</type>
    </dependency>

### Gradle:

    compile 'com.thegrxp.aqikotlin:aqikotlin.library:1.0'


