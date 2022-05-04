#!/bin/sh
echo hello!

RABBIT_ADDRESSES=localhost:5672 STORAGE_TYPE=mysql MYSQL_USER=zipkin MYSQL_PASS=password  java -jar zipkin-server-2.23.16-exec.jar
