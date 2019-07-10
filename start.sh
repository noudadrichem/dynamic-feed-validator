#!/bin/sh
echo '__________________STARTING__________________'
sudo mvn clean install && sudo mvn tomcat7:run