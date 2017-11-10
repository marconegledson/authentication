## Authentication

#### Introdução

Sistema para teste de autenticação utilizando o spring boot como gerador de token via client

#### Exemplos de utilizacao

O propósito do projeto é ser um rest de leitura que será consumido por qualquer cliente. Exemplos das chamadas:


**[GET] http://localhost:8080/home** 
**[POST] http://localhost:8080/login** com raw {"username":"admin", "password":"password"}
**[GET] http://localhost:8080/users** com header Authorization 


