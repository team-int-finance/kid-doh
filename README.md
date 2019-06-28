![README Header](https://github.com/team-int-finance/kid-doh/blob/master/src/main/resources/static/images/kiddohheader.png)
> the place where kids learn to control their dough :-)

## Summary
> The kid-doh application is a full featured finance application designed to teach the children how to handle their money wisely. Features include all of the ones you would expect from a finance application with a kid-doh twist.

## Setting Up

 How to get and set up our app:
 
 * From our GH [repository](https://github.com/team-int-finance/kid-doh) copy the link under the clone or download button.
 * In your command line terminal go to whatever directory you want to the app to be in.  
     * `git clone <paste in copied link here>`
     * `cd kid-doh`
 * Set up postgres on your machine.
    * Follow instructions for your operating system to install and set up postgreSQL.
    * in the termninal run `psql`
        * If you get an error that the database does not exist, you may have to run this command: 
            * from the terminal: `createdb <your username>` (this will create a default DB for your username)
            * `psql <your username>` (this will get you into psql logged into that DB)
            * from inside the psql app - `CREATE DATABASE kid-doh;`
            * `\c kid-doh` (this will get you logged into the kid-doh database. (Don't worrry about creating tables, the app will do all that for you.)
 * Set up environment variables for your PSQL database.
    * `export DATABASE_URL=<your database url>` (if running locally its probably "jdbc:postgresql:/localhost:5432/kid-doh"
    * `export DATABASE_USERNAME=<your database username>`
    * `export DATABASE_PASSWORD=<your database password>`
 * You should now have the app downloaded into your file-system.  Use the following commands to interact with it:
    * `./gradlew build` to do an initial build of the app.
    * `./gradlew test` to run the test suite.
    * `./gradlew bootRun` to run the app.
    * Once it is running you can go to `http://localhost:5000` to see the app in all its glory.

## How to Use Kid-Doh!
 * After successfully running the application, user would land into the login page as shown below :
  ![Home page](https://github.com/team-int-finance/kid-doh/blob/master/src/main/resources/static/images/homePage.png)
 
 * User can sign up for the application if they already don't have an account. User need to provide unique username and password. Sign up page is as shown below:
  ![Sign up page](https://github.com/team-int-finance/kid-doh/blob/master/src/main/resources/static/images/signUp.png)
 
 * After successfully registering for application or if user already had an account, after logging in user would land into accounts page which is as shown below:
  ![My account page](https://github.com/team-int-finance/kid-doh/blob/master/src/main/resources/static/images/myAccount.png)
 
 * Upon clicking add account, user would be taken to account/add page where user can create an account as shown below:
  ![Add account](https://github.com/team-int-finance/kid-doh/blob/master/src/main/resources/static/images/addAccount.png)
    
 * User can input name for the account, select either "checking/savings" as an account type and input balance amount for that account. Upon successfully creating an account user would be routed back to account page as shown below:
  ![Add account successful](https://github.com/team-int-finance/kid-doh/blob/master/src/main/resources/static/images/addedAccount.png)
 
 * User can now add transactions associated to account. User can add date for the transaction , select a category for it, select account if user have multiple accounts,  input amount for that transaction, then finally submit the transaction which will update the account balance and take user to accounts page as shown below: 
  ![Add transaction successful](https://github.com/team-int-finance/kid-doh/blob/master/src/main/resources/static/images/addedTransactions.png)
 
 * User can select "Deposit" from drop down menu in category, in order to make any deposits to the accounts. 
  ![Deposit](https://github.com/team-int-finance/kid-doh/blob/master/src/main/resources/static/images/deposit.png)
 
 * User can add multiple account as shown below:
 ![Multiple Account](https://github.com/team-int-finance/kid-doh/blob/master/src/main/resources/static/images/multiAccounts.png)
 
 * User can interact with edit and delete account button to preform respective actions. Upon user actions been successfully handled , user would be routed back to accounts page.
 
 * Upon clicking 'Dashboard' on the top of navigation bar, user would be routed to dash board page where graphical representation of data would be presented to user as shown below:
 ![graph](https://github.com/team-int-finance/kid-doh/blob/master/src/main/resources/static/images/graph.png)
 
## Architectural Design
   * Model View Controller design
    ![MVC](https://github.com/team-int-finance/kid-doh/blob/master/src/main/resources/static/images/mvc.png)

   * Data base design 
    ![Data base design](https://github.com/team-int-finance/kid-doh/blob/master/src/main/resources/static/images/database.png)

## Technologies Used
* Java
* Spring Boot
* Thymeleaf
* Amazon AWS
* BootStrap

## Versions
> Version 1.0 - Setup repo and added planning files.

## Authors
* **Saurav Kadariya** - *Initial work* - [skadariya](https://github.com/skadariya)
* **David Marchante** - *Initial work* - [dmarchante](https://github.com/dmarchante)
* **Robert Bronson** - *Initial work* - [rjbrons](https://github.com/rjbrons)
* **Charles Clemens** - *Initial work* - [CClemensJr](https://github.com/CClemensJr)

## License
> This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
