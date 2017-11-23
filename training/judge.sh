#!/bin/bash
FILE_NAME=$1
javac -encoding UTF-8 $FILE_NAME.java
if [[ $? == "0" ]]; then
    for testcase in $(ls . | grep $FILE_NAME.*txt); do
        echo "Runnig test case with input file $testcase:"
        cat $testcase
        echo "Result:"
        java -Xmx1024m $FILE_NAME < $testcase
    done;
    rm *.class
fi
