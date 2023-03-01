# restaurant-recommand
Restaurant Recommandation Engine


Addition of Restaurant : 

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



Addition of Order for User : 

curl --location --request POST 'http://localhost:2023/v1/order?userId=6f560097-a1xa-00f4-f2bd-8b9ea0271b20&restaurantId=3f562597-a1ca-41f4-82bd-8b9ea0271b20&cuisineType=NORTH_INDIAN'

