create table usuarios(
    codigo serial primary key,
    nome   varchar(150) not null,
    cpf    varchar(14)  not null unique,
    username  varchar(120) not null unique,
    password text not null
);

create table roles(
    codigo   serial primary key,
    nome_role varchar(100) not null
);

create table usuarios_roles(
    codigo_usuario integer not null,
    FOREIGN KEY (codigo_usuario) REFERENCES usuarios(codigo),
    codigo_role integer not null,
    FOREIGN KEY (codigo_role) REFERENCES roles (codigo)
);

create table categorias(
    codigo serial primary key,
    nome   varchar(40) not null
);

create table produtos(
    codigo           serial primary key,
    nome             varchar(100) not null,
    descricao        varchar(100) not null,
    codigo_categoria Integer      not null,
    FOREIGN KEY (codigo_categoria) REFERENCES categorias (codigo)
);


--Roles
insert into roles(codigo, nome_role) values (1, 'ROLE_ADMIN');
insert into roles(codigo, nome_role) values (2, 'ROLE_USER');
insert into roles(codigo, nome_role) values (3, 'ROLE_CADASTRAR_CATEGORIA');
insert into roles(codigo, nome_role) values (4, 'ROLE_VISUALIZAR_CATEGORIAS_CADASTRADAS');
insert into roles(codigo, nome_role) values (5, 'ROLE_CADASTRAR_PRODUTO');
insert into roles(codigo, nome_role) values (6, 'ROLE_VISUALIZAR_PRODUTOS_CADASTRADOS');


--Usuario
insert into usuarios(nome, cpf, username, password)
values ('root', '000.000.000-00', 'root', '$2a$10$hzXXzANJ8pE9WIYfExGh6OJVuoqkHK1FYaf3QXUfRabJwbAleLA66');

insert into usuarios(nome, cpf, username, password)
values ('user', '111.111.11-111', 'user', '$2a$10$hzXXzANJ8pE9WIYfExGh6OJVuoqkHK1FYaf3QXUfRabJwbAleLA66');

-- Permissoes
--Usuario Root possui permissoes a todas as roles
insert into usuarios_roles(codigo_usuario, codigo_role) values (1, 1);
insert into usuarios_roles(codigo_usuario, codigo_role) values (1, 2);
insert into usuarios_roles(codigo_usuario, codigo_role) values (1, 3);
insert into usuarios_roles(codigo_usuario, codigo_role) values (1, 4);
insert into usuarios_roles(codigo_usuario, codigo_role) values (1, 5);
insert into usuarios_roles(codigo_usuario, codigo_role) values (1, 6);

--Usuario "user" possui permissoes apenas para visualizar produtos e categorias cadastrado
insert into usuarios_roles(codigo_usuario, codigo_role) values (1, 4);
insert into usuarios_roles(codigo_usuario, codigo_role) values (1, 6);


--Categoria
insert into categorias (codigo, nome)
values (84, 'diversos e outros');
insert into categorias (codigo, nome)
values (86, 'informatica');
insert into categorias (codigo, nome)
values (87, 'musica');
insert into categorias (codigo, nome)
values (88, 'saude e beleza');
insert into categorias (codigo, nome)
values (89, 'veiculos');
insert into categorias (codigo, nome)
values (91, 'industria e comercio');
insert into categorias (codigo, nome)
values (93, 'eletronicos, audio e video');
insert into categorias (codigo, nome)
values (94, 'games e jogos');
insert into categorias (codigo, nome)
values (95, 'instrumentos musicais');
insert into categorias (codigo, nome)
values (97, 'eletrodomesticos');
insert into categorias (codigo, nome)
values (99, 'livros');
insert into categorias (codigo, nome)
values (100, 'utensilios domesticos');
insert into categorias (codigo, nome)
values (101, 'pecas e acessorios - veiculos');
insert into categorias (codigo, nome)
values (102, 'frutas');
insert into categorias (codigo, nome)
values (92, 'celular');

