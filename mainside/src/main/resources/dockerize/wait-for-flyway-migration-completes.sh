#!/bin/sh
while true;
do
  if nslookup flyway || ! nc -vzw 2 intro-service 8081;
    then echo \"Waiting depends_on services: flyway, intro-service ...\";
    sleep 2;
  else
    echo \"Depends_on servcies read!\";
    break; fi;
done;
