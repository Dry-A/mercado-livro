# Bem-vindos ao meu MarketPlace de Livros - Projeto Spring Boot e Kotlin

### Tecnologias Utilizadas

* Spring v3.4.3👢
* Gradle 🐘
* Kotlin no Backend
* MySQL
* Spring Data
* Flyway
* Eventos
* Postman 👩🏼‍🚀
* Spring Security
* Testes Unitários com Mockk

### Reference Documentation

![codando](https://pixeljoint.com/files/icons/full/desktopoverlay.gif)

O projeto e estudo foi feito de fora para dentro.  ✅
Isso quer dizer que fiz primeiro fiz a model e todo o código na camada de Controller - praticamente fazendo na "mão" - depois fui organizando, retirando a lógica da controller e passando para a camada de Service.
Só então criei a camada de Repository, com métodos de busca e inserção no banco de dados mais específicos.

🟢 Escolhi o MySQL para o banco de dados, por ser um banco que já tenho mais familiaridade e por ser um banco que é muito utilizado no mercado. Porém usei uma imagem docker para subir o banco de dados, para não precisar instalar o MySQL na minha máquina.
Para isso funcionar é necessário ter o Docker instalado na máquina. No caso eu tenho o docker desktop.

No projeto eu uso o 📔Flyway para fazer a migração do banco de dados. O Flyway é uma ferramenta de migração de banco de dados de código aberto. 
Ele traz ordem e controle😮‍💨 para o processo de migração de banco de dados, permitindo que equipes de desenvolvimento colaborem de forma eficaz. É a primeira vez que uso o Flyway e achei muito interessante.
Ele é uma dependencia do projeto, 🐌 então não é necessário instalar nada na máquina. 

Basta rodar o projeto que ele cria a tabela de migração no banco de dados e faz a migração dos scripts que estão na pasta resources/db/migration.



### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)




![office](https://miro.medium.com/v2/resize:fit:2000/0*eIhVp0KXrXSSHORN.gif)


### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

![outro](https://media.tenor.com/IOrCj35JmewAAAAi/flossing-astronaut.gif)