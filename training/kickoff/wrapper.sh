#!/bin/bash
javac -encoding UTF-8 Sum.java
java -Xmx1024m Sum < input.txt
