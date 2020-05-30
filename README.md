# Java Blog
### - Para rodar é necessário ter o MongoDB instalado e com banco local (https://docs.mongodb.com/manual/installation/)
### - O projeto utiliza Spring 2.3

Pequeno projeto de estudo de Java com Spring Boot e MongoDB, que consiste em sistema de blog com usuário, posts e comentários.
Funções implementadas:

[DONE] CRUD Usuários

[in progress] CRUD Posts

[todo] CRUD Comentários

Usando o <b>IntelliJ IDEA</b>:
<ul>
  <li>No terminal, rode o servidor mongo através do comando: `mongod`</li>
  <li>No IDEA, aperte o botão de "Play" `▶️`</li>
  <li>Observe em qual porta a aplicação irá rodar e digite no browser a rota correspondente encontrada no controller em `src/main/java/com/blog/blogservice/resources/UserController.java`</li>
   <li>Ex: listar todos os usuários -> `http://localhost:8080/users`</li>
</ul>
