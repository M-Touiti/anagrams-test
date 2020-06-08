#!/bin/bash
#set -x
ARGS_NUM=1
NO_ARGS=0
if [[ ( $# -gt $ARGS_NUM ) ]]; then
  echo "Usage: script.sh PARAM1"
  exit 1
fi

if [[ ( $# -eq $NO_ARGS ) ]]; then
  java -jar target/anagrams-test-0.0.1-SNAPSHOT-jar-with-dependencies.jar
fi
if [[ ( $# -eq $ARGS_NUM ) ]]; then
  param1=$1	
  java -jar target/anagrams-test-0.0.1-SNAPSHOT-jar-with-dependencies.jar "$param1"
fi
