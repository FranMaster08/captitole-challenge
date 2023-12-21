# Usa una imagen de OpenJDK 17 como base
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado por Gradle a la imagen
COPY build/libs/cotizador-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que la aplicación se ejecuta
EXPOSE 8080

# Comando para ejecutar la aplicación al iniciar el contenedor
CMD ["java", "-jar", "app.jar"]
