# bootique-curator-demo

Simple [Bootique](http://bootique.io) app demonstrating the Bootique Curator Module

# Prerequisites
* Java 1.8 or newer.
* Apache Maven.

# Build the demo

```
git clone https://github.com/bootique-examples/bootique-curator-demo.git
cd bootique-curator-demo
mvn package
```

# Start Zookeeper

You can use docker to run test instance of Zookeeper:

```bash
docker run --name demo-zookeeper -p 2181:2181 --restart always -d zookeeper:3.4
```

# Run the demo

```bash
java -jar target/bootique-curator-demo-1.0-SNAPSHOT.jar
```

If all done right you will see output like this:
```
/a: CREATE
 version: none
/a: SET_DATA
 version: 1
/a: SET_DATA
 version: 2
/a: DELETE
 version: none
```

