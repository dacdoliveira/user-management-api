# user-management-api
Projeto implementando em JAVA utilizando os frameworks JPA + Hibernate e BD H2. 

Projeto foi implementado no Eclipse IDE, utilizando servidor wildfly (12) embarcado; 

A aplicação usa BD H2 utilizando JPA. As configurações de acesso ao BD estão no arquivo persistence.xml na pasta META-INF, assim como propriedades necessária para o hibernate e mapeamento das classes "entities";

Foi configurado um mapeamento OneToMany/ManyToOne entre User e Phone;

O projeto foi implementado seguindo as seguintes "boas práticas":
	Implementação em camadas: Service (Endpoints), Bean (Negócio) e Repository (Métodos de acesso  ao BD);
	Além da divisão em camadas, os pacotes foram divididos entre interface e implementação;
	Foi utilizado padrão de projeto DTO para facilitar forma de usar um dos end-points necessitanto o mínimo de informação possível;
	Para tratamento de erro, foi criado um objeto que encapsula o RuntimeException, viabilizando captura do erro específico e devido tratamento;
	
	

Foram implementados 8 endpoints na classe UserService:
1- USER SAVE (/save): 
	Recebe o objeto User com os devidos atributos (sem id, que é gerado no BD) 
2- USER GET BY ID (/get-by-id):
	Recebe como parâmetro id, retorna o obejto User completo.
3- USER UPDATE (/update)
	Recebe objeto User (incluindo seu id, a lista de Phones com seus respectivos ids). Este serviço atualiza tanto USER quanto seu(s) phone(s).
	Neste serviço é feita uma validação e caso não exista o id do user, é devolvida uma mensagem informativa e status BAD REQUEST 
4- USER DELETE BY ID (/delete-by-id):
	Recebe id do user que deseja remover
5- PHONE SAVE (/phone-save)
	Recebe objeto PhoneDto, com os atributos de phone e apenas o id do usuário.É feita uma validação e caso o id não seja de nenhum usuário cadastrado, uma mensagem é devolvida
6- PHONE DELETE BY ID (/phone-delete-by-id)
	Recebe o id do phone que se deseja deletar
7- USER LIST
	Retorna todos os usuários (incluindo seus id's) e suas listas de telefones também com seus id's
8- USER GET BY NAME
	Recebe nome como parâmetro e retorna o respectivo usuário
	
Para validação dos endpoints foi utilizada ferramenta POSTMAN, para facilitar, foi gerado um collection disponível na raíz do projeto. Essa collection contém as configurações de todas
8 requisições específicadas acima
  
