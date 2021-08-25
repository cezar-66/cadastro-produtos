let autoComplete = function(pag) {
    let search = document.getElementById('input-auto-complete').value;
    const url = 'autocomplete' + pag +'/?name=' + search;

    if(search.value !== ""){
        $.ajax({
            type: 'GET',
            url: url,
            success: function(response) {
                var listResponse = response;
                var responseJson = {};
                if(listResponse.length > 0){
                    listResponse.forEach(function (element){
                        responseJson[element.nome] = responseJson[element.nome];
                    });
                    $('input.autocomplete').autocomplete({
                        data: responseJson,
                        limit: 5,
                        onAutocomplete: function (data){
                            console.log(data)
                        }
                    });
                }
            }
        });
    }
}

