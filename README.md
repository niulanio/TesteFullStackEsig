# TesteFullStackEsig

<p>Nesse projeto foi desenvolvida uma API com Java e Spring boot para controle de tarefas </p>


* [Sobre](#sobre)
* [Instalar dependências](#instalar)
* [Executar aplicação](#executar)
* [Rota Swagger](#swagger)


# Sobre

<p>Esse projeto foi desenvolvido como teste para participar da seleção de desenvolvedor fullstack ESIG</p>
<p>Nesse projeto e realizado o controle de login pela entidade USUARIO, onde foi configurado o spring security e o Token JWT para realizar a autenticação.</p>
<p>Foi criada as entidades Responsável e Tarefas para que fosse possivel realizar as exigências minimas do desafio</p>

<p> Foi desenvolvido os pontos A, B, C, D, E e G do desafio</p>

<p>Foram utilizadas as seguintes tecnologias:</p>

<ul>
  <li>JAVA 11</li>
  <li>JPA</li>
  <li>SPING BOOT</li>
  <li>POSTGRESQL</li>
  <li>LOMBOK</li>
  <li>POSTGRESQL</li>
  <li>SPRING SECURITY</li>
  <li>JWT</li>
  <li>SWAGGER</li>
</ul>

# Instalar dependências

```bash
$ `mvn clean install` #Para instalar as dependências
```

# Configuração do Banco de dados

```bash
$ #Alterar as chaves no arquivo application.properties para configurar o banco de dados
$ #spring.datasource.url=jdbc:postgresql://localhost:5432/NOMEDOBANCO
$ #spring.datasource.username=LOGIN
$ #spring.datasource.password=SENHA
```

# Executar aplicação

```bash

$ `mvn spring-boot:run` #para subir a aplicação
```

```bash
# Rota para acessar a documentação Swagger
$ http://localhost:8080/swagger-ui/index.html
```

