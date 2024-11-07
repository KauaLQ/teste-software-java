<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=26a162&height=120&section=header"/>

# JUnit <img width='40' heigth='40' src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/junit/junit-original.svg" />

JUnit é uma das bibliotecas mais populares para realizar testes unitários em Java. Ele ajuda a automatizar a verificação de métodos, garantindo que cada componente de um código funcione como esperado de forma independente. Vou passar pelos conceitos principais que você mencionou.

### 1. **Conceitos Básicos de Testes Unitários com JUnit**
- **Testes Unitários**: São testes focados em pequenas partes de um sistema, geralmente métodos individuais. Eles ajudam a garantir que cada parte da aplicação funcione corretamente de forma isolada.
- **JUnit Annotations**: As anotações mais usadas no JUnit 5 são `@Test`, `@BeforeEach`, `@AfterEach`, `@BeforeAll`, `@AfterAll`. Elas permitem controlar o comportamento e a execução dos métodos de teste:
    - **@Test**: Identifica um método como um teste.
    - **@BeforeEach**: Executa um método antes de cada teste. Ideal para configurar o estado inicial necessário para os testes.
    - **@AfterEach**: Executa um método depois de cada teste, geralmente para limpar os recursos utilizados no teste.
    - **@BeforeAll** e **@AfterAll**: Executam métodos uma única vez antes ou depois de todos os testes. Essas anotações são úteis para operações de configuração e limpeza global para todos os testes e devem ser usadas em métodos `static`.

### 2. **Assumptions e Testes Condicionais**
- **Assumptions**: São condições que precisam ser verdadeiras para que o teste continue. Caso uma suposição falhe, o teste é ignorado, e não marcado como falha. Por exemplo, `Assume.assumeTrue(condition)` pode ser usado para testar o código apenas em um ambiente específico (como em um ambiente de desenvolvimento, mas não de produção).
- **Testes Condicionais**: São úteis quando queremos que certos testes sejam executados apenas em condições específicas. JUnit fornece métodos como `assumeTrue()` e `assumeFalse()` para configurar essas condições.

### 3. **Testando Exceptions**
- Testes de exceções verificam se um método lança uma exceção esperada em um cenário específico. No JUnit, você pode usar a anotação `@Test` com o parâmetro `expected` para verificar uma exceção esperada:
  ```java
  @Test
  void testForException() {
      assertThrows(IllegalArgumentException.class, () -> {
          // código que deve lançar a exceção
      });
  }
  ```
- Esse tipo de teste é útil para garantir que o código responde corretamente a entradas inválidas ou condições adversas.

### 4. **Ordenação de Testes**
- Por padrão, a ordem de execução dos testes em JUnit não é garantida e pode ser aleatória. Contudo, para alguns cenários, pode ser interessante definir uma ordem. Em JUnit 5, a anotação `@TestMethodOrder` é usada para especificar a ordem dos métodos de teste.
- Você pode utilizar `@Order` para definir a ordem de execução:
  ```java
  @Test
  @Order(1)
  void firstTest() { ... }
  @Test
  @Order(2)
  void secondTest() { ... }
  ```
- Isso é útil para testes que precisam ser executados em uma sequência específica.

### 5. **Testes Parametrizados**
- Testes parametrizados permitem executar o mesmo teste com diferentes valores, economizando código e esforço. Em JUnit, você pode fazer isso com a anotação `@ParameterizedTest` e passar argumentos com `@ValueSource` ou outras anotações.
- Por exemplo:
  ```java
  @ParameterizedTest
  @ValueSource(ints = { 1, 2, 3 })
  void testWithMultipleValues(int number) {
      assertTrue(number > 0);
  }
  ```

### 6. **Tagging de Testes**
- JUnit permite adicionar tags aos testes para que você possa executar subconjuntos específicos de testes. A anotação `@Tag` permite categorizar testes:
  ```java
  @Test
  @Tag("fast")
  void fastTest() { ... }
  ```
- Isso é útil para rodar testes específicos, como aqueles marcados com "fast" ou "integration".
