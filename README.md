# 📄 Web Scraping de Anexos - Agência Nacional de Saúde Suplementar (ANS)

Este projeto realiza **web scraping** na página da [ANS](https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos) para:


✅ **Acessa automaticamente** o site da ANS.

✅ **Extrai os links** dos PDFs corretos.

✅ **Baixa os arquivos** diretamente para o seu computador.

✅ **Compacta os arquivos** em um único `.zip` para fácil armazenamento e compartilhamento.

## 🚀 Tecnologias Utilizadas  
- **Java 21**  
- **Maven** para gerenciamento de dependências  
- **JSoup** para web scraping  
- **Apache Commons IO** para manipulação de arquivos  

## 📂 Estrutura do Projeto  

📦 com.intuitivecare.webscraping  
┣ 📂 main  
┃ ┗ 📜 Main.java  
┣ 📂 service  
┃ ┣ 📜 Scraper.java  # Extrai os links dos PDFs  
┃ ┣ 📜 Downloader.java  # Baixa os arquivos  
┃ ┗ 📜 Zipper.java  # Compacta os arquivos baixados  

## 🔧 Como Executar  

### 1️⃣ Clonar o repositório  
```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
````
### 2️⃣ Construir o projeto com Maven

Execute o comando abaixo para construir o projeto e instalar todas as dependências necessárias:

```bash
mvn clean install
````

### 3️⃣ Executar o Programa

Agora que o projeto está construído, basta executar o programa com o seguinte comando:

```bash
mvn exec:java -Dexec.mainClass="com.intuitivecare.webscraping.main.Main"
````






