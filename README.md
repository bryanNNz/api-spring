# Api Spring Boot
Trata-se de uma API construída utilizando Spring Boot.

## Principais Tecnologias
Java 8, Spring Boot, Spring Data, PostgreSQL, Jackson Annotations e Maven.

##Heroku
Link: http://api-spring-bryan.herokuapp.com/api/

## Configuração
Ressalto que nos passos de empacotamento, criação de imagem e inicialização do container é necessário estar na raiz do projeto **/api-spring**.

### Download
```
$ git clone https://github.com/bryanNNz/api-spring.git
```

### Empacotando projeto
```
$ mvn clean package -DskipTests
```
### Criando imagem
```
$ docker build -t api-spring .
```

### Iniciando container
```
$ docker-compose up
```