## Explicações de qual padrão de projeto usado em cada exercício:

### Questão 1

* Escolhi usar o padrão Strategy porque ele permite trocar facilmente o algoritmo de cálculo de risco sem precisar mudar o código principal.
* Cada tipo de análise fica em uma classe separada, mas todas seguem a mesma estrutura, o que facilita escolher qual usar em cada momento.
* Assim, é possível mudar de algoritmo durante a execução, sem se preocupar com os detalhes de como cada um funciona.
* Essa solução reduz ifs espalhados pelo sistema, facilita a manutenção, e torna simples adicionar novos algoritmos ou ajustar regras sem alterar o código cliente, mantendo a estrutura limpa e escalável.

---

### Questão 2

* Escolhi usar o padrão Adapter porque ele permite conectar o sistema novo com o sistema bancário antigo, mesmo que cada um funcione de um jeito diferente.
* Consigo fazer o novo sistema entender e se comunicar com o legado, convertendo as informações entre os dois lados e incluindo os dados obrigatórios que o sistema antigo precisa.
* Essa solução deixa o código mais organizado, fácil de manter e evita que eu precise mudar o sistema antigo, garantindo que os dois funcionem juntos de forma simples e eficiente.

---

### Questão 3

* Escolhi usar o padrão State porque ele permite representar cada estado da usina nuclear (como DESLIGADA, OPERACAO_NORMAL, ALERTA_AMARELO, ALERTA_VERMELHO e EMERGENCIA) com seu próprio comportamento.
* Cada estado possui suas regras próprias de transição e validação de condições, e o padrão State facilita manter essas regras isoladas e organizadas, evitando confusões e muitos ifs. 
* Com isso, consigo evitar erros, como pular direto do estado de EMERGENCIA sem passar pelo estado de ALERTA_VERMELHO, e ainda posso incluir um modo de manutenção que altera o comportamento normal dos estados.
* Essa solução deixa o código mais claro, fácil de entender e de expandir, garantindo que as transições da usina sejam seguras e bem controladas.

---

### Questão 4

* Escolhi usar o padrão Chain of Responsibility porque ele permite montar uma sequência de validadores onde cada um trata um aspecto do documento sem acoplar tudo num único lugar.
* Cada validador fica isolado e recebe o documento, podendo aprovar, rejeitar, modificar ou encaminhar para o próximo validador, facilitando o processo em cadeia.
* Para regras condicionais (pular um validador se X falhar) implemento lógica no encadeamento: um validador pode escolher qual será o próximo passo ou pular validadores quando necessário.
* O circuit breaker interrompe a cadeia se ocorrerem 3 falhas consecutivas, o sistem vai contando as falhas e aborta, devolvendo erro geral.
* Para rollback, cada validador que altera o documento registra uma ação reversível, se alguma validação posterior falhar, a cadeia percorre os validadores anteriores que modificaram e retorna na ação reversível (rollback).
* Cada validador roda com timeout individual para evitar travamentos, se estourar o timeout, conta como falha para o circuit breaker.
* Com esse padrão fica fácil de testar e escalar, com controle do fluxo, proteção contra falhas em cascata e garantia de consistência através de rollback.

