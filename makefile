ejecutar:
	mvn compile assembly:single

javadoc:ejecutar
	mvn javadoc:javadoc
	
add:ejecutar
	java -jar target/Graph-1.0-SNAPSHOT-jar-with-dependencies.jar

mostrar:
	java -jar target/Graph-1.0-SNAPSHOT-jar-with-dependencies.jar map 0

delete:
	java -jar target/Graph-1.0-SNAPSHOT-jar-with-dependencies.jar delete 1

file:
	java -jar target/Graph-1.0-SNAPSHOT-jar-with-dependencies.jar 3 10