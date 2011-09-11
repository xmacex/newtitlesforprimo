JAVACLASSES = "/usr/share/java/axiom-api.jar:/usr/share/java/axiom-impl.jar:/usr/share/java/httpclient.jar:/usr/share/java/httpcore.jar:/usr/share/java/log4j-1.2.jar:/usr/share/java/servlet-api-2.5.jar:../lib/joailib.jar"

default:
	javac -classpath $(JAVACLASSES) HarvestNewTitles.java

%.class: %.java
	javac -classpath $(JAVACLASSES) $<
