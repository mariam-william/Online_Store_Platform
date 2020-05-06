# Online Store Platform

## Overview
  This is an Online Store Platform providing various web services. 

## Docker Image
* **Docker Image**  - [Through this Link]()

#### Release History
  * March 2020: V1
  
## Table of contents
1. **[General info](#general-info)**
2. **[Implementation](#implementation)**
3. **[Project Document](#project-document)**
4. **[Project Diagrams](#project-Diagrams)**
5. **[Authors](#authors)**
6. **[Github](#github)**
7. **[How to use?](#how-to-use)**

##General Info 
This platform will help customers to buy or explore products and small stores (businesses) to market for their products and get more customers. 
This platform is much like Amazon store but here our platform will focus on both online and onsite stores and both small business and big businesses.
In this project we will focus on building a reliable API for our store.

## Implementation
  This API is implemented and tested by Java Maven, using Spring Boot. Based on DDD (Domain-driven Design) Architecture.
  
## Project Document
  ![SDS Document ]()

## Project Diagrams
*  **Class Diagram**
![Class diagram](https://github.com/mariammakram/Online_Store_Platform/blob/master/Class%20Diagram.png)
*  *User Register Sequence Diagram**
![register sequence diagram](https://github.com/mariammakram/Online_Store_Platform/blob/master/Sequence%20Diagram/UserRegisterSequenceDiagram.png)
*  **List All Users Sequence Diagram**
![ListAllUsers sequence diagram](https://github.com/mariammakram/Online_Store_Platform/blob/master/Sequence%20Diagram/ListAllUsers.PNG)
*  **Sign In Sequence Diagram**
![signIn sequence diagram](https://github.com/mariammakram/Online_Store_Platform/blob/master/Sequence%20Diagram/Sign%20In%20Sequence%20Diagram.PNG)

## Authors
* **Marriam Makram**  - [mariammakram](https://github.com/mariammakram)
* **Yasser Ashraf**  - [YasserAshraf12](https://github.com/YasserAshraf12)
* **Lauren Safwat**  - [lauren-safwat](https://github.com/lauren-safwat)
* **Leenah Essam**  - [Leenahessam](https://github.com/Leenahessam)


## Github
* **Github Repository**  - [Repository Link]()

## How to use?

### Utility Packages and Classes
* <code>src\main\java\com\SWEII\Controllers\UsersControllers</code> This Package includes all web services used in this platform. And includes these classes:
    * Admin Api Controller
    * Normal User Api Controller
    * Store Owner Api Controller
    * User Api Controller
    
* <code>src\main\java\com\SWEII\Models\UsersModels</code>
Includes all related data to any Actor deals with this platform <b>NormalUser</b>, <b>Administrator</b>, and <b>Store Owner</b>.
   
* <code>src\main\java\com\SWEII\Repositories\UsersRepositories</code>
This Package includes Interfaces, inherited from CrudRepository. They contain methods related to platform's users that needed by web services.

* <code>src\main\java\com\SWEII\Services\UsersServices</code>
This package includes Classes and Interfaces including all services needed by the platform's users.

* <code>src\main\java\com\SWEII\Validators</code>
Used to validate most of program's input.

### Build
  * <code>pom.xml</code>
     * Maven POM - notice short it is - Spring Boot does most of the work.
       
       
 

