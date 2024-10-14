# Use uma imagem do Maven para construir o projeto
FROM maven:3.8.7-openjdk-18-slim AS build
WORKDIR /app

# Copie o pom.xml e o código-fonte
COPY pom.xml ./
COPY src ./src

# Construa a aplicação, pulando os testes
RUN mvn clean package -DskipTests

# Use uma imagem leve do JDK para executar a aplicação
FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/target/gembasqb-0.0.1-SNAPSHOT.jar gembasqb.jar
ENTRYPOINT ["java", "-jar", "gembasqb.jar"]
