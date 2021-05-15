# Projeto 2 - P1

Projeto 2 da disciplina Programação de Dispositivos Móveis - FATEC-BT

```diff
- Alunos:
+ Marcos Felipe Soares Rocha
+ Rejane de Lima e Silva
```
`Vence 16 de abril de 2021 23:59 - Fecha 16 de abril de 2021 23:59`

## Instruções
Esse trabalho consiste no desenvolvimento de um programa `Android`, e valerá como parte da nota da P1.
O programa deve ser feito em grupos de até dois alunos.

`Esse programa vale 3 pontos da P1`

Desenvolver uma aplicação Android que faça o cálculo da média de uma disciplina e compartilhe essa informação. Para isso, a APP deverá ter duas telas de interação com o usuário:

1) Uma das telas deve permitir a entrada das notas da P1, P2 e P3. Nesta primeira tela deve ser realizada a execução do cálculo da média (onde média = (P1*2 + P2*3)/5, e a P3 substituirá a menor nota entre a P1 e a P2, caso seja necessário). Ao final do processo de cálculo, deve ser apresentado ao usuário se o aluno atingiu a média >= 6,00, apresentando a média e a mensagem "Aprovado" ou "Reprovado", caso contrário. As informações dessa tela devem ser enviadas para uma segunda tela;

2) A segunda tela deve receber da primeira as notas P1, P2, P3 e média, e a mensagem de aprovação ou reprovação. Ainda, deve permitir a entrada do nome da disciplina, do nome do aluno e do número de faltas. Todas essas informações devem ser usadas para formar uma mensagem de compartilhamento sobre o resultado acadêmico do aluno. Deve ser permitido ao usuário escolher qual a APP que será usada para o compartilhamento, como apresentado em aula. 

## Exemplo de mensagens compartilhadas:

```Java 
"O aluno João foi Reprovado com média 5,00 em Programação WEB, com as notas P1=5,00, P2=4,00 e P3=5,00, e 12 faltas!"

"A aluna Roberta foi Aprovada com  média 8,00 em PDM, com as notas P1=8,00 e P2=8,00, e 4 faltas!"
```

A entrega será pela plataforma `MS Teams`, onde deverão ser entregues:

- O projeto no `Android Studio` com o código fonte `Java`.
- Uma gravação de vídeo do uso do `app` (vídeo com no máximo `1 minuto`).

_A entrega deve ser feita por apenas um dos integrantes do grupo (lembrando de destacar o nome completo de todos que participaram da criação do projeto)._
