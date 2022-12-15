# projeto-aluguel-de-veiculos

O projeto foi feito em camadas, seguindo as características:

Entidade: É a camada que tem as classes que são os modelos de todo o projeto.
Main (deveria ter sido chamada de View): É a camada que recebemos os dados (inputs) dos usuários baseada nas entidades.
Controlador: É a camada que tem as classes que recebem os dados brutos da main (que geralmente é chamada de View), nesta camada são manipulados os dados para aplicação de regra de negócio.
Repositório: É a camada que recebe dos controladores os dados que já foram tratados pela camada de controlador e esta camada é responsável por armazenar os dados. Sejam esses dados armazenados em memória, em arquivos ou ainda banco de dados.
