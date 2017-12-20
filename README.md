# closest-events
This program will return the k closest events to a randomly generated set of n events. Given a coordinate (x,y), the program will return the location, distance to and cheapest ticket price of the k closest events to the give location.

- Built in **Java 1.8**
- Deployed through **Maven**

While this program works well for the given map size of -1o to 10, a more efficient implementation would be needed when scaling up the world space. Rudimentary data structures such as a Hash Map and ArrayLists were used in this particular implementation. However, more specialised structures such as a K-D Tree would be required to ensure the program efficiently scales with the size of the world. 
There may also be a need for more sophisticated algorithms also. Dijkstra is an example of one such method whereby 
