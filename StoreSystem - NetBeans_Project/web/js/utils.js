/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function toggleElement(name) {
    var x = document.getElementById(name);
    if (x.style.display === 'none') {
        x.style.display = 'block';
    } else {
        x.style.display = 'none';
    }
}

function toggleSearchType() {
    var x = $("input[name='param']:checked").val();
    if (x === "articulo") {
        document.getElementById("searchBar").style.display = "block";
        document.getElementById("categories").style.display = "none";
    } else {
        document.getElementById("categories").style.display = "block";
        document.getElementById("searchBar").style.display = "none";
        getCategories();
    }
}

function searchProducts() {
    
    var searchType = $("input[name='param']:checked").val();
    
    if (searchType === "articulo") {
        var query = $("input[name='query']").val();
    } else {
        var query = $("select[name='query']").val();
    }
    
    
   fetch('/StoreSystem/search?q='+query+'&searchType='+searchType).then( response => {  
      if (response.status !== 200) {  
        console.log('Looks like there was a problem. Status Code: ' +  
          response.status);  
        return;  
      }

      // Examine the text in the response  
      response.json().then(data => {  
        displaySearchResults(data);
      });  
    }).catch(error => {  
        console.log('Fetch Error :-S', err);  
    });
}

function displaySearchResults(results = []) {
    
    $('#products').css( "display", "block" );
    $('#productsLabel').css( "display", "block" );
    $('#productsBody').html("");
    $('#productCount').html(results.length);
    
    
    results.forEach(result => {
        $('#productsBody').append('<tr><td>' + result.id + '</td><td>' + result.name + '</td><td>' + result.price + '</td><td>' + result.stock + '</td><td>' + result.category + '</td><td>' + result.description + '</td><td><a href="producto?action=ver&id=' + result.id + '" role="button">Ver Detalles</a></td></tr>');
    })
}

function getCategories() {
   fetch('/StoreSystem/categorias').then( response => {  
      if (response.status !== 200) {  
        console.log('Looks like there was a problem. Status Code: ' +  
          response.status);  
        return;  
      }

      // Examine the text in the response  
      response.json().then(data => {  
        displayCategories(data);
      });  
    }).catch(error => {  
        console.log('Fetch Error :-S', err);  
    });
}

function displayCategories(results = []) {
    $('#categories').html("<option value=''>Selecciona una categoría</option>");
    results.forEach(result => {
        $('#categories').append($('<option>', {value:result.name, text:result.name}));
    })
}

