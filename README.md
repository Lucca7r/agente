<h1 align="center">Agente Limpeza em Labirinto</h1>
<br>
<br>


<p align="center">
  <a href="#-descrição">Descrição</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-objetivo">Objetivo</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-Estrutura do Projeto">Estrutura do Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-Requisitos">Requisitos</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-Como usar">Como usar</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-Configuração">Configuração</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#licença">Licença</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
</p>

# 🎓Info
<p align="center">

Professor: Dr. Aldo Henrique Dias Mendes

Participantes: Lucas silva, Luan medrado

Disciplina: Inteligencia artificial

Semestre: 2024/2
</p>

# 📝Descrição:

Este projeto implementa um sistema de agente autônomo que navega e limpa um labirinto gerado aleatoriamente. O agente percorre o labirinto identificando e removendo sujeiras representadas por células específicas do ambiente.

<br>


# 🎯Objetivos
O agente localizar a sujeita A(agua) e P(po) e limpa dando prioridade para Agua

<br>


# 🔧Estrutura do Projeto

O projeto está organizado da seguinte forma:

    - Main.java: Classe principal que executa o programa, inicializa o labirinto e controla o fluxo de execução.
    - Labirinto.java: Classe que representa o ambiente do labirinto, com a geração aleatória de células contendo sujeira e obstáculos
    - AgenteLabirinto.java: Classe que implementa o agente que navega pelo labirinto, tomando decisões sobre o movimento e a limpeza.
    - PosicaoXY.java: Classe que define a posição do agente e outros objetos dentro do labirinto.
    
<br>

<br>

# 🚩PPEAS (Performance, Environment, Actuators, Sensors)

    - Performance (Desempenho):

        O desempenho do agente é avaliado com base em sua capacidade de limpar todas as células do labirinto que contenham sujeira. Um agente bem-sucedido será aquele que limpar todas as células com sujeira ("A" para água e "P" para poeira) no menor número de movimentos possível e sem deixar sujeiras para trás.

<br>
    - Environment (Ambiente):

        O ambiente é o labirinto, que é gerado aleatoriamente com um número fixo de células (por exemplo, 4x4). Cada célula do labirinto pode conter:
        Água ("A"), representando sujeira líquida.
        Poeira ("P"), representando sujeira sólida.
        Células vazias ("L") que já foram limpas pelo agente.
        O agente deve navegar neste ambiente, evitando obstáculos e encontrando as células sujas.

<br>

    - Actuators (Atuadores):

        O agente usa os seguintes atuadores:
        Movimentação: O agente se move para as células adjacentes nas quatro direções possíveis (cima, baixo, esquerda, direita).
        Limpeza: Quando o agente chega em uma célula suja, ele usa o atuador de limpeza para remover a sujeira, transformando a célula em limpa ("L").
<br>
    - Sensors (Sensores):

        O agente possui sensores que permitem:
        Percepção de Sujeira: O agente pode detectar se a célula atual ou uma célula adjacente contém sujeira, seja ela água ("A") ou poeira ("P").
        Percepção de Obstáculos: O agente pode detectar obstáculos, como paredes ou células já limpas, para evitar mover-se para locais inválidos.

<br>


# 👩‍🔧Como usar

1. Clone o repositório:

    - Bash
        ```git clone https://github.com/Lucca7r/```

2. Instale as dependências:

    - none



# ⚙️Exemplo de Execução
    - Ao iniciar, o labirinto será exibido com as células representando água ("A") e poeira ("P"). O agente se moverá e limpará as células, mostrando visualmente seu progresso até completar a tarefa de limpeza.
   
<br>


# ©Licença:

Este repositório está licenciado sob a licença MIT.
<p align="center">
  <img alt="License" src="https://img.shields.io/static/v1?label=license&message=MIT&color=49AA26&labelColor=000000">
</p>
