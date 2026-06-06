#  Plataforma de Monitoramento Espacial

Projeto desenvolvido em **Java** para a **Global Solution 2026 — POO (Programação Orientada a Objetos)**.

##  Sobre o projeto

A Plataforma de Monitoramento Espacial é uma aplicação de console que simula o controle de uma
nave/estação espacial. Por meio de um menu interativo, o usuário pode acompanhar os sensores de
bordo, controlar os sistemas de propulsão, gerenciar os dados da missão e receber alertas
automáticos quando algum valor sai do esperado.

O foco do projeto é demonstrar, na prática, os quatro pilares da Programação Orientada a Objetos:

- **Abstração** — a classe abstrata `ComponenteEspacial` define o "molde" dos componentes da nave.
- **Herança** — `SistemaPropulsao` e seus tipos (`PropulsaoQuimica`, `PropulsaoEletrica`) reutilizam código por meio de `extends`.
- **Encapsulamento** — a classe `DadosMissao` protege seus atributos como `private`, liberando o acesso apenas por getters/setters com validação (inclusive dados sensíveis protegidos por senha).
- **Polimorfismo** — sensores e propulsores são tratados de forma unificada através da interface `Sensor` e da classe base, sem o menu precisar conhecer o tipo concreto de cada objeto.

##  Estrutura do projeto

```
src/
├── ComponenteEspacial.java   (classe abstrata)
├── Sensor.java               (interface)
├── DadosMissao.java          (classe com encapsulamento)
├── SistemaPropulsao.java     (classe abstrata)
├── PropulsaoQuimica.java     (herda de SistemaPropulsao)
├── PropulsaoEletrica.java    (herda de SistemaPropulsao)
├── SensorTemperatura.java    (implementa Sensor)
├── SensorPressao.java        (implementa Sensor)
├── SensorRadiacao.java       (implementa Sensor)
└── SistemaMonitoramento.java (classe principal com o menu)
```

##  Como executar

### Pré-requisitos
- **JDK 17** ou superior instalado
- **IntelliJ IDEA** (ou outra IDE Java) ou apenas o terminal

### Pelo IntelliJ IDEA (recomendado)
1. Clone o repositório:
   ```bash
   git clone https://github.com/LuizC777/GLOBAL-SOLUTIONS1-JAVA.git
   ```
2. Abra a pasta do projeto no IntelliJ IDEA.
3. Abra o arquivo `src/SistemaMonitoramento.java`.
4. Clique no botão ▶ (Run) ao lado do método `main` ou pressione `Shift + F10`.

### Pelo terminal
A partir da pasta `src`:
```bash
javac *.java
java SistemaMonitoramento
```

##  Demonstrações

### Menu principal

Ao iniciar o programa, é exibido o menu principal com todas as opções disponíveis. Ele roda em um
loop até que o usuário escolha a opção `0` para sair, lendo a entrada do teclado a cada rodada.

<img width="307" height="200" alt="Image" src="https://github.com/user-attachments/assets/13286ef3-7f60-4d8a-a2a4-a1904fc72a42" />

---

### 1 — Verificar sensores

Faz a leitura (simulada) de todos os sensores de bordo — temperatura, pressão e radiação —
exibindo o valor atual de cada um, sua unidade de medida e se o sensor está funcionando (OK) ou
apresentando falha.

<img width="339" height="111" alt="Image" src="https://github.com/user-attachments/assets/bead8453-3110-4226-b124-cf45039c6bcf" />

---

### 2 — Controlar propulsão

Permite escolher um dos sistemas de propulsão (química ou elétrica) e executar ações sobre ele:
ligar, desligar, acelerar com uma porcentagem de potência (0–100, com validação) e visualizar o
empuxo gerado. Cada tipo de propulsão se comporta de forma diferente.

<img width="493" height="177" alt="Image" src="https://github.com/user-attachments/assets/91441034-93d7-4238-a327-5b377f9e428d" />

<img width="491" height="123" alt="Image" src="https://github.com/user-attachments/assets/5588eb9d-8f10-4e97-b6b2-68e83c74f633" />

---

### 3 — Gerenciar dados da missão

Centraliza os dados da missão com encapsulamento e validação. É possível visualizar as coordenadas
(protegidas por senha), atualizar o nível de combustível, definir a trajetória e o número de
tripulantes. Valores inválidos (como combustível fora da faixa 0–100 ou tripulantes negativos) são
recusados automaticamente.

> **Senha de demonstração para ver as coordenadas:** `1234`

<img width="520" height="144" alt="Image" src="https://github.com/user-attachments/assets/1d98481b-72e1-4597-81bb-64912466677f" />

---

### 4 — Simular alertas

Verifica automaticamente os valores dos sensores e emite alertas visuais no console quando algum
valor se aproxima ou ultrapassa o limite definido. Os alertas são classificados em três níveis:

- **ATENÇÃO** — valor próximo do limite
- **ALERTA** — valor acima do limite
- **CRÍTICO** — valor muito acima do limite

<img width="298" height="63" alt="Image" src="https://github.com/user-attachments/assets/76078a44-37ab-4bc0-a6f1-cd9f32424652" />

<img width="347" height="102" alt="Image" src="https://github.com/user-attachments/assets/8a46dd48-fbea-4436-8789-e0b91b2d7935" />

---

### 5 — Exibir status completo

Apresenta um panorama geral de todo o sistema em uma única tela: o estado atual de cada sensor (com
seu nível de alerta), os detalhes de cada sistema de propulsão (empuxo, temperatura, etc.) e os
dados gerais da missão (combustível, trajetória e tripulantes).

<img width="781" height="355" alt="Image" src="https://github.com/user-attachments/assets/708a6a3a-ab75-4765-b683-d3df4cdbe1d8" />

---

##  Autores

Projeto acadêmico desenvolvido para a disciplina de Programação Orientada a Objetos.

- Luiz Claro Lima - RM 563014

- Gabriel Nacarelli Pinheiro - RM 565298
