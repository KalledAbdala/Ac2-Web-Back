# 🛠️ Sistema de Controle de Projetos – Atividade 3 (AC2)

Este projeto faz parte da **Atividade 3 – AC2**, cujo objetivo é desenvolver um **sistema de controle de projetos** com backend em **Spring Boot** e uma interface funcional para a tela de projetos no frontend.

---

## 📌 Descrição

Você foi contratado para implementar um sistema de controle de projetos. A estrutura da API já foi definida por um analista de requisitos, e esta atividade segue um roteiro para criação do backend e construção de um protótipo da interface.

> 💡 **Observação**: Esta atividade pode ser realizada em **dupla**.

---

## 🧰 Tecnologias Utilizadas

### Backend (Spring Boot)

- Spring Web  
- Spring Data JPA  
- H2 Database  
- Lombok  

---

## 🧱 Estrutura e Funcionalidades

### 🔹 Modelagem das Entidades

As entidades foram modeladas utilizando **JPA** conforme a estrutura definida pelo analista de requisitos.

> 📸 _A imagem da modelagem será adicionada posteriormente._

---

### 🔹 Repositórios

Foi criado um repositório para cada entidade estendendo `JpaRepository`, incluindo as seguintes **consultas personalizadas**:

- **ProjetoRepository**
  - Buscar projeto por ID com lista de funcionários vinculados.
  - Buscar projetos por intervalo de datas de início.

- **FuncionarioRepository**
  - Buscar todos os projetos vinculados a um funcionário pelo seu ID.

- **SetorRepository**
  - Listar todos os setores com seus respectivos funcionários.

---

### 🔹 Camada de Serviço

Cada entidade possui uma **classe de serviço** responsável por:

- Implementar regras de negócio
- Tratar erros e validações necessárias

---

### 🔹 Controllers

#### **ProjetoController**

- `adicionar(projeto: ProjetoDTO): void`  
- `buscarProjetoPorId(id: Integer): DadosProjetoDTO`  
  (retorna também os funcionários vinculados)  
- `vincularFuncionario(idProjeto: Integer, idFuncionario: Integer): void`

#### **FuncionarioController**

- `adicionar(funcionario: FuncionarioDTO): void`  
- `buscarProjetos(idFuncionario: Integer): List<DadosProjetoDTO>`

#### **SetorController**

- `adicionar(setor: SetorDTO): void`  
- `buscarSetorPorId(idSetor: Integer): DadosSetorDTO`

---

## 💻 Protótipo Frontend

Uma interface funcional foi desenvolvida com as seguintes funcionalidades:

- Listar todos os projetos cadastrados
- Inserir um novo projeto

---

## 📎 Imagem da Modelagem

![image](https://github.com/user-attachments/assets/5b95743a-c457-4515-8755-41b58ca9105f)


---

## ✨ Status do Projeto

✅ Backend funcional com consultas personalizadas  
🚧 Protótipo do frontend em desenvolvimento  

---

## 👥 Desenvolvido por

- [Seu Nome Aqui]
- [Nome do parceiro, se em dupla]

---

