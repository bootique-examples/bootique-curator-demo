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

Download and Run the [zooKeeper](http://ftp.byfly.by/pub/apache.org/zookeeper/stable/) server with version 3.4.* .

Enter the following (with -m prefix) to launch the app with all commands in Maven:

```bash
java -jar target/bootique-curator-demo-1.0-SNAPSHOT.jar
```

After run you will see the folowing lines:
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

That means that curator client created node '/a' with no version, then this node was updated and get version '1', then it was updated again and get version '2' and then it was removed.


