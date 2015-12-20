###cURL


#####polecenia

GET

```
curl
--header "Accept: application/json"
--request GET
http://localhost:8080/players
```


POST

```
curl
--header "Content-Type: application/json"
--request POST
--data '{ "id": "123", "firstName": "Jan", "lastName": "Kowalski", "dateOfBirth": { "day": 29, "month": 2, "year": 1918 }, "nationality": "POLAND", "height": 180, "weight": 75, "position": "STRIKER" }'
http://localhost:8080/players
```


PUT

```
curl
--header "Content-Type: application/json"
--request PUT
--data 'Janusz'
http://localhost:8080/players/123
```


#####parametry w poleceniach

```
--header	==	 -H
--request	==	 -X
```
