# Dynamic feed Validator

> http://localhost:9090/webapp/api/ping

## Link test feed: 
- https://werk.noudadrichem.com/feed-validator/benchy-bad-feed.xml (3)
- https://bannerwise-assets.s3.eu-central-1.amazonaws.com/xml/benchy.xml (3)
- https://www.wirliebenhunter.de/backend/export/index/export.txt?feedID=1&hash=4ebfa063359a73c356913df45b3fbe7f (5500)


## API endpoints:

#### upload
http://localhost:9090/api/xmlservice/upload
```json
{
	"url": "https://www.wirliebenhunter.de/backend/export/index/export.txt?feedID=1&hash=4ebfa063359a73c356913df45b3fbe7f"
}
```

#### upload [POST]
http://localhost:9090/api/xmlservice/upload
```json
{
	"url": "https://www.wirliebenhunter.de/backend/export/index/export.txt?feedID=1&hash=4ebfa063359a73c356913df45b3fbe7f"
}
```

#### Feeds van from  user (pseudo user) [GET] 
http://localhost:9090/api/feed/all

#### Single feed van from  user (pseudo user) [GET] 
http://localhost:9090/api/feed/[FEED_ID]

#### Messages from feed from user (pseudo user) [GET]
 http://localhost:9090/api/message/all/[FEED_ID]
