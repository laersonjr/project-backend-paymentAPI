<h1 align="center">🚀 Back-end challenge - PaymentAPI</h1>

<h1 align="center">🎯 Sobre o projeto</h1>
O projeto é capaz de criar wallets realizando validações de acordo com a regra de negócio solicitada, permitindo realizar os devidos pagamentos obedecendo o limite disponível e limite de pagamento diário.

<h1 align="center">📦 Desenvolvimento</h1>
Realizado com framework SpringBoot em Java 11, gestor de dependência com Maven - uso de DevTools para agilidade durante a produção de desenvolvimento. Hibernate e JPA para persistir os dados no banco de dados MySQL, Lombok para perfomance e diminuir boiler plate code. Auxílio do ModelMapper para criação do DTO. Além disso, foi utilizado do FlyWay para executar os scripts responsáveis por criar as tabelas no banco de dados, além de manter um histório de versões.

<h1 align="center"> 💻 Requisitos de inicialização do projeto</h1>

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento.

### 📋 Pré-requisitos

De que coisas você precisa para instalar o software e como instalá-lo?

- [Maven](http://maven.apache.org)
- [JDK version 11](https://www.oracle.com/java/technologies/downloads/)

<h1 align="center">📍 Rodando a aplicação</h1>

```
 Clone este repositório
    Via terminal: 
      1- Navegue até a pasta desejada.  
      2- Clonar o projeto através do comando: git clone https://github.com/laersonjr/project-java-with-spring-PaymentAPI.git
 
 Execução do porjeto:
      Via terminal: Se estiver utilizando do Maven realizar o seguintes comandos: mvn install, mvn clean package e por fim javac -nomedoprojeto.jar, o servidor iniciará na porta:8080 - acesse http://localhost:8080
      Via IDE: Apenas faz necessário abrir o projeto através do diretório onde foi disponibilizado os arquivos.
      
      Para ambas as situações, se faz necessário configurar o application.properties, disponível no seguinte caminho: project-java-with-spring-PaymentAPI/src/main/resources/application.properties
        spring.jpa.database= (Bando de dados utilizado, nesse projeto foi utilizado MySql)
        spring.datasource.url= (URL do banco de dados)
        spring.datasource.username= (Login para conexão ao banco)
        spring.datasource.password= (Password para conexão com o banco)
      Podemos seguir como exemplo as informações contidas no projeto.
 
``` 

<h1 align="center">✔️ Vericando projeto ON</h1>

A tela da sua aplicação deve estar:
![projeto on](https://user-images.githubusercontent.com/58311661/177229745-c7f5a5da-a68b-4187-8542-e4353aab9251.png)


<h1 align="center">🔨 Funcionalidades do projeto </h1>

- `Funcionalidade 1` `listarWallet`: Lista todas as wallets criadas.

- `Funcionalidade 2` `criarWallet`: Cadastra uma wallet com suas devidas informações no sistema.
 
- `Funcionalidade 3` `availableLimit`: Verifica limite disponível.

- `Funcionalidade 4` `makePayment`: Realiza pagamento.


<h1 align="center">🧩 Consumindo API </h1>




<h3> CURL - Wallets</h3>

```
curl --location --request GET 'localhost:8080/wallets'

```
![getwallets](https://user-images.githubusercontent.com/58311661/177229930-235affbe-2739-40e2-b1fc-9eebd6c96d8b.png)

<h3> CURL - Criar Wallet</h3>

```

curl --location --request POST 'localhost:8080/wallets' \
--header 'Content-Type: application/json' \
--data-raw '{
    "ownerName" : "Criar novo Wallet Recurso"
}'

```
![criandoWallet](https://user-images.githubusercontent.com/58311661/177230380-a1e08de1-b2af-423b-88ea-47ecd8593481.png)

![ValidandoEntradaWallet](https://user-images.githubusercontent.com/58311661/177230435-21f18e8e-3245-4b33-8fbf-1d3805db4a6d.png)

<h3> CURL - Limite disponível</h3>

```
curl --location --request GET 'localhost:8080/wallets/"walletId"/limits'


```
![walletIdsucess](https://user-images.githubusercontent.com/58311661/177230066-06541281-1f5a-4508-a33b-7afd1803a97f.png)

<h3> CURL - pagamento</h3>

```

curl --location --request POST 'localhost:8080/wallets/bf90d11d-84df-4ab1-8723-acc206c931f6/payments' \
--header 'Content-Type: application/json' \
--data-raw '{
     "amount": 50,
     "date": "2022-07-09"

}'

```
![pagamentoRealizado](https://user-images.githubusercontent.com/58311661/177231948-f22400c9-442c-4c35-9120-3d5041658bfd.png)

![pagamentolimitediario](https://user-images.githubusercontent.com/58311661/177232174-09f27be0-f935-4825-9088-ae1664fabd99.png)

![limiteinsuficiente](https://user-images.githubusercontent.com/58311661/177232203-d005cc99-3d4b-41b5-9b26-e8b6485312b1.png)


<h1 align="center">🛠️ Construído com as tecnologias  </h1>


* [Springboot](https://spring.io/projects/spring-boot)
* [Maven](http://maven.apache.org) 
* [Lombok](https://projectlombok.org/download) 
* [ModelMapper](http://modelmapper.org/) 
* [FlyWay](https://flywaydb.org/)
* [MySQL](https://dev.mysql.com/downloads/workbench/)
* [DevTools](https://www.quickdev.org/?gclid=Cj0KCQjwsdiTBhD5ARIsAIpW8CLGWx99TFjAY-Xgu5fSe-Kno98jVPCa0ZxdyOvnbCZT3bDrFZgbxF0aAs3sEALw_wcB)

<h1 align="center">📚 Features em desenvolvimento</h1>

- [ ] Docker
- [ ] Deploy Cloud
- [ ] TDD JUnit
- [ ] Funcionalidade : Depositar
- [ ] Funcionalidade : Verificar regra para pagamentos em horários e dias de acordo com a regra de negócio.
</div>
