W wypadku komunikatu 
```shell
Error occurred during deployment: Exception while deploying the app [EnterpriseApp-ear-1.0-SNAPSHOT] : Could not find sub module [lab-EnterpriseApp-war-1.0-SNAPSHOT.war] as defined in application.xml.
```

z katalogu ```/glassfish/domains/domain1/applications``` usunąć plik ```EnterpriseApp.ear```, a następnie zbudować projekt ponownie.
