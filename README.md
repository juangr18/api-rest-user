# api-user-rest

#### Init app docker

1. Init create jar
   Run cmd in to terminal inside to project java

   mvnw clean install

2. Docker create container

   docker build -t <name-image> .

3. Run container in docker - port machinehost:containerdocker - example 80:8080

   docker run -it -dp 80:80 <name-image>

4. Open your browser

   localhost