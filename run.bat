@echo off
set JAVA_HOME=C:\Program Files\Java\jdk-17
set PATH=%JAVA_HOME%\bin;C:\Users\Alumno\Downloads\apache-maven-3.9.6\bin;%PATH%
cd /d "%~dp0"
mvn spring-boot:run
pause
