#Junit5

### Junit4 vs Junit5
[Click](https://howtodoinjava.com/junit5/junit-5-vs-junit-4/) to follow  


###Junit 5 Architecture

**Core Platform**
 
- Developer no need to Interact with this. 
- It contains all the core functionality of Junit. 
- It also called Test Engine. 
- Example: IDE and Tools are using this to run your writing test.

**Jupiter**

- All new Junit5 functionality

**Vintage** 

- Can be Used If you are writing Old Junit 3 or Junit 4

**Ext(3rd Party)** 

- To Extend Junit

  
### Junit Jupiter

New Programming model in Junit.

Extension model.

What you will be primarily working with.

### Maven Dependencies Details For Junti5

`junit-jupiter-api:`
----------------
API for writing tests using Junit Jupiter

```
<dependency>
	<groupId>org.junit.jupiter</groupId>
	<artifactId>junit-jupiter-api</artifactId>
	<version>5.4.0</version>
	<scope>test</scope>
</dependency>
```

`junit-jupiter-engine:`
-------------------

Implementation of the TestEngine API for Junit Jupiter

```
<dependency>
	<groupId>org.junit.jupiter</groupId>
	<artifactId>junit-jupiter-engine</artifactId>
	<version>5.4.0</version>
	<scope>test</scope>
</dependency>
```

`junit-vintage-engine`
-------------------

A thin layer on top of Junit 4 to allow running vintage tests

```
<dependency>
    <groupId>org.junit.vintage</groupId>
    <artifactId>junit-vintage-engine</artifactId>
    <version>5.4.0</version>
    <scope>test</scope>
</dependency>
```

**Junit5 supported Annotations**

[click](https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations) for more details.
