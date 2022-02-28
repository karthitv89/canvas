<h1 align="center">Canvas</h1> <br>

<p align="center">
    A Drawing program is a canvas where we can draw line, rectangle, or bucket-fill. The application is open for new functionalities.</p>

## Table of Contents

- [Features](#features)
- [Corner Cases Handled](#corner-cases-handled)
- [Patters Used](#patterns)
- [Testing](#testing)

## Features

These are the current functionality of the program. In a nutshell, the program works as follows:

1. Create a new canvas
2. Start drawing on the canvas by issuing various commands

   | Command      | Description                                                                                                                                                              |
   |-------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
   | C w h        | create a new canvas of width w and height h.                                                                                                                      |
   | L x1 y1 x2 y2 | create a new line from (x1,y1) to (x2,y2). Currently only                                                                                                         |
   | R x1 y1 x2 y2 | create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character. |
   | B x y c      | fill the entire area connected to (x,y) with "colour" c. The  behavior of this is the same as that of the "bucket fill" tool in paint programs.                   |
   | Q            | quit the program.                                                                                                                                                 |


## Corner Cases Handled
1. Invalid operation command type
2. Invalid x or y axis values
3. Bucket fill character is not a Single character
4. Out of canvas boundary values 

## Patterns

We are using Command pattern to invoke each functionality.

## Testing

- The application can be tested by executing test case [MainTest.draw()](src/test/java/com/karthik/canvas/MainTest.java)

### Local

* [Java 8 SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven](https://maven.apache.org/install.html)
