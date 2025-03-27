Sistema Integrado de Gestão de Livros

Para instalar o sistema em questão basta ter a JDK 17 e o banco de dados MySQL (configurado no arquivo src/main/resources/application.properties). 
A base de dados será criada (caso não exista) atráves de migration no momento da execução. 
A APlicação está configurada para ser servida via Tomcat no endereço localhost:8080 porém isso também pode ser modificado no arquivo application.properties
