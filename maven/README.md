<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=c72238&height=120&section=header"/>

# Maven <img width='60' heigth='60' src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/maven/maven-original.svg" />

Maven é uma ferramenta de gerenciamento de dependências e automação de projetos para Java (e outras linguagens), desenvolvida pela Apache Software Foundation. Ele facilita a construção, o empacotamento e a manutenção de projetos Java, fornecendo uma estrutura consistente para construir, documentar e gerenciar as dependências.

### O que é o Maven?
- **Gerenciamento de Dependências**: Gerencia automaticamente bibliotecas externas que seu projeto precisa. Você especifica as dependências (bibliotecas de terceiros) no arquivo `pom.xml` (Project Object Model), e o Maven baixa e mantém essas bibliotecas atualizadas.
- **Automação de Build**: Automatiza o processo de compilação, testes, empacotamento e instalação. Ele oferece ciclos de vida que simplificam tarefas comuns, como compilar, rodar testes e criar arquivos `.jar` ou `.war`.
- **Padronização**: Estrutura e organiza o código em um formato padrão, o que facilita a colaboração entre desenvolvedores, já que todos os projetos Maven têm uma estrutura previsível.

### Como criar um projeto Maven
Para usar o Maven, você precisa do JDK e do Maven instalados e configurados no seu sistema.

1. **Criação de um projeto Maven**:
   ```bash
   mvn archetype:generate -DgroupId=com.seuprojeto -DartifactId=nome-do-projeto -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
   ```
   - `-DgroupId`: Identifica o grupo ao qual o projeto pertence, como o domínio da empresa (ex.: `com.seuprojeto`).
   - `-DartifactId`: Nome do artefato, que será o nome do projeto.
   - `-DarchetypeArtifactId`: Define o tipo de estrutura do projeto. O `maven-archetype-quickstart` cria uma estrutura básica.
   - `-DinteractiveMode=false`: Evita interações manuais durante a criação do projeto.

2. **Entrar na pasta do projeto**:
   ```bash
   cd nome-do-projeto
   ```

### Comandos Maven úteis

1. **Compilar o Projeto**:
   ```bash
   mvn compile
   ```
   - Compila o código-fonte do projeto.

2. **Executar Testes**:
   ```bash
   mvn test
   ```
   - Executa os testes automatizados definidos na pasta `src/test`.

3. **Empacotar o Projeto**:
   ```bash
   mvn package
   ```
   - Cria o arquivo `.jar` ou `.war` do projeto na pasta `target`.

4. **Instalar no Repositório Local**:
   ```bash
   mvn install
   ```
   - Instala o artefato no repositório local (geralmente em `.m2/repository`), tornando-o disponível para outros projetos Maven no sistema.

5. **Limpar Arquivos de Compilação**:
   ```bash
   mvn clean
   ```
   - Remove a pasta `target`, onde ficam os artefatos de build anteriores.

6. **Executar Ciclo Completo de Build**:
   ```bash
   mvn clean install
   ```
   - Executa o ciclo completo, limpando, compilando, testando, empacotando e instalando o projeto.

7. **Verificar Dependências**:
   ```bash
   mvn dependency:tree
   ```
   - Mostra as dependências do projeto em formato de árvore, ajudando a identificar conflitos e dependências transitivas.

8. **Atualizar Dependências**:
   ```bash
   mvn dependency:resolve
   ```
   - Baixa ou atualiza as dependências especificadas no `pom.xml`.

Esses comandos e funcionalidades tornam o Maven uma ferramenta essencial para projetos Java, agilizando o gerenciamento de dependências, builds e empacotamentos.
