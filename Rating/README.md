# RatingSystem 
## Spring Boot WebServices

Assumptions-

1. To get/fetch passenger details based on userId.  url:http://localhost:8080/getUserJsonById/1
	output:json
2. To get/fetch driver details based on driverId. url:http://localhost:8080/getDriverJsonById/1
	output:json
3. Post request to rate driver by passenger url:http://localhost:8080/setDriverRatingJsonById
	
	e.g body={"driverId":4, "rating":5.0}
	output:string
	
4. Post request to rate passenger by driver url:http://localhost:8080/setUserRatingJsonById
	
	e.g body={"userId":1, "rating":4.0}
	output:string
	

---------------------------------------------------------------------------------------------------------------------------------------------------------------------

Approach-

1. In any cab service rating is given by both passenger and driver to each other simultaneously.
2. Scenario1: Passenger rate it's driver
   Rating given by passenger is added to the present total rating of the driver and it's total rides is incremented by 1, and driver's rating is calculated = total ratings/total rides.
	
3. Scenario2: Driver rate it's passenger
   Rating given by driver is added to the present total rating of the passenger and it's total rides is incremented by 1, and passenger's rating is calculated = total ratings/total rides.
	
4. To view the passenger details with it's rating, a get request is fired to fetch user based on it's userId.
5. To view the driver details with it's rating, a get request is fired to fetch driver based on it's driverId.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------
DB-

1.PostgreSQL is used as a backend.

2.Details:
-->url=jdbc:postgresql://localhost:5432/db_rating_system
-->username=postgres
-->password=postgres
-->db-db_rating_system
-->schema-public
-->table-user_model
-->columns-user_id | serial, user_name | character varying(256), user_password | character varying(256), count_user_rating | double precision, count_user_rides | integer, user_rating | double precision.
-->table-driver_model
-->columns-driver_id | serial, driver_name | character varying(256), driver_password | character varying(256), count_driver_rating | double precision, count_driver_rides | integer, driver_rating | double precision.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------
Steps-

1.The project is a spring boot application developed on intellijIdea and postgreSQL at it's backend.

2.Load the project in intellijIdea.

3.Setup the postgreSQL as described above.

4.Open the postman to perform client side GET and POST request to get desired output.







  
	
	
