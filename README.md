
ciandt Backend Test
-----------------------------------------------------------------------------------------
A proposta do desafio é a criação de uma API RESTful, para gerir dados de
armazenamento e estoque de um depósito de bebidas. Atualmente o estoque é
responsável por armazenar dois tipos de bebidas (alcoólicas e não alcoólicas), contudo,
isto pode mudar no futuro. O estoque possui 5 seções e cada seção só pode armazenar
um tipo de bebida, isto é, não é possível armazenar ou manter bebidas alcóolicas e não
alcoólicas juntas.

Cada seção possui capacidade de armazenamento de 500 litros de bebidas alcoólicas e
400 de não alcoólicas.

A API deve ser responsável por gerenciar
-----------------------------------------------------------------------------------------
1. Cadastro e consulta das bebidas armazenadas em cada seção com suas
respectivas queries.
2. Consulta do volume total no estoque por cada tipo de bebida.
3. Consulta dos locais disponíveis de armazenamento de um determinado volume
de bebida. (calcular via algoritmo).
4. Consulta das seções disponíveis para venda de determinado tipo de bebida
(calcular via algoritmo).
5. Cadastro de histórico de entrada e saída de bebidas em caso de venda e
recebimento.
5. Consulta do histórico de entradas e saídas por tipo de bebida e seção.

As seguintes regras devem ser respeitadas no fluxo de cadastro e cálculo
-----------------------------------------------------------------------------------------
1. Uma seção não pode ter dois ou mais tipos diferentes de bebidas (como já fora
dito)
2. Não há entrada ou saída de estoque sem respectivo registro no histórico.
3. Registro deve conter horário, tipo, volume, seção e responsável pela entrada.
4. Uma seção não pode receber bebidas não alcoólicas se recebeu alcoólicas no
mesmo dia. Ex: Seção 2 começou o dia com 50 litros de bebidas alcoólicas que
foram consumidas do estoque, só poderá receber não alcoólicas no dia seguinte.
5. O endpoint de consulta de histórico de entrada e saída de estoque, deve retornar
os resultados ordenados por data e seção, podendo alterar a ordenação via
parâmetros.
6. Para situações de erro, é necessário que a resposta da requisição seja coerente
em exibir uma mensagem condizente com o erro.

Technologies used
-----------------------------------------------------------------------------------------
Java 8, Gson, MongoDB  3.6, Spring Boot

Settings and notes
-----------------------------------------------------------------------------------------
Add the database in MongoDB:

drink_store

Add the collections in MongoDB:

1. drink
2. drink_type
3. history
4. section
5. storage
6. user

Call the endpoint:

localhost:8080/storage/set_up

Endpoints to drink
-----------------------------------------------------------------------------------------

1. [GET] localhost:8080/drink/{name}
2. [GET] localhost:8080/drink/list
3. [POST] localhost:8080/drink/add

Param: {"name": "agua", "price": 2.50, "nao alcoolicas"}

Endpoints to drink type
-----------------------------------------------------------------------------------------

1. [GET] localhost:8080/drink_type/{name}
2. [GET] localhost:8080/drink_type/list
3. [POST] localhost:8080/drink_type/add

Param: {"name": "nao alcoolicas", "capacity": 400.0}

Endpoints to history (Pending: implement sorting type)
-----------------------------------------------------------------------------------------

1. [GET] localhost:8080/drink_type/list

Endpoints to section
-----------------------------------------------------------------------------------------

1. [GET] localhost:8080/section/{name}
2. [GET] localhost:8080/section/list
3. [POST] localhost:8080/section/add

Param: {"name": "section 1"}

Endpoints to storage (Pending: implement list by drink type and some validations)
-----------------------------------------------------------------------------------------

1. [GET] localhost:8080/storage/set_up
2. [POST] localhost:8080/storage/buy
3. [POST] localhost:8080/storage/sell

Param: {"drink": "agua", "drink_type": "nao alcoolicas", "section": "section 1", "user": "jhon doe", "volume": 50}

Endpoints to user
-----------------------------------------------------------------------------------------

1. [GET] localhost:8080/user/{name}
2. [GET] localhost:8080/user/list
3. [POST] localhost:8080/user/add

Param: {"name": "jhon doe"}
