FROM eclipse-temurin:17

LABEL mentainer="vikashkumariota@gmail.com"

WORKDIR /app

COPY target/springboot-docker-demo-0.0.1-SNAPSHOT.jar /app/springboot-docker-demo.jar

ENTRYPOINT ["java", "-jar","springboot-docker-demo.jar"]


#docker hamesa from se start hota hai
#label ka kam hai meta data difine karna ye history rakha hai kisne ye docker image create kiya
#workDir iska kam hai /app location pr iamge abnega
#Entrypoint ka kam hai docker jar ko run karna

# docker build -t springboot-docker-demo . ye coomand build ke liye use hota hai -t mtlab tag . mtlb current working directory
#docker images   esse hm local mai check kar sakte hai docker image
# docker build -t springboot-docker-demo:0.1.RELEASE .     hm khud ka tag de sakte hai
#docker run -p 8080:8080 springboot-docker-demo       ye dokar container run krne ke liye hai
#docker ps  check krne ke liye docker container run ho raha hai ya nahi
#docker run -p 8080:8080 -d springboot-docker-demo       -d deteched mode background mai run krne ke liye use krte hai
# docker logs -f aa90      ye docker kcontainer ka logs dekhne ke liye hai
#docker stop aa90    ---docker container ko stop krne ke liye
#docker login     ye jab docker hub pr push krte hai to login karna parta hai
#docker tag springboot-docker-demo javaguides/springboot-docker-demo:0.1.RELEASE  ye local se remote pr bhejne ke liye
#docker push javaguides/springboot-docker-demo:0.1.RELEASE     ye push krne ke liye
#docker run -p 3307:3306 --name mysql-container -e MYSQL_ROOT_PASSWORD=Mysql@123 -e MYSQL_DATABASE=employee_db -e MYSQL_USER=ramesh -e MYSQL_PASSWORD=ramesh -d mysql:latest   -mysql container run karne ke liye
#mysql -u root -p   ye mysql run kr raha check karne ke liye
#docker network create springboot-mysql-net    ---docker network create karne ke liye
#docker network ls    --docker network list dekhne ke liye
#docker run --name mysqldb --network springboot-mysql-net -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=employeedb -d mysql    docker container network mai run krne ke liye
#docker exec -it 8caa bash     ---bash mode mai run krne ke liye
#mysql -u root -p
#docker run --network springboot-mysql-net --name springboot-mysql-container -p 8080:8080 springboot-docker-demo --ye command mysql or springboot application run krne ke liye
#docker-compose up
#docker compose down