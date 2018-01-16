# Aqi-Kotlin
Library and Command Line Interface (CLI) to convert between Air Quality Index (AQI) value and pollutant concentration, using the following algorithms:
                                                                                                                           
* United States Environmental Protection Agency (EPA)
* China Ministry of Environmental Protection (MEP)                                                                                                                                                                                                                                                 China Ministry of Environmental Protection (MEP)

Project and Readme are still WIP.
   
## Usage

### Library

Convert pollutant concentration to AQI using EPA algorithm (use Constants as arguments, EPA is default algorithm and not required, return Int):

    val aqi = Calculator().getAqi(POLLUTANT_PM25, 107)
    // or
    val aqi = Calculator().getAqi(POLLUTANT_PM25, 107, EPA)
    
Convert pollutant concentration to AQI using MEP algorithm (use Constants as arguments, return Int):

    val aqi = Calculator().getAqi(POLLUTANT_NO2_1H, 708, MEP)

Convert AQI to pollutant concentration (use Constants as arguments, EPA is default algorithm and not required, return either Int or Double):

    val cc = Calculator().getConcentration(POLLUTANT_PM10, 174)
    
Constants available

    // Pollutants
    EPA: POLLUTANT_PM10 (µg/m³), POLLUTANT_O3_1H (ppm), POLLUTANT_O3_8H (ppm), POLLUTANT_CO_8H (ppm), POLLUTANT_NO2_1H (ppb), POLLUTANT_SO2_1H (ppb), POLLUTANT_PM25 (µg/m³)
    MEP: POLLUTANT_PM10 (µg/m³), POLLUTANT_O3_1H (µg/m³), POLLUTANT_O3_8H (µg/m³), POLLUTANT_CO_1H (mg/m³), POLLUTANT_CO_24H (mg/m³), POLLUTANT_NO2_1H (µg/m³), POLLUTANT_NO2_24H (µg/m³), POLLUTANT_SO2_1H (µg/m³), POLLUTANT_SO2_24H (µg/m³), POLLUTANT_PM25 (µg/m³)
     
    // Algorithms
    EPA
    MEP
     
### Command Line

List pollutants and formats:

    $ java -jar aqikotlin.cmd-1.1.jar --list
    $ EPA: [pm10 (µg/m³), o3_1h (ppm), o3_8h (ppm), co_8h (ppm), no2_1h (ppb), so2_1h (ppb), pm25 (µg/m³)]
    $ MEP: [pm10 (µg/m³), o3_1h (µg/m³), o3_8h (µg/m³), co_1h (mg/m³), co_24h (mg/m³), no2_1h (µg/m³), no2_24h (µg/m³), so2_1h (µg/m³), so2_24h (µg/m³), pm25 (µg/m³)]
    
Convert pollutant concentration to AQI (default: '--aqi' and '--epa' not required):

    $ java -jar aqikotlin.cmd-1.1.jar --aqi --epa pm10:174    
    $ pm10:110 
        
Convert pollutant concentration to AQI using MEP algorithm (default: '--aqi' not required):

    $ java -jar aqikotlin.cmd-1.1.jar --aqi --mep pm10:123    
    $ pm10:87 

Convert pollutants concentrations to AQI (default: '--aqi' and '--epa' not required):

    $ java -jar aqikotlin.cmd-1.1.jar --aqi --epa pm10:174 no2:431 pm25:37.8
    $ pm10:110 
    $ no2:163 
    $ pm25:107 
    
Convert AQI to pollutant concentration:

    $ java -jar aqikotlin.cmd-1.1.jar --cc pm25:137    
    $ pm25:50.1

## Library Installation

### Maven

    <dependency>
    <groupId>com.thegrxp.aqikotlin</groupId>
    <artifactId>aqikotlin.library</artifactId>
    <version>1.1</version>
    <type>pom</type>
    </dependency>

### Gradle

    compile 'com.thegrxp.aqikotlin:aqikotlin.library:1.1'





