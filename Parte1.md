**1\)**  Explique com suas palavras o que é Spring Security.  
R: O Spring Security é um framework do ecossistema Spring utilizado para proteger aplicações Java. Ele permite controlar autenticação e autorização, protegendo rotas, usuários, senhas e acessos da aplicação.

**2\)** Para que serve o método csrf().disable()?  
O método csrf().disable() desabilita a proteção CSRF (Cross-Site Request Forgery). Em APIs REST isso normalmente é utilizado porque a aplicação geralmente não usa sessões tradicionais ou formulários HTML, trabalhando apenas com requisições HTTP e tokens.

**3\)** Explique o que significa SessionCreationPolicy.STATELESS.  
Significa que a aplicação não irá criar nem armazenar sessões no servidor. Cada requisição deve conter todas as informações necessárias para autenticação, normalmente usando tokens JWT.

**4\)** Qual a função do permitAll()?  
O permitAll() libera o acesso a determinada rota sem exigir autenticação.

Exemplo:

.requestMatchers("/produtos").permitAll()

**5\)** Explique o que faz o requestMatchers().  
O requestMatchers() é utilizado para definir quais rotas ou endpoints terão regras específicas de segurança.

Exemplo:

.requestMatchers(HttpMethod.GET, "/produtos")  
Nesse caso, a regra será aplicada ao endpoint GET /produtos.

**6\)** Qual a função do anyRequest().authenticated()?  
Esse comando faz com que qualquer requisição não configurada anteriormente exija autenticação para ser acessada.

**7\)** O que é uma API Stateless?  
Uma API Stateless é uma API que não guarda estado ou sessão do usuário no servidor. Cada requisição é independente e deve enviar todas as informações necessárias.

**8\)** Explique o que a lambda abaixo faz:  
session \-\> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)  
Essa lambda configura o gerenciamento de sessão da aplicação para o modo STATELESS, indicando que o Spring Security não deve criar sessões de usuário.

