# RecipeWebsite
A Website where you can initialize CRUD operations and also Register/Login (Added BCrypt password Encryption)

MySQL Tables - 

  For Security : 
    1) Table name : users
        a) username varchar(50) pk nn
        b) password varchar(68) nn
        c) enabled tinyint(1) nn
        
    2) Table name : authorities 
        a) username varchar(50) nn (foreign key references "users" table column "username")
        b) authorities varchar (50) nn
        
    3) Table name : menu
        a) id int pk nn
        b) name varchar(50) nn
        
    4) Table name : ingredients
        a) id int pk nn
        b) ingredient varchar(50) nn
        c) description varchar(50) nn
        
    5) Table name : menu_ingredient (foreign keys for "menu" table and "ingredient" table)
        a) menu_id int (foreign key references "menu" table column "id")
        b) ingredient_id int (foreign key references "ingredients" table column "id")

Todo - 
  1) make website prettier (HTML/CSS/JS)
  2) add csrf protection
