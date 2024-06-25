# Java Maven Hibernate Project

This repository contains a Java project configured with Maven and Hibernate for database operations. The project includes utility classes for managing entity persistence.

## Project Overview

This project demonstrates how to set up and use Hibernate with Maven in a Java application. The provided `HibernateUtil` class includes methods to initialize the `EntityManagerFactory`, obtain an `EntityManager`, and retrieve the primary key of an entity.

## Technologies Used

- **Java**: The core programming language used for the project.
- **Maven**: A build automation tool used for project management.
- **Hibernate**: An Object-Relational Mapping (ORM) framework for database operations.
- **JPA (Java Persistence API)**: A specification for accessing, persisting, and managing data between Java objects and a relational database.

## Project Structure

The main class `HibernateUtil` contains the following key components:

- **Initialization of EntityManagerFactory**: Creates an instance of `EntityManagerFactory` using the specified persistence unit.
- **EntityManager Retrieval**: Provides a method to get an `EntityManager` instance.
- **Primary Key Retrieval**: A utility method to get the primary key of a given entity.

### Code Snippet

```java
package posjavamavenhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	
	public static EntityManagerFactory factory = null;
	
	static {
		init();
	}
	
	private static void init() {
		try {
			if(factory == null) {
				factory = Persistence.createEntityManagerFactory("pos-java-maven-hibernate");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static Object getPrimaryKey(Object entity) {
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}

}
```

## How to Run

1. **Clone the repository**:
    ```sh
    git clone https://github.com/josivantarcio/CadastroJava-Maven_Hibernate.git
    ```
2. **Import the project into your IDE**: Open the project in an IDE that supports Maven.
3. **Configure the Database**: Ensure that your database is set up and configured properly in the `persistence.xml` file.
4. **Build the project**:
    ```sh
    mvn clean install
    ```
5. **Run the application**: Execute the main class or use the IDE's run configurations.

## Contact

For more information, please contact:

- **Jôsevan Tárcio Silva de Oliveira**
- [LinkedIn](https://www.linkedin.com/in/josevantarc/) 

## License

This project is licensed under the terms specified in the repository.
