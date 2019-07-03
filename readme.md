# 🧠⚗️ Dynamic Feed Validator

## URL:
> https://bw-dynamic-feed-validator.herokuapp.com/login

## Link test feed: 
- https://werk.noudadrichem.com/feed-validator/benchy-bad-feed.xml (3)
- https://werk.noudadrichem.com/feed-validator/benchy-good-feed.xml (3)
- https://werk.noudadrichem.com/feed-validator/batterijland-bad-feed.xml 
- https://werk.noudadrichem.com/feed-validator/qeuze-google-feed-small.xml
- https://www.wirliebenhunter.de/backend/export/index/export.txt?feedID=1&hash=4ebfa063359a73c356913df45b3fbe7f (5500) TE LANG

## Stack:
- Java EE
- Jersey
- Tomcat
- Angular 7.2
- PostgreSQL


## API endpoints:

#### upload [POST]
/api/xmlservice/upload
```json
{
  "url": "xml feed url"
}
```

#### Feeds van from  user (pseudo user) [GET] 
/api/feed/all

#### Single feed van from  user (pseudo user) [GET] 
/api/feed/[FEED_ID]

#### Messages from feed from user (pseudo user) [GET]
/api/message/all/[FEED_ID]

### Socket URL: [ws://]
ws://HOST/socket


### See Heroku logs:
```bash
heroku logs --tail -a bw-dynamic-feed-validator
```

### test rest servlet: 
/webapp/api/ping
