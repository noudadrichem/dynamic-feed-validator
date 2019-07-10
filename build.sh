#!/bin/sh
echo '__________________BUILDING WAR__________________';
sudo rm -rf target/ && \
sudo heroku repo:purge_cache -a bw-dynamic-feed-validator
sudo heroku repo:reset -a bw-dynamic-feed-validator 

echo '____removed target files____'
mvn clean install && \
cd frontend && \
sudo rm -rf dist
sudo npm run build && \
cd .. && \
cp -R ./frontend/dist/. ./src/main/webapp

git add . && \
git commit -m "build" && \
git push origin master