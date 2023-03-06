# restaurant-recommand
Restaurant Recommandation Engine

Ther schema.sql and data.sql files loads test data to the sample DB.  

DB Details : 
    url : http://localhost:2023/restaurant-db/
    username : admin
    password : admin


The class 
[RestaurantRecommandApplication.java](src%2Fmain%2Fjava%2Fcom%2Ftdf%2Frestaurantrecommand%2FRestaurantRecommandApplication.java)
 is the trigger point for the schedular (if aiutomation needs to taken care for, else controller [RecommandationEngineController.java](src%2Fmain%2Fjava%2Fcom%2Ftdf%2Frestaurantrecommand%2Fcontroller%2FRecommandationEngineController.java) 
 is a good point to start).

Some of the onboarded users in test data are : 

```
0x129856-a1ca-41f4-82bd-8b9ea0271b28
1p129856-a1ca-41f4-82bd-8b9ea0271b28
3d129856-a1ca-41f4-82bd-8b9ea0271b28
2o129856-a1ca-41f4-82bd-8b9ea0271b28
```

Addition of Restaurant : 

```
curl --location --request POST 'http://localhost:2023/v1/restaurant' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"My Res 1",
    "city":"Bengaluru",
    "locality":"HSR Layout",
    "address":"HSR Layout Sec# 6",
    "cuisineType":"NORTH_INDIAN",
    "dateTimeOnboarded":"2023-03-01T23:00-00:00",
    "costBracket":5
}'
```


Addition of Order for User : 

```
curl --location --request POST 'http://localhost:2023/v1/order?userId=6f560097-a1xa-00f4-f2bd-8b9ea0271b20&restaurantId=3f562597-a1ca-41f4-82bd-8b9ea0271b20&cuisineType=NORTH_INDIAN'
```
