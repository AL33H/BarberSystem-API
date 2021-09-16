# BarberSystem-API




# Tecnologias
- Project: Maven
- Language: Java 11
- Spring-boot: Versão 2.5.4
- Banco de dados: H2-test, PostgreSQL-dev/prod


# Iniciar Aplicação

1. Selecione o diretório abra o CMD, e insira;

```xsdregexp
git clone https://github.com/AL33H/BarberSystem-API.git
```
2. Após Clonar o diretório, insira o comando para iniciar a API localmente;

```xsdregexp
mvn spring-boot:run 
```

3. Para acessar a documentação Swagger, <a href="http://localhost:8080/swagger-ui.html">http://localhost:8080/swagger-ui.html </a>




# Configuração banco de dados

Atualizar valor em ```application-dev.properties``` com os valores da sua configuração do banco de dados postgreSQL.

```
spring.datasource.url=jdbc:postgresql://localhost:5432/${DATABASE_NAME}
spring.datasource.username=${USER_NAME_DB}
spring.datasource.password=${PASSWORD}
```

Em ```application.properties``` atualizar valor de, ```spring.profiles.active=test``` para ```spring.profiles.active=dev```



