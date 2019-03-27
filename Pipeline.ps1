$cp = ".;C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib\servlet-api.jar"
$cp += ";.\WEB-INF\lib\gson-2.8.5.jar"

javac .\WEB-INF\src\HelloWorld.java -cp $cp -d .\WEB-INF\classes -target 8
jar -cf myApp.war * 

robocopy . "C:\Program Files\Apache Software Foundation\Tomcat 9.0\WebApps" *.war