function add_fields() {
    document.getElementById('wrapper').innerHTML += "<br><br><label for = 'ingredientName'></label><p>Ingredient Name: <br><input id = 'ingredientName' type = 'text' name='ingName'></p><label for = 'ingredientDescription'></label><p>Ingredient Description: </p><textarea id = 'ingredientDescription' type = 'text' name = 'ingDesc'></textarea>";
}