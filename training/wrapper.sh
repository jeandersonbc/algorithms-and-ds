#!/bin/bash
FILE_NAME=$1
javac -encoding UTF-8 $FILE_NAME.java
java -Xmx1024m Sum < $FILE_NAME.txt
