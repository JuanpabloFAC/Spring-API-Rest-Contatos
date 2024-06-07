# API Rest CRUD - Contatos
Esse CRUD tem como objetivo criar, ler, atualizar e deletar pessoas de uma agenda de contatos. 
#### O que eu pude aprender com este projeto ?
Essencialmente aprendi muito mais sobre as principais anotações utilizadas no spring quando estamos criando uma API Rest e como abstrair no controller as nossas entidades através de DTO's, ademais aprendi sobre a importância dos DTO's que concentra principalmente na privacidade dos nossos dados.

## As tecnologias utilizadas para a criação desse projeto foram:
- Java
- MySQL
- SpringBoot
- Maven

## Dependêcias utilizadas:
- Spring Web
- Spring Boot DevTools
- MySQL Driver
- Spring Data JPA
- Lombok
- Swagger (para documentação)
- Mapper

## Anotações utilizadas:

### @RestController
Torna minha API no formato RestFull.

### @RequestMapping
Faz o mapeamento do controller.

### @Autowired
Injeção de dependência. Ela é uma das principais formas de realizar a injeção automática de dependências em componentes gerenciados pelo Spring.

### @GetMapping
Faz o mapeamento de uma requisição GET e diz que tipo é.

### @PostMapping
Faz o mapeamento de uma requisição POST e diz que tipo é.

### @PutMapping
Faz o mapeamento de uma requisição PUT e diz que tipo é.

### @DeleteMapping
Faz o mapeamento de uma requisição DELETE e diz que tipo é.

### @AllArgsConstructor
Faz um construtor tendo como parâmetro todos os atributos da classe.

### @NoArgsConstructor
Faz um construtor sem nenhum parâmetro.

### @Data
Gera métodos comuns, como getters, setters, toString, equals, hashCode, etc.

### @Entity
Defino onde a classe for representada como tabela.

### @Table
Usado para informar o nome correto da tabela no banco de dados.

### @JsonInclude(JsonInclude.Include.NON_NULL)
Colocamos no DTO’s e ele não vai deixar aparecer no JSON response os valores que tem null.

### @Repository
Indicação de Componente, Exceções de Persistência e Integração com Outras Tecnologias.

### @Service
Marcar uma classe como serviço.

### @Id
Indica que um campo em uma classe é a chave primária da entidade quando essa classe é mapeada para uma tabela em um banco de dados relacional.
