<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=7ba23e&height=120&section=header"/>

# <img width='250' heigth='250' src="https://blog.elo7.dev/images/cover/testes-de-codigo-com-mockito-parte-2.png" />
Mockito é uma popular biblioteca de testes unitários para Java, usada para criar objetos simulados (mocks) e verificar interações entre eles. Com o Mockito, é possível testar o comportamento de componentes isoladamente, o que ajuda a identificar bugs e garantir que o código funcione corretamente ao interagir com dependências externas. Vamos explorar os aspectos mais importantes:

### 1. Mockando Objetos
Mocking é o processo de criar "objetos simulados" que imitam o comportamento de objetos reais. Esses mocks são usados em testes para substituir dependências externas e fornecer um ambiente controlado. No Mockito, a criação de mocks é feita com o método `Mockito.mock()`. Quando um método é chamado em um objeto mockado, ele não executa lógica real, a menos que seja explicitamente configurado para isso. Em vez disso, ele retorna valores simulados, o que permite testar o comportamento do código que depende desse objeto sem invocar as implementações reais.

**Exemplo**:
```java
// Cria um mock da classe MyService
MyService service = Mockito.mock(MyService.class);
```

### 2. Espiando Objetos (Spying)
Ao contrário de um mock completo, um "spy" (espião) permite monitorar e verificar o comportamento de um objeto real. Usando `Mockito.spy()`, é possível criar um objeto que executa a lógica real da classe e, ao mesmo tempo, permite "espiar" suas chamadas. Isso é útil quando você deseja verificar a execução de métodos específicos sem perder o comportamento real do objeto.

**Exemplo**:
```java
// Cria um spy da classe MyService
MyService serviceSpy = Mockito.spy(new MyService());
```

Com `spy()`, métodos específicos podem ser simulados, enquanto o restante do comportamento do objeto permanece o mesmo.

### 3. Capturando Argumentos
Argument Captors, ou capturadores de argumentos, são uma maneira de capturar os valores passados para métodos de um mock para posteriormente verificá-los. Esse recurso é particularmente útil quando você quer inspecionar ou validar os parâmetros passados para o método.

**Exemplo**:
```java
ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
Mockito.verify(service).methodName(captor.capture());
assertEquals("expectedValue", captor.getValue());
```

No exemplo acima, o `ArgumentCaptor` captura o valor do argumento passado para o método `methodName`, permitindo verificá-lo.

### 4. Manipulação de Retornos
Mockito permite definir o comportamento de métodos mockados, especificando os valores de retorno usando `when().thenReturn()`. Isso ajuda a simular diferentes cenários de teste. Além disso, podemos também configurar o retorno condicional ou lançar exceções para verificar como o código lida com situações de erro.

**Exemplo**:
```java
Mockito.when(service.someMethod()).thenReturn("Expected Result");
Mockito.when(service.someMethod()).thenThrow(new RuntimeException("Error"));
```

### 5. Stubbing
Stubbing define o comportamento de métodos mockados, permitindo configurar respostas para chamadas específicas. Quando uma resposta é "stubbed" em Mockito, ela se torna a resposta padrão para qualquer chamada subsequente, a menos que seja sobreposta por uma nova configuração. A técnica de stubbing ajuda a criar diferentes cenários de teste, como valores padrão, valores nulos, ou cenários de erro.

**Exemplo**:
```java
// Define o comportamento (stub) do método com retorno específico
Mockito.when(service.someMethod("argument")).thenReturn("stubbed response");
```

### 6. Verificação de Interações
Além de configurar mocks, é importante verificar as interações entre os mocks e o código em teste. Com o método `verify()`, o Mockito permite assegurar que os métodos sejam chamados no momento e na ordem esperados, com parâmetros específicos, ajudando a garantir a integridade do fluxo.

**Exemplo**:
```java
Mockito.verify(service).methodName("argument");
```

### 7. Resetando Mocks
Se necessário, os mocks podem ser resetados para descartar qualquer comportamento ou interação anterior. Isso é útil em testes complexos, onde um mock precisa ser reutilizado com uma nova configuração.

**Exemplo**:
```java
Mockito.reset(service);
```

### Conclusão
Mockito é uma ferramenta poderosa para testes em Java, pois permite simular comportamentos, capturar argumentos, definir respostas e verificar interações entre objetos de forma fácil e flexível. Para utilizar bem o Mockito, é importante entender cada uma dessas funcionalidades e aplicá-las conforme o contexto do teste, garantindo testes unitários eficazes e mantendo o código base confiável.
