[Primeiro desafio - Google Colab](https://colab.research.google.com/drive/1n4s36CIBO7L7ZBoiX8na6FvHZRLzI9lM#scrollTo=e0x0XU5hv8d4)

---

## Segundo desafio - Crud

Voce pode executar o projeto utilizando o Java 21 com Maven:

```bash
mvn spring-boot:run
```

Url da API:

`http://localhost:8080/api/v1/cars`

O projeto está dividido em três branches: a master, que utiliza o banco de dados H2 para testar o funcionamento da API; e as outras duas branches, que usam o MongoDB e o PostgreSQL. Para utilizá-las, primeiro inicie os containers com o Docker Compose.

```bash
cd Docker
docker-compose up
```
