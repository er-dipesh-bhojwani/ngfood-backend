@echo off
setlocal

echo ==========================================
echo 🚀 Starting NGFOODS Application
echo ==========================================

:: Step 1 - Check if Docker Desktop is running
echo Checking if Docker is running...
docker info >nul 2>&1
if errorlevel 1 (
    echo 🐋 Docker is not running. Launching Docker Desktop...
    start "" "C:\Program Files\Docker\Docker\Docker Desktop.exe"
    echo Waiting for Docker to start...
    :waitfordocker
    docker info >nul 2>&1
    if errorlevel 1 (
        timeout /t 5 >nul
        goto waitfordocker
    )
)
echo ✅ Docker is running!

:: Step 2 - Run docker compose
echo 🧱 Starting containers...
docker compose up -d

:: Step 3 - Wait until frontend (port 3000) is reachable
set PORT=3000
echo ⏳ Waiting for frontend to become ready on port %PORT%...

:waitforfrontend
powershell -Command "(Invoke-WebRequest -UseBasicParsing http://localhost:%PORT%)" >nul 2>&1
if errorlevel 1 (
    timeout /t 5 >nul
    goto waitforfrontend
)
echo ✅ Frontend is ready!

:: Step 4 - Open the app in browser
start "" "http://localhost:%PORT%"

echo 🌐 NGFOODS App is up and running!
endlocal