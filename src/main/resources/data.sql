CREATE TABLE IF NOT EXISTS veiculo(
    id UUID NOT NULL,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    ano BIGINT NOT NULL,
    cor VARCHAR(25) NOT NULL,
    preco DECIMAL NOT NULL,
    vendido BOOLEAN NOT NULL,
    cpf_cliente VARCHAR(20),
    data_venda DATE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS alteracoes(
    id UUID NOT NULL,
    evento VARCHAR(50) NOT NULL,
    id_veiculo UUID REFERENCES veiculo(id),
    data DATE,
    PRIMARY KEY (id)
);