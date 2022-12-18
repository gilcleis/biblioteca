<h1>Biblioteca </h1>
<p> Sejam bem-vindos ao projeto de Biblioteca desenvolvido em Spring Boot finalizando o treinamento em Java.</p>

<h2>🎯 Objetivo do Projeto</h2>
Desenvolver um conjunto de API’s utilizando Spring Boot para controlar uma Biblioteca. Serão controlados a entrada, saída e valor a ser cobrado do cliente. São aplicadas as boas práticas de desenvolvimento de API’s incluindo acesso a banco de dados H2.

![](./diagram.png)

<a href="Treinamento_Java.postman_collection.json">Arquivo postman</a>
<h2>
🛑 Pré-requistos
</h2>

* Lógica de programação e POO;

* Conhecimento basico em Java e Spring Boot;

* Conhecimento em Banco de dados H2;


<h2> 🚦 Guia </h2>

<ol>
    <li> Apresentação do Projeto Base </li>
    <li> Configuração do banco de dados H2</li>
    <li> Aplicando as <em>annotations</em></li>
    <li>Execução do fluxo back-end: <em>Controller - Service - Repository</em></li>
    <li>Validação - <em>Hibernate Validator</em> </li>
</ol>

<h2>🛠 Tecnologias Utilizadas</h2>

<ul>
    <li>Java 17</li>
    <li>Maven</li>
    <li><strong>Spring Web</strong></li>
    <li><strong>Spring Data JPA</strong></li>
    <li><strong>H2 database</strong></li>
    <li><strong>Spring Boot Devtools</strong></li>
    <li><strong>Hibernate Validator</strong></li>
    <li>Postman</li>
</ul>


<h2><a href="https://strn.com.br/artigos/2018/12/11/todas-as-anota%C3%A7%C3%B5es-do-jpa-anota%C3%A7%C3%B5es-de-mapeamento/"> Anotações de Mapeamento </a></h2>

<strong>@Entity</strong>
Usada para especificar que a classe anotada atualmente representa um tipo de entidade.

<strong>@Table</strong>
Usada para especificar a tabela principal da entidade atualmente anotada.

<strong>@Id</strong>
Especifica o identificador da entidade. Uma entidade deve sempre ter um atributo identificado.

<strong>@GeneratedValue</strong>
Especifica que o valor do identificador de entidade é gerado automaticamente.

<strong>@Column</strong>
Usada para especificar o mapeamento entre um atributo de entidade básico e a coluna da tabela de banco de dados.


<strong>@ManyToOne</strong>
Usada para especificar um relacionamento de banco de dados muitos-para-um.



<h2>🔗 Links Úteis</h2>
<ul>
    <li><a href="https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.6.1&packaging=jar&jvmVersion=11&groupId=me.dio.academia&artifactId=academia-digital&name=academia-digital&description=Tutorial%20API%20RESTful%20modelando%20sistema%20de%20academia%20de%20gin%C3%A1stica&packageName=me.dio.academia.digital&dependencies=web,data-jpa,postgresql,validation,lombok">Spring Initializr</a></li>
    <li><a href="https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/common-application-properties.html">Common application properties</a></li>
    <li><a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories">Spring Data JPA - Reference Documentation</a></li>
</ul>


<h2> 🤝 Contribuindo </h2>

Este repositório foi criado para fins de estudo, então contribua com ele.
Se te ajudei de alguma forma, ficarei feliz em saber. E caso você conheça alguém que se identidique com o conteúdo, não deixe de compatilhar.

Se possível:

⭐️  Star o projeto

🐛 Encontrar e relatar issues

------------

Disponibilizado por [gilclei](https://www.linkedin.com/in/gilclei-araujo/ "gilclei").



