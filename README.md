# **Programação para Dispositivos Móveis**

Projeto das aulas da disciplina de **Programação para Dispositivos Móveis** do **6º período do curso de Sistemas de Informação - IFAL - Campus Arapiraca**.

O projeto **AulaPRMO** será utilizado durante as aulas para o desenvolvimento de aplicações **Android nativas utilizando Kotlin e Jetpack Compose**.

Para facilitar o acesso aos códigos desenvolvidos, teremos um novo `commit` para cada aula. Assim, vocês poderão navegar entre os commits para acompanhar a evolução do projeto e consultar o código desenvolvido em cada aula.

<br>

## **Tecnologias utilizadas**

- **Kotlin**
- **Android**
- **Jetpack Compose**
- **Android Studio**
- **Gradle**
- **Git**

<br>

## **Como fazer o download do projeto**

1. Abra o terminal.
2. Acesse a pasta onde deseja baixar o projeto.
3. Clone o repositório:

```shell
git clone git@github.com:tarsisms/AulaPRMO.git
```

4. Abra a pasta `AulaPRMO` no **Android Studio**.
5. Aguarde a sincronização das dependências do **Gradle**.

<br>

## **Baixando a versão mais atual do projeto**

1. Abra o terminal e acesse a pasta do projeto. Você também pode utilizar o terminal integrado do **Android Studio**.
2. Execute:

```shell
git pull origin main
```

<br>

## **Navegando entre as versões do projeto (código das aulas)**

Cada aula será registrada em um `commit`. Dessa forma, é possível acessar o estado do projeto correspondente a uma aula específica.

1. Abra o terminal na pasta do projeto.

2. Baixe a versão mais atual:

```shell
git pull origin main
```

3. Verifique a lista de `commits` disponíveis:

```shell
git log --oneline
```

Será apresentada uma lista semelhante a:

```shell
5b91fa2 (HEAD -> main) Aula 01 - Introdução ao Jetpack Compose
a9614de Initial commit
```

Onde:

- **HEAD** — indica a versão do código atualmente selecionada.
- **main** — indica a branch principal e a versão mais atual do projeto.

4. Identifique o `commit` correspondente à aula desejada.

Por exemplo:

```text
5b91fa2 Aula 01 - Introdução ao Jetpack Compose
```

Para acessar essa versão:

```shell
git checkout 5b91fa2
```

O projeto ficará exatamente no estado em que estava ao final daquela aula.

<br>

## **Voltando para a versão mais atual**

Depois de consultar o código de uma aula anterior, volte para a branch `main`:

```shell
git checkout main
```

Em seguida, atualize o projeto:

```shell
git pull origin main
```

<br>

## **Aulas**

```text
Aula 01 - Introdução ao Jetpack Compose
```