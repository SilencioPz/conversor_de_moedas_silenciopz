# 💰 Conversor de Moedas (Java Swing)

<p align="center">
  <img src="https://img.icons8.com/color/96/000000/money-bag.png" width="80">
  <br>
  <em>Conversor de 10 moedas internacionais com suporte a criptomoedas</em>
</p>

---

## ✨ Sobre o Projeto
Aplicativo desktop desenvolvido em **Java Swing** que permite conversão monetária entre:
- **Moedas tradicionais**: BRL → USD, EUR, GBP, JPY, ARS, etc.
- **Criptomoeda**: Bitcoin (BTC).
- **Atualizável**: Fácil inclusão de novas moedas

## 🚀 Roadmap

| Versão          | Status       | Observação                       |
|-----------------|-------------|-----------------------------------|
| Java Swing      | ✅ Completo  | Versão estável (IntelliJ)        |
| API de Cotações | 🔄 Em breve  | Integração com ExchangeRate-API  |

---

## 🛠️ Tecnologias & Ferramentas

| Componente      | Detalhes                          |
|----------------|-----------------------------------|
| **Java**       | JDK 17 (OpenJDK)                  |
| **IDE**        | IntelliJ IDEA                     |
| **Build**      | JAR via IntelliJ Artifacts        |
| **Dependências**| Bibliotecas manuais (`/lib`)      |

---

## 📦 Estrutura do Projeto
ConversorDeMoedas/
├── src/ # Código-fonte
├── lib/ # Bibliotecas externas (não versionadas)
├── out/ # Builds do IntelliJ (ignorados no Git)
└── ConversorDeMoedas.jar # Executável principal

---

## 🚀 Como Executar

### Pré-requisitos
- Java 17+ instalado
- Bibliotecas da pasta `lib/` (se aplicável)

### Passo a Passo
1. **Via JAR**:
   ```bash
   java -jar ConversorDeMoedas.jar
   
2. No IntelliJ:

        Importe como projeto existente

        Execute Main.java como classe principal

🔒 Boas Práticas Adotadas

✔️ .gitignore configurado para evitar JARs/lixo
✔️ Separação clara entre lógica e interface
✔️ Código documentado para futuras expansões
🌟 Próximos Passos

    Integrar API de cotações em tempo real

    Adicionar histórico de conversões

    Criar versão com JavaFX

<p align="center"> 👨‍💻 Desenvolvido com ❤️ por você! <img src="https://img.icons8.com/color/48/000000/brazil.png" width="20"> Brasileiro da zuera! XD </p> ```
