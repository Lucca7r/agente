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

# 🚩PAES (Percepção, Ação, Estado, Solução)

    - Percepção: O agente percebe o ambiente ao seu redor identificando a célula em que está localizado e verificando os tipos de sujeira ("A" para água e "P" para poeira) ao seu redor.
    -  Ação: As ações do agente consistem em mover-se para uma célula vizinha e limpar o tipo de sujeira encontrada. As direções possíveis são cima, baixo, esquerda e direita, dependendo da validade da célula.
    - Estado: O estado do agente é representado pela sua posição atual no labirinto e o número de movimentos realizados para limpar o ambiente. O estado do labirinto é alterado quando o agente limpa uma célula.
    - Solução: A solução final é atingida quando todas as células com sujeira ("A" ou "P") são limpas, momento em que o agente para de se mover. O sucesso do agente é determinado pela capacidade de encontrar e limpar todas as células sujas.

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
