# REVENDA DE VEÍCULOS 🚗
FASE 1 - TECH CHALLENGE CURSO SOAT – PÓSTECH

Esta aplicação é resultado de um TECH CHALLENGE do curso de pós-graduação em Arquitetura de Software, oferecido pela FIAP. O objetivo principal é desenvolver uma API voltada para a revenda e gerenciamento de veículos.

O projeto foi implementado em Java, utilizando o framework Spring, e o banco de dados escolhido foi o PostgreSQL. Além disso, empregamos o Docker para criar, executar e gerenciar os containers, garantindo uma infraestrutura eficiente e escalável.
Os serviços disponíveis são:

 - Cadastrar veículo
 - Atualizar veículo
 - Vender veículo
 - Listar veículos para venda
 - Listar veículos vendidos

[Link para a documentação](https://miro.com/app/board/uXjVMgT-ogo=/)

## INSTALAÇÃO

1. Clonar o repositório para a maquina local utilizando o comando:

	     git clone https://github.com/renanfe/revenda-veiculos.git

2. Acessar a pasta ./docker onde está localizado o arquivo docker-compose.yml
3. Rodar o comando a seguir para que seja criado os containers:

         docker compose up




## COMO USAR

As chamadas devem ser feitas para o localhost, utilizando a porta 8080 (localhost:8080). A coleção com as chamadas está disponível no postman [clicando aqui.](https://www.postman.com/cloudy-crescent-220434/fiap-modulo1/collection/9844450-6446375a-1965-46c8-b179-925fb9885156)

 ### Criar veiculo 
 **POST:** localhost:8080/api/v1/veiculos
 
 [Open request](https://www.postman.com/cloudy-crescent-220434/request/9844450-7fd24b14-b159-4d38-9307-0c4bd479761a)
 
Request body (json):
```json
{
  "marca": "Volkswagen",
  "modelo": "fusca",
  "ano": 1988,
  "cor": "PRETO",
  "preco": 5999.00
}
```

###  Atualizar veiculo
**PUT:** localhost:8080/api/v1/veiculos/<ID_VEICULO>

[Open request](https://www.postman.com/cloudy-crescent-220434/request/9844450-c7e227ce-4dc6-4bde-823d-da41b255dc35)

Request body (json):

```json
{
  "marca": "Volkswagen",
  "modelo": "t-cross",
  "ano": 2023,
  "cor": "BRANCO",
  "preco": 10001.00
}
```

###  Vender veiculo
**PUT:** localhost:8080/api/v1/veiculos/<ID_VEICULO>/vender

[Open request](https://www.postman.com/cloudy-crescent-220434/request/9844450-8984eec4-06f7-41c6-8232-597325697622)

Request body (json):

```json
{
  "cpfCliente": "35335335335"
}
```

###  Listar veiculos para venda
**GET:** localhost:8080/api/v1/veiculos/venda

[Open request](https://www.postman.com/cloudy-crescent-220434/request/9844450-7f0be942-9243-420f-a088-1681c116dcbf)

### Listar veiculos vendidos
**GET:** localhost:8080/api/v1/veiculos/vendidos

[Open request](https://www.postman.com/cloudy-crescent-220434/request/9844450-6507555e-8020-470d-aa23-7403cc8fd6c2)

