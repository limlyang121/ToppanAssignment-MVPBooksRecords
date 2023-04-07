Introduction
-------------------
This project is created as part of the Toppan FullStack Developer Assessment.
The Original problem can be found at https://github.com/RyanToppan/CoDev-Assignment-FullStack-Spring.

There are several assumptions made when building the solutions. Since no questions are allowed to be asked to clarify, the next section will list some of the important assumptions and elaborate on why the are Made

Assumptions
-------------------
Back-end Assumptions:
1. The People database's country_code is mapped to the API call's country_code using the ISO-3611 country code standard. However, the database stores country_code as a big_int, while the API supplies country_code as a string in the form of XX (e.g. SG, MY, US, and etc). The mapping guidelines are not explicitly defined, which could lead to issues when the app is tested with Toppan's database. To address this, the project assumes that the mapping adheres to the ISO standard, and utilizes a CSV mapping from https://github.com/lukes/ISO-3166-Countries-with-Regional-Codes/blob/master/slim-2/slim-2.csv. (Change later)
2. Database structure will be created  by "schema.sql" and the data will be load with "data.sql". since there is no details about database, it is assumed that the database will be load with "data.sql" to do testing. Hence, controller is no involved in configured the data.
Front-End Assumptions:
1. Upon startup, the default country will be "SG". the country will change when the "Get Country" is clicked and recall the "getTop3ReadBooks"
2. Since there is no details on what should we display if there is no borrower in that country, i assume that the system will just display NA. i though about just don't display any book that doesn't have borrower, but then it won't be 3 books.

Setting Up
-------------------
The set-up assumes that the machine already has following program/software installed
1. ReactJS(18.2.0)
2. Npm (9.5.1)
3. Java (17)
4. Git (git version 2.39.2.windows.1)
5. Intellij 
6. PGAdmin4

#Section 1. Clone Github Repository
To clone the Github Repository, go the folder/directory you want to put the repository and open cmd/UNIX and run
```
git clone https://github.com/limlyang121/MVPBooksRecords.git
```

Section 2. Create the database in PGAdmin4
Assume that if the Server is empty
![image](https://user-images.githubusercontent.com/103249985/230542497-408daff3-4f10-474f-a759-452bd2dc1383.png)

Create new Server 
![image](https://user-images.githubusercontent.com/103249985/230542922-07a98f5a-c002-4b93-bbfd-f9fd40d691c5.png)



