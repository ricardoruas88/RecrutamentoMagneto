# Magneto
Verificar se pessoa é mutante ou humano

Para executar o projeto vc pode fazer via import no eclipse ou STS pelo GIThub ou MavenProject

O projeto já está acoplado com o banco de dados H2 para os testes


O repositorio está no goolge app engine

https://8080-dot-6103920-dot-devshell.appspot.com/stats

EXEMPLO POST:


POST /mutant HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: acbe2b32-7dee-2c13-3a85-ef61fed781a7

{
	"dna":["GTGCGA","AAGTGC","AGAATT","AGAAGG","GCCCAT","TACCCC"]
}

EXEMPLO GET:

GET /stats HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 33709e2b-c0a9-e4ce-1042-b7a33088001d



