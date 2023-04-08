Introduction
-------------------
This project is created as part of the Toppan FullStack Developer Assessment.  
The Original problem can be found at https://github.com/RyanToppan/CoDev-Assignment-FullStack-Spring.  

There are several assumptions made when building the solutions. Since no questions are allowed to be asked to clarify, the next section will list some of the important assumptions and elaborate on why the are Made  

Assumptions
-------------------
Back-end Assumptions:  
1. The People database's country_code is mapped to the API call's country_code using the ISO-3611 country code standard. However, the database stores country_code as a big_int, while the API supplies country_code as a string in the form of XX (e.g. SG, MY, US, and etc). The mapping guidelines are not explicitly defined, which could lead to issues when the app is tested with Toppan's database. To address this, the project assumes that the mapping adheres to the ISO standard, and utilizes a CSV mapping from https://github.com/lukes/ISO-3166-Countries-with-Regional-Codes/blob/master/slim-2/slim-2.csv.  
2. Database structure will be created  by "schema.sql" and the data will be load with "data.sql". since there is no details about database, it is assumed that the database will be load with "data.sql" to do testing. Hence, controller is no involved in configured the data.  

  

Front-End Assumptions:  
1. Upon startup, the default country will be "SG". the country will change when the "Get Country" is clicked and recall the "getTop3ReadBooks"
2. Since there is no details on what should we display if there is no borrower in that country, i assume that the system will just display NA. i though about just don't display any book that doesn't have borrower, but then it won't be 3 books.



Setting Up Project
-------------------
The set-up assumes that the machine already has following program/software installed (The number in bracket is my version of that software)
1. ReactJS(18.2.0)
2. Npm (9.5.1)
3. Java (19) (Set path environment and JAVA_HOME)  
4. Git (git version 2.39.2.windows.1)
5. PostgreSQL Driver (15) && PGAdmin (4) 
6. Intellij (Optional)

**Section 1. Clone Github Repository**  
To clone the Github Repository, go the folder/directory you want to put the repository and open cmd/UNIX and run
```
git clone https://github.com/limlyang121/MVPBooksRecords.git
```

**Section 2. Create the database in PGAdmin4**  
Step 1. Set up server 
if the Server is empty    
![image](https://user-images.githubusercontent.com/103249985/230542497-408daff3-4f10-474f-a759-452bd2dc1383.png)  
Right click -> Register -> Server  
The server name can just put "PostGreSQL15" or random  
then go to "Connection" Tab  

If there is an existing server
Right click -> Properties -> Connections  
![image](https://user-images.githubusercontent.com/103249985/230543665-57b46366-7e16-4f62-90ad-a1b3851b6f26.png)  

Fill the Data like picture below  
![image](https://user-images.githubusercontent.com/103249985/230542922-07a98f5a-c002-4b93-bbfd-f9fd40d691c5.png)  
password is 1234 (need to be same in the spring application.properties  

After click save, it should look like this  
![image](https://user-images.githubusercontent.com/103249985/230543924-cec76fbb-e696-4f11-ba5d-18e0c571611e.png)  

Step 2. Create New Database with name "my_database"  
Right click on "Databases" then -> Create -> Database  
![image](https://user-images.githubusercontent.com/103249985/230544082-8fd8090d-f111-4137-8366-067fdb982b03.png)  


name the database with "my_database" then click save  
![image](https://user-images.githubusercontent.com/103249985/230544144-c5a73a02-101d-468a-97e1-b633b7aeaaca.png)  


If "my_database" appear like in the picture below, the st up is completed  
![image](https://user-images.githubusercontent.com/103249985/230544187-d125a09a-35e3-48e4-9d78-b6e4060879ab.png)  

***Section 3. Setting up Backend(The database must be running)***  
**Method 1. Using Maven with CMD**   
Go to the folder/directory that have ./mvnw  
![image](https://user-images.githubusercontent.com/103249985/230546572-9130997c-0775-4716-adf0-142cb545bb6e.png)  

Right click and open CMD or powershells
and type ```./mvnw spring-boot:run```  
![image](https://user-images.githubusercontent.com/103249985/230546919-2d5af278-e267-4c67-94c3-6c0dd84db5bb.png)  

![image](https://user-images.githubusercontent.com/103249985/230546978-91141236-f576-49d2-9943-a8a1dbcccaeb.png)  
The picture above indicated that the application had run successfully.
(Note: first time run will download the dependency first)   

**Method 2. Using Intellij**  
using Intellij will be easier if user does not have experience terminal or cmd.   
User will just need to open the back-end project with "File -> Open" then select the directory like in the picture below  
![image](https://user-images.githubusercontent.com/103249985/230545050-00e1aa2e-8600-4ae6-a143-2884456ceaba.png)  
it is recommend to open the project at that level (the one that in the same level as "front-end") as opening it at the root might cause some issues.

After open the project, use maven to grab any dependency that in the pom file with  
```
Right click on the Project name -> Maven -> Reload Project
``` 
Like in the picture below  
![image](https://user-images.githubusercontent.com/103249985/230545541-9bcbb6cb-1eb7-4f0f-8c87-d9c0e2eda81b.png)  

Wait for the Dependecy to download
Once all the dependency had been download
```
Go to src/main/java/com/booksrecords/demo/MVPBookRecords/MvpBookRecordsApplication.java
```
And run the Application  
![image](https://user-images.githubusercontent.com/103249985/230546266-4a0a3d10-3434-4fdf-a1eb-14006b1b1db4.png)  

the image above imply that the Application have run successfully   


**Note**
The database will be filled with data from "data.sql" as that is the default name to populate data, if you want to use different data sets, you can go ahead replace or rewrite the SQL command inside ```data.sql```
  

***Section 4. Setting Up Front-end***  
Step 1. Install necessary packages
Go to the ```front-end``` folder/directory and open cmd/unix to run ```npm install```. this code will download all dependency needed that store in package.json. it might show some warning of vulnurabilities since i not using the latest version of the packages. but the application will run despite the warning
Step 2. Run the Application
after the dependency installed successfully, just need to type ```npm start``` in cmd/unix terminal and it should automatically open your default browser and load the page ```http://localhost:3000/```
it should book up the page like below  

![image](https://user-images.githubusercontent.com/103249985/230548072-32a862b8-f485-498d-ba97-18d0460eb654.png)

if no borrower
![image](https://user-images.githubusercontent.com/103249985/230548121-ea32a922-6915-4b4b-b7e9-fe04f31e246e.png)  

If Invalid Parameter or no result  
![image](https://user-images.githubusercontent.com/103249985/230623799-61e8b79e-fafd-4c4b-86e7-26e2e798fff5.png)  



Last Note
-------------------
if you encounter any problems during the set up, feel free to contant me using my emails which is "limlyang121@outlook.com"
Thanks you

Spring Test Result   
-------------------  
![image](https://user-images.githubusercontent.com/103249985/230704620-3b23e496-c9b3-4305-886e-7d25ea687341.png)  









