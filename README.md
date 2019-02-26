# RecipeWebsite
A Website where you can initialize CRUD operations and also Register/Login (Added BCrypt password Encryption)

MySQL Tables - 

  
    For Security : 
 
      1) Table name : users
          a) id int(11) pk nn ai
          b) username varchar(50)  nn
          c) password varchar(68) nn
          d) first_name varchar(50) nn
          e) last_name varchar (50) nn
          f) email varchar(50) nn

      2) Table name : role 
          a) id int(11) pk nn ai
          b) name varchar (50) nn
     
      3) Table name : users_role
          a) user_id int(11) NULL (Foreign key, references "users" Table's id)
          b) role_id int(11) NULL (Foreign key, references "roles" Table's id)
        
    For model :     
    
      1) Table name : menu
          a) id int pk nn
          b) name varchar(50) nn

      2) Table name : ingredients
          a) id int pk nn
          b) ingredient varchar(50) nn
          c) description varchar(50) nn

      3) Table name : menu_ingredient
          a) menu_id int (foreign key references "menu" table column "id")
          b) ingredient_id int (foreign key references "ingredients" table column "id")
          
      4) Table name : comments
          a) id int(11) pk nn ai
          b) comment varchar(255) NULL
        
      5) Table name : users_comments  
          a) user_id int(11) NULL (Foreign key, references "users" Table's id)
          b) comment_id int(11)   (Foreign key, references "comments" Table's id)

      6) Table name : menu_comments
          a) menupk_id int(11) NULL (Foreign key, refences "menu" Table's id)
          b) commentpk_id int(11) NULL (Foreign key, references "comments" Table's id) 

Todo - 
  1) make website prettier (HTML/CSS/JS)
  2) add csrf protection
