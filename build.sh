#!/bin/sh
echo '__________________BUILDING WAR__________________';
sudo rm -rf target && \
echo '____removed target files____'
mvn clean install && \
cd frontend && \
npm run build && \
cd .. && \
cp -R ./frontend/dist/. ./src/main/webapp

git add . && \
git commit -m "build" && \
git push origin master