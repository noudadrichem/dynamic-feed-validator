#!/bin/sh
echo '__________________BUILDING WAR__________________';

mvn clean install && \
cd frontend && \
npm run build && \
cd .. && \
cp -R ./frontend/dist/. ./src/main/webapp