--Produtos
insert into produtos (nome, descricao, codigo_categoria)
values ('iphone 3gs', 'apple', 92);
insert into produtos (nome, descricao, codigo_categoria)
values ('iphone 4', 'apple', 92);
insert into produtos (nome, descricao, codigo_categoria)
values ('iphone 5', 'apple', 92);
insert into produtos (nome, descricao, codigo_categoria)
values ('iphone 4s', 'apple', 92);
insert into produtos (nome, descricao, codigo_categoria)
values ('mobi sm55', 'cce', 92);
insert into produtos (nome, descricao, codigo_categoria)
values ('motionplus sk352', 'cce', 92);
insert into produtos (nome, descricao, codigo_categoria)
values ('motionplus sc452 ', 'cce', 92);
insert into produtos (nome, descricao, codigo_categoria)
values ('nexus 4', 'lg', 92);
insert into produtos (nome, descricao, codigo_categoria)
values ('lg optimus l3 (e400)', 'lg', 92);
insert into produtos (nome, descricao, codigo_categoria)
values ('lg scarlet ii gm600', 'lg', 92);
insert into produtos (nome, descricao, codigo_categoria)
values ('lg t375 dual chip', 'lg', 92);
insert into produtos (nome, descricao, codigo_categoria)
values ('batedeira de bolo', 'material para cozinha ', 97);
insert into produtos (nome, descricao, codigo_categoria)
values ('forninho eletrico', 'material para cozinha ', 97);
insert into produtos (nome, descricao, codigo_categoria)
values ('faca eletrica', 'material para cozinha ', 97);
insert into produtos (nome, descricao, codigo_categoria)
values ('banana', 'validade  6 meses', 102);
insert into produtos (nome, descricao, codigo_categoria)
values ('cacau', 'validade  6 meses', 102);
insert into produtos (nome, descricao, codigo_categoria)
values ('caju', 'validade  6 meses', 102);
insert into produtos (nome, descricao, codigo_categoria)
values ('duriao', 'validade  6 meses', 102);
insert into produtos (nome, descricao, codigo_categoria)
values ('figo', 'validade  6 meses', 102);
insert into produtos (nome, descricao, codigo_categoria)
values ('marula', 'validade  6 meses', 102);
insert into produtos (nome, descricao, codigo_categoria)
values ('air cooler', 'dell', 86);
insert into produtos (nome, descricao, codigo_categoria)
values ('gabinete', 'dell', 86);
insert into produtos (nome, descricao, codigo_categoria)
values ('cadeira gamer', 'dell', 86);
insert into produtos (nome, descricao, codigo_categoria)
values ('placa de video', 'nvidia ', 86);
insert into produtos (nome, descricao, codigo_categoria)
values ('suportes para notebook', 'dell', 86);
insert into produtos (nome, descricao, codigo_categoria)
values ('fones de ouvido', 'samsung', 86);
insert into produtos (nome, descricao, codigo_categoria)
values ('acordeom', 'gbison ', 95);
insert into produtos (nome, descricao, codigo_categoria)
values ('baixo', 'fender ', 95);
insert into produtos (nome, descricao, codigo_categoria)
values ('banjo', 'tagima', 95);
insert into produtos (nome, descricao, codigo_categoria)
values ('corneta', '12 furos ', 95);
insert into produtos (nome, descricao, codigo_categoria)
values ('piano', 'steinway', 95);
insert into produtos (nome, descricao, codigo_categoria)
values ('flauta', 'preto ', 95);
insert into produtos (nome, descricao, codigo_categoria)
values ('guitarra', 'fender ', 95);
insert into produtos (nome, descricao, codigo_categoria)
values ('calota aro 15 chevrolet', ' chevrolet', 101);
insert into produtos (nome, descricao, codigo_categoria)
values ('capa para acento ', 'chevrolet', 101);
insert into produtos (nome, descricao, codigo_categoria)
values ('buzina', 'volkswagen - gol ', 101);
insert into produtos (nome, descricao, codigo_categoria)
values ('descansa braco', 'hyundai - i30', 101);
insert into produtos (nome, descricao, codigo_categoria)
values ('trava de seguranca', 'hyundai - i30', 101);
insert into produtos (nome, descricao, codigo_categoria)
values ('espremedor de fruta eletrico', 'material para cozinha ', 97);
insert into produtos (nome, descricao, codigo_categoria)
values ('moto g5', 'plus ', 92);
insert into produtos (nome, descricao, codigo_categoria)
values ('volante ', 'hyundai - hb20', 101);
insert into produtos (nome, descricao, codigo_categoria)
values ('tv smart samsung ', '50 polegadas ', 97);
insert into produtos (nome, descricao, codigo_categoria)
values ('playstation 1', 'usado ', 94);
insert into produtos (nome, descricao, codigo_categoria)
values ('playstation 2', 'semi novo', 94);
insert into produtos (nome, descricao, codigo_categoria)
values ('playstation 3', 'usado(com fonte queimada)', 94);
insert into produtos (nome, descricao, codigo_categoria)
values ('xbox 360', 'desbloqueado ', 94);
insert into produtos (nome, descricao, codigo_categoria)
values ('nintendo wii', 'novo (acompanha 3 jogos)', 94);
insert into produtos (nome, descricao, codigo_categoria)
values ('polystation', 'para leilao ', 94);
insert into produtos (nome, descricao, codigo_categoria)
values ('lg optimus l3 dual (e405)	', 'lg', 92);
insert into produtos (nome, descricao, codigo_categoria)
values ('Abacate', 'validade  6 meses', 102);
insert into produtos (nome, descricao, codigo_categoria)
values ('Acerola', 'validade  6 meses', 102);
insert into produtos (nome, descricao, codigo_categoria)
values ('Abacaxi', 'validade  6 meses', 102);
insert into produtos (nome, descricao, codigo_categoria)
values ('livro de java 2010', 'traduzido pt-br ', 99);
insert into produtos (nome, descricao, codigo_categoria)
values ('filtro de agua teste', 'material para cozinha ', 97);
insert into produtos (nome, descricao, codigo_categoria)
values ('fender', 'Strato', 95);