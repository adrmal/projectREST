###cURL


#####polecenia

GET

```
curl
--include
--header "Accept: application/json"
--request GET
http://localhost:8080/players
```

```
curl
--include
--header "Accept: application/json"
--request GET
http://localhost:8080/players/123
```


POST

```
curl
--include
--header "Content-Type: application/json"
--header "Accept: application/json"
--request POST
--data '{ "id": "123", "firstName": "Jan", "lastName": "Kowalski", "dateOfBirth": { "day": 29, "month": 2, "year": 1918 }, "nationality": "POLAND", "height": 180, "weight": 75, "position": "STRIKER" }'
http://localhost:8080/players
```


PUT

```
curl
--include
--header "Content-Type: application/json"
--header "Accept: application/json"
--request PUT
--data '{ "id": "123", "firstName": "Janusz", "lastName": "Kowalczyk", "dateOfBirth": { "day": 29, "month": 2, "year": 1918 }, "nationality": "ENGLAND", "height": 180, "weight": 75, "position": "STRIKER" }'
http://localhost:8080/players/123
```


DELETE

```
curl
--include
--request DELETE
http://localhost:8080/players/123
```


#####parametry w poleceniach

```
--include	==	 -i
--header	==	 -H
--request	==	 -X
--data		==	 -d
```
