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

   
The Set up guide will be on windows, linux should be easier as everything can be download via the terminal  

Set-up Required Software
-------------------

**Download Link**  
PostGreSQL Driver : https://www.enterprisedb.com/downloads/postgres-postgresql-downloads  (I'm Using PostgreSQL v15 and Pgadmin4)  
Java : https://www.oracle.com/id/java/technologies/downloads/#jdk17-windows  (I'm using Java 19)  
Node.js : https://nodejs.org/en  (I'm using Node v18.2.0)  
Git : https://git-scm.com/download/win  (I'm Using git version 2.39.2.windows.1)  

**Set-up PostGreSQL (Can skip this if you already have PostgreSQL driver & Pgadmin4 installed)**

Step 1. Download the file and execute the "exe" file
Step 2. A pop out installion box will appear  
![image](https://user-images.githubusercontent.com/103249985/230619005-05b77d99-6b81-411a-b26b-6c91ffcedbfb.png)  

Step 3. Next until it ask you to select which part to install  
![image](https://user-images.githubusercontent.com/103249985/230619145-d5f092a7-6ca9-42ef-b358-95ba6d96fcd0.png)  
for simplicity, just install eveything  
Step 4. Input the key as "1234" and port "5432" (i use those value in my spring application.properties)   
![image](https://user-images.githubusercontent.com/103249985/230619424-57b03c9d-0875-4168-9bd2-c73e15e0afb3.png)  
Step 5. Wait until the installation completed  
Step 6. Now, it will ask to install Stack builder,Select the postGreSQL  
![image](https://user-images.githubusercontent.com/103249985/230620241-f33384d2-d86d-4c1b-854b-ff9e7f49ac8d.png)  
![image](https://user-images.githubusercontent.com/103249985/230620337-7c0fc271-13c8-4a84-ad70-9e3f02b8bcc9.png)  
Step 7. Make sure that psqlODBC is seleced and at least one Database server is installed  
![image](https://user-images.githubusercontent.com/103249985/230620560-dea1018f-136f-4aed-a047-462d9a02c441.png)  
![image](https://user-images.githubusercontent.com/103249985/230620646-8b370cf2-d471-41b4-a0ef-861438e64fc3.png)  
Step 8. Next and wait for the download to end.   
![image](https://user-images.githubusercontent.com/103249985/230620807-b87e64c9-e9a5-4c34-abda-39a2cd10306a.png)  
Step 9. Next again (uncheck the skip installation)  
![image](https://user-images.githubusercontent.com/103249985/230620915-321887da-afc6-4d5f-a3ac-cec8b43f52cb.png)  
Step 10. Next until installation completed  
![image](https://user-images.githubusercontent.com/103249985/230621038-cba48ebb-7904-4d6a-ac04-c22c6aee5251.png)  
Step 11. If the picture is shown, that mean the installation is completed


**Set-up Node.js (Can skip if Node.js is installed)**    
Download and install the executeable file.  


**Set-up Java (Can skip if you already install and set the environment path for Path and Java_home)**  
Step 1. download the File from the link above  
Step 2. Install  the software/package  
Step 3. Add Java 19 bin to path with "Environment Variables"  
Step 4. Open the Path for environment variables  
![image](https://user-images.githubusercontent.com/103249985/230558437-f948876a-9288-49e7-8e46-353d576cf6aa.png)  
Add java bin to Path like the picture below  
![image](https://user-images.githubusercontent.com/103249985/230558483-9e04c129-5fac-425e-8721-893bacc86f4d.png)  
Step 5. Add new Variables  
![image](https://user-images.githubusercontent.com/103249985/230558654-fb6d36a3-a22a-46e6-8c9e-b36e4e682a0a.png)  
fill the data with  
![image](https://user-images.githubusercontent.com/103249985/230558727-1b3045e4-84bf-4971-b85c-fd03b9bc0848.png)  
Click ```ok, then ok again ```  
You good to go.  


**Set-up Git**  
Step 1. Downlaod and install the executable file  
Step 2. for simplicity sake, just next until the installation finished  




Setting Up Project
-------------------
The set-up assumes that the machine already has following program/software installed (The number in bracket is my version of that software)
1. ReactJS(18.2.0)
2. Npm (9.5.1)
3. Java (19)
4. Git (git version 2.39.2.windows.1)
5. Intellij 
6. PostgreSQL Driver (15) && PGAdmin (4) 

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

**Section 3. Setting up Backend**  
***Method 1. Using Maven with CMD***   
Go to the folder/directory that have ./mvnw  
![image](https://user-images.githubusercontent.com/103249985/230546572-9130997c-0775-4716-adf0-142cb545bb6e.png)  

Right click and open CMD or powershells
and type ```./mvnw spring-boot:run```  
![image](https://user-images.githubusercontent.com/103249985/230546919-2d5af278-e267-4c67-94c3-6c0dd84db5bb.png)  

![image](https://user-images.githubusercontent.com/103249985/230546978-91141236-f576-49d2-9943-a8a1dbcccaeb.png)  
The picture above indicated that the application had run successfully.
(Note: first time run will download the dependency first)   

***Method 2. Using Intellij***  
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
  

**Section 4. Setting Up Front-end**  
Step 1. Install necessary packages
Go to the ```front-end``` folder/directory and open cmd/unix to run ```npm install```. this code will download all dependency needed that store in package.json. it might show some warning of vulnurabilities since i not using the latest version of the packages. but the application will run despite the warning
Step 2. Run the Application
after the dependency installed successfully, just need to type npm start incmd/unix terminal and it should automatically open your default browser and load the page ```http://localhost:3000/```
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









