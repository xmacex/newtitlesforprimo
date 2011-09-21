JAVACLASSES = "/usr/share/java/axiom-api.jar:/usr/share/java/axiom-impl.jar:/usr/share/java/httpclient.jar:/usr/share/java/httpcore.jar:/usr/share/java/log4j-1.2.jar:/usr/share/java/servlet-api-2.5.jar:/usr/share/java/jdom1.jar:/usr/share/java/xalan2.jar:../lib/harvester2.jar"

default:
	javac -classpath $(JAVACLASSES) HarvestNewTitles.java

%.class: %.java
	javac -classpath $(JAVACLASSES) $<
