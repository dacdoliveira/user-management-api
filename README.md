# user-management-api
Projeto implementando em JAVA utilizando os frameworks JPA + Hibernate e BD H2. 

Projeto foi implementado no Eclipse IDE, utilizando servidor wildfly (12) embarcado; 

A aplica��o usa BD H2 utilizando JPA. As configura��es de acesso ao BD est�o no arquivo persistence.xml na pasta META-INF, assim como propriedades necess�ria para o hibernate e mapeamento das classes "entities";

Foi configurado um mapeamento OneToMany/ManyToOne entre User e Phone;

O projeto foi implementado seguindo as seguintes "boas pr�ticas":
	Implementa��o em camadas: Service (Endpoints), Bean (Neg�cio) e Repository (M�todos de acesso  ao BD);
	Al�m da divis�o em camadas, os pacotes foram divididos entre interface e implementa��o;
	Foi utilizado padr�o de projeto DTO para facilitar forma de usar um dos end-points necessitanto o m�nimo de informa��o poss�vel;
	Para tratamento de erro, foi criado um objeto que encapsula o RuntimeException, viabilizando captura do erro espec�fico e devido tratamento;
	
	

Foram implementados 8 endpoints na classe UserService:
1- USER SAVE (/save): 
	Recebe o objeto User com os devidos atributos (sem id, que � gerado no BD) 
2- USER GET BY ID (/get-by-id):
	Recebe como par�metro id, retorna o obejto User completo.
3- USER UPDATE (/update)
	Recebe objeto User (incluindo seu id, a lista de Phones com seus respectivos ids). Este servi�o atualiza tanto USER quanto seu(s) phone(s).
	Neste servi�o � feita uma valida��o e caso n�o exista o id do user, � devolvida uma mensagem informativa e status BAD REQUEST 
4- USER DELETE BY ID (/delete-by-id):
	Recebe id do user que deseja remover
5- PHONE SAVE (/phone-save)
	Recebe objeto PhoneDto, com os atributos de phone e apenas o id do usu�rio.� feita uma valida��o e caso o id n�o seja de nenhum usu�rio cadastrado, uma mensagem � devolvida
6- PHONE DELETE BY ID (/phone-delete-by-id)
	Recebe o id do phone que se deseja deletar
7- USER LIST
	Retorna todos os usu�rios (incluindo seus id's) e suas listas de telefones tamb�m com seus id's
8- USER GET BY NAME
	Recebe nome como par�metro e retorna o respectivo usu�rio
	
Para valida��o dos endpoints foi utilizada ferramenta POSTMAN, para facilitar, foi gerado um collection dispon�vel na ra�z do projeto. Essa collection cont�m as configura��es de todas
8 requisi��es espec�ficadas acima
  
