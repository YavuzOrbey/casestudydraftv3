

function removeAllChildNodes(parent) {
    while (parent.firstChild) {
        parent.removeChild(parent.firstChild);
    }
}

function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

function filterFunction() {
    let input, filter, ul, li, a, i;
    input = document.getElementById("myInput");
    ul = document.getElementById("results");
    removeAllChildNodes(ul)

    if(input.value.length >= 3){
        //get the value of the input and check it against the database
        axios.get("/api/ingredient?q=" + input.value)
        .then(function(response){
            let results = response.data;
            for(let i =0; i<results.length; i++){
               let li = document.createElement("LI");
               let ingredient = results[i];
               li.innerHTML = ingredient.name;
                   let button = document.createElement("BUTTON");
                       button.addEventListener("click", function(){
                            let div = document.createElement("DIV");
                            div.innerHTML = `<label>${ingredient.name}</label>
                             <input class='form-control' type="number" data-ingredient-id="${ingredient.id}" name="ingredients" placeholder="value"/>
                             <p>${measurements}</p>`;
                            document.getElementById("ingredients").appendChild(div);
                       })
               button.innerText="ADD";
               li.appendChild(button);
               ul.appendChild(li);
            }
          });
    }
}