# closest-events
This program will return the k closest events to a randomly generated set of n events. Given a coordinate (x,y), the program will return the location, distance to and cheapest ticket price of the k closest events to the given location. This particular implementation assumes that the world space is given in integers (not in floating point).

## Building

This program is built in **Java 1.8** and deployed using **Maven**. To create a .jar build of the project, run:

`mvn clean install`

Then a simple call to `java -jar target/codetest-0.0.1-SNAPSHOT.jar` can be used to run the program.

## Postnotes

While this program works well enough for the given map size of -10 to 10, a more efficient implementation would be needed when scaling up the world space. Rudimentary data structures such as a Hash Map and ArrayLists were used in this particular implementation. However, a more specialised structure such as a K-D Tree would be required to ensure the program efficiently scales with the size of the world, which would bring an average addition/deletion/search time of O(log(n)).

There may also be a need for more sophisticated algorithms also. A 'maximum distance' search could be used if the ratio between the number of events and world size were close enough; The probability of a 'close event' being within a closer range would be higher, so limiting the search range to this may be more efficient. 

This implementation also only allows for one event per location. If multiple events were to be permitted for a single location, the hash map would hold separate lists for its value instead of single events, effectively creating a chained list for each hash entry. Each list would then need to be iterated through to find separate events.


