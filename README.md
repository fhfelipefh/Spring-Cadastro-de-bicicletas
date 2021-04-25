<p align="center"><img src="img\logo2.png"></p>
<p align="center">
<smallUma API para controlar o cadastro de bicicletas, essa API foi construida na linguagem Java utilizando o Framework Spring :smile:</small> 
</p> 
<hr>

**- Cadastrar bicicletas :heavy_check_mark:**

**- Listar bicicletas :heavy_check_mark:**

**- editar preço :heavy_check_mark:**

**- Deletar bicicletas :heavy_check_mark:**

**- Tests :heavy_check_mark:**  

## Você pode fazer um teste de conexão utilizando o endereço:

https://bikerg.herokuapp.com/bikes
<p>
Se o servidor estiver em operação verá uma página web com a mensagem "Hello, World!", a API está hospedada remotamente na plataforma Heroku que pode ser acessada em https://heroku.com 
</p>
<img src="img\helloworld.JPG">
<hr>

## Como cadastrar uma bicicleta?

<p>
Você pode utilizar o software https://www.postman.com/ para enviar uma requisição em formato JSON usando o método POST com base no formato abaixo e na URL da API.
</p>
<p>
URL da API: https://bikerg.herokuapp.com/bikes/
</p>    

JSON:
```
{
    "description": "Bicicleta verde com listras brancas",
    "model": "Monark",
    "price": 999,
    "name_of_the_store_where_you_bought_it": "Hero",
    "purchase_date": "1999-04-03",
    "buyer_name": "jack"
}
```
<p> 
Se obter sucesso na requisição verá algo como na imagem, anote o valor do campo ID que é necessario para checar um campo individualmente. 
</p>
<p>
<img src="img\postjson.PNG"> 
</p>
<p>
Note o status 201 Created indicando sucesso na requisição feita.     
</p>


