Para o uso instale de load em todas as dependencias no intellij ou sua IDE de preferencia e no postman chame um método POST assim:

http://localhost:8080/calculos/todos   //para ver todas as operações
http://localhost:8080/calculos/desvio  //para ver o desvio padrao
http://localhost:8080/calculos/mediana //para ver a mediana
http://localhost:8080/calculos/media   //para ver a media

E neste POST use o body desta forma: 

Exemplo:
{
   "listaValores": [1, 2, 3 , 4 ]
}
