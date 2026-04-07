# Order Management System (JPA / Hibernate)

## Sobre o projeto

Este projeto é um sistema de gerenciamento de pedidos desenvolvido utilizando JPA (Hibernate) puro, sem o uso de frameworks como Spring.

O objetivo é simular um cenário real de e-commerce, aplicando conceitos importantes de modelagem de banco de dados e persistência.

---

## Modelo de domínio

O sistema segue uma modelagem comum em aplicações reais:

* Um usuário pode ter vários pedidos
* Um pedido possui vários itens
* Cada item está associado a um produto

### Relação principal:

```
Order → OrderItem → Product
```

O `OrderItem` atua como entidade intermediária, contendo:

* quantidade
* preço do produto no momento da compra

---

## ⚙️ Funcionalidades

* Criar usuários
* Criar produtos
* Criar pedidos com itens
* Persistir dados utilizando JPA
* Relacionamentos entre entidades (OneToMany, ManyToOne)

---

##  Tecnologias usadas

* Java
* JPA / Hibernate
* Banco de dados (MySQL)
* Maven 

---

## ▶️ Como executar o projeto

1. Clone o repositório:

```
git clone https://github.com/seu-usuario/order-management-jpa.git
```

2. Abra o projeto em sua IDE (IntelliJ, Eclipse, etc)

3. Execute a classe principal:

```
Application.java
```

---

## Exemplo de uso

```java
orderService.criarPedido(
    Instant.now(),
    OrderStatus.PAID,
    1L,
    1L,
    2
);
```

---

## Observações ##

Eu desenvolvi este projeto com o objetivo de consolidar os fundamentos e conceitos do JPA / Hibernate puro, é um projeto com fins acadêmicos..

---

## Desafios ##

Ao longo do desenvolvimento do projeto, tive algumas dificuldades superficiais com o relacionamento entre algumas coleçôes List e o "encaixe" da classe OrdemItem.. Essas
dificuldades me ajudaram a entender mais as lacunas que ainda haviam de ser preenchidas e em como uma entidade intermediária se relaciona com as demais classes sem o uso de um ManyToMany simples..

## 👨‍💻 Autor -- (@sam dev)

Santiago Vieira
Github: https://github.com/tailer0549

Projeto desenvolvido para fins de estudo e prática em backend Java.

