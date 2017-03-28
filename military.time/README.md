# Military Time

## Overview
Given 4 integers, the latest military time will be returned. 
In this case, 00:00 is the earliest time possible, while 23:59 is the latest.

## Installation

To compile:

    $ javac MilitaryTime.java
    
Format for command line input:

    $ java MilitaryTime [integer_1] [integer_2] [integer_3] [integer_4]
    
Examples:

    $ java MilitaryTime 3 4 2 9
    Latest time: 23:49
    $ java MilitaryTime 2 1 9 6
    Latest time: 19:26
    $ java MilitaryTime 0 8 5 8
    Latest time: 08:58
    
    $ java MilitaryTime 0 8 5 10
    Not Possible
    $ java MilitaryTime 2 2 9 9
    Not Possible
    $ java MilitaryTime -1 7 2 1
    Not Possible
    $ java MilitaryTime 1 2 3 4 5
    Not Possible
    
    
