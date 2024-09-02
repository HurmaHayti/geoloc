# About The Project

This is a utility that takes a city, state, or zip code and returns the latitude, longitude, place
name, and any other necessary information from the API. It makes use of the
Coordinates by location name and the Coordinates by zip/post code endpoints. Also, it is able to handle multiple
location inputs.
Location was limited to be within the United States.

## Getting Started

### Prerequisites

- Java 8+
- Maven 3+

### Installation

1. Get a free API Key at https://home.openweathermap.org/users/sign_up
2. Use command prompt or powershell or git bash terminal to execute below commands.
3. Clone the repository
   `git clone https://github.com/HurmaHayti/geoloc.git`
4. Inside the cloned project folder, execute `mvn clean install -Dapikey=<Your_Api_Key>`

### How to run
Inside the project folder, execute
`java -Dapikey=<Your_Api_Key> -cp target/geoloc-util-1.0-SNAPSHOT.jar com.geoapp.GeoLocApplication "<City, State>" "Zip_Code"`

#### Examples:

Inputs will be given in the following formats:
● City and place combination: “Madison, WI”
● Zip Codes: “12345”
Inputs should be given to the utility as a list of strings.

`java -Dapikey=<Your_Api_Key> -cp target/geoloc-util-1.0-SNAPSHOT.jar com.geoapp.GeoLocApplication "Madison, WI" "12345" "Chicago, IL" "10001"`

## Reference Documentation

https://openweathermap.org/api/