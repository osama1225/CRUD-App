# CRUD-App
A template Java CRUD app that provides CRUD operations for items stored in a DB either via direct access from browser or via web service calls.

## App info:
- This project uses Spring MVC as the web development framework(V4.3.0) along with Hibernate(V5) for accessing the data stored in MYSQL database.
- It uses Ant to generate the .classes files and to deploy it into apache tomcate.
- Two properties files are provided, global-config.properties and local-cofing.properties. The local-config.properties file overrides the global-config.properties file.
  - The idea is to define all the keys in global-config file, and provide your custom values in local-config file.
  - Ex: the default database driver used is mysql, if you need to use oracle driver, you can override the key in local.config file.
- Configuration of database is done in persistance-config.xml, with params read from properties files.
- the contextConfigLocation file  is context-all.xml, where i imported all the xml files needed to be loaded in the context as system startup.
- For this template app, ItemModel.java represents the item table defined in the MySQL database.
- I separated the internal model used in the daos/service layers (ItemModel.java) from the one that used in the controller, webservices, and views(ItemDTO.java).
- A populator is used to map the fields from the internal model to the view model.

## How to use:
- download the repo.
- import the project as java project into Eclipse IDE
- provide your values to the keys defined in local-config.properties.
- if you are going to use the same model repsented in the files (ItemModel.java), make sure to create the actual table first in the database.
- if you will define your own item, make sure of the following:
  * create your new item in the database.
  * create the model.java class in package:hibernate.models.
  * define the hibernate mapping file in the location web/WEB-INF/resources/com/crud/hbm/<your_Model_class_name>.hbm.xml. Inside that file make something similar to the committed ItemModel.hbm.xml or whatever it needs to tell hibernate how to map the table columns from your database table to the fields defined in your model.java file
  * create DTO.java for your new model, define what attributes you need.
  * change the populator to make your own mapping from the your new model to new DTO objects.
