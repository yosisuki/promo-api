Simple example of using Spring Boot
===================================

Install MongoDb Enterprise
https://www.mongodb.com/download-center?jmp=nav#enterprise

Open this project using IntellijIdea, edit the application.properties (change the mongodb credential), then run the project
Open on your browser `http://localhost:8585` then follow below endpoints :

A. `POST {{host}}/promo-code/create`

Create Promo Code
Param :
1. code = ABC
2. qty = 10
3. discount = 100001
4. discount_percent = 10
5. max_discount = 100000
6. start_date = 2017-01-01
7. end_date = 2018-01-01

B. `PATCH {{host}}/promo-code/update`

Update Promo Code
Param :
1. code = ABC
2. qty = 10
3. discount = 100001
4. discount_percent = 10
5. max_discount = 100000
6. start_date = 2017-01-01
7. end_date = 2018-01-01

C. `GET {{host}}/promo-code`

Get All Promo Codes

D. `GET {{host}}/promo-code/find?code=ABC`

Find Promo Code by Code
