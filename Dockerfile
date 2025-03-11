#FROM eclipse-temurin:21-jdk-alpine
#EXPOSE 8080
#COPY ./target/tournamentTkd-0.0.1-SNAPSHOT.jar tournament.jar

#ENTRYPOINT ["java", "-jar", "/tournament.jar"]

# Paso 1: Usar Ubuntu como base
FROM ubuntu:latest

# Paso 2: Instalar actualizaciones del sistema y dependencias necesarias
RUN apt-get update && apt-get upgrade -y && \
    apt-get install -y \
    openjdk-21-jdk \
    maven \
    curl \
    git \
    ca-certificates \
    && apt-get clean

# Paso 4: Copiar el proyecto al contenedor (todo el código fuente)
COPY . .

# Paso 5: Ejecutar mvn clean install para compilar el proyecto
RUN mvn clean install

# Paso 7: Copiar el JAR generado y ejecutar la aplicación
# Este paso asume que el JAR generado se encuentra en ./target/tournamentTkd-0.0.1-SNAPSHOT.jar
# Puedes ajustar el nombre si es diferente
RUN cp ./target/tournamentTkd-0.0.1-SNAPSHOT.jar /tournament.jar

# Paso 8: Establecer el comando de entrada para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "/tournament.jar"]
