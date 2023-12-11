@echo off

echo Building the project...

.\gradlew build

set BUILD_RESULT=%errorlevel%

if %BUILD_RESULT% neq 0 (
    echo Error: Build failed. Exiting.
    exit /b %BUILD_RESULT%
)

set JAR_FILE=build/libs/YourPluginName-1.0-SNAPSHOT.jar
set DESTINATION=C:\Users\sande\Desktop\SSMP5\plugins

echo Copying %JAR_FILE% to %DESTINATION%...

copy %JAR_FILE% %DESTINATION%

echo Done!