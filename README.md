# <span style="text-align:center">kid-doh!</span>
> the best toy for teaching kids finance!

## Summary
> The kid-doh! application is a full featured finance application designed to teach the children how to handle their money wisely. Features include all of the ones you would expect from a finance application with a kid-doh! twist.

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
> Coming soon!

## Example
> Coming soon!

## Architectural Design
> Coming soon!

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