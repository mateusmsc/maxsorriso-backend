# maxsorriso
Simples backend para simulação de uma clínica de dentistas.  
* Linguagem utilizada: Java  
* Banco de dados utilizado: MariaDB  
* Modelagem criada no draw.io
* Software utilizado para realizar as chamadas na API: Insomnia 

## Modelagem proposta para o problema
* **Paciente** :    
  &nbsp;&nbsp;&nbsp;&nbsp; id: _Number_ (Primary key)  
  &nbsp;&nbsp;&nbsp;&nbsp; nome: _String_  
  &nbsp;&nbsp;&nbsp;&nbsp; email: _String_  
  &nbsp;&nbsp;&nbsp;&nbsp; telefone: _String_  
  &nbsp;&nbsp;&nbsp;&nbsp; data_nascimento: _Date_
  
* **Doutor** :    
  &nbsp;&nbsp;&nbsp;&nbsp; id: _Number_ (Primary key)
  &nbsp;&nbsp;&nbsp;&nbsp; nome: _String_  
  &nbsp;&nbsp;&nbsp;&nbsp; email: _String_  
  &nbsp;&nbsp;&nbsp;&nbsp; telefone: _String_  
  &nbsp;&nbsp;&nbsp;&nbsp; data_nascimento: _Date_  
  &nbsp;&nbsp;&nbsp;&nbsp; uf: _String_  
  &nbsp;&nbsp;&nbsp;&nbsp; crm: _String_  

* **Status** :    
  &nbsp;&nbsp;&nbsp;&nbsp; id: _Number_ (Primary key)  
  &nbsp;&nbsp;&nbsp;&nbsp; descricao: _String_  

* **Tomografia** :    
  &nbsp;&nbsp;&nbsp;&nbsp; id: _Number_ (Primary key)  
  &nbsp;&nbsp;&nbsp;&nbsp; id_paciente: _Number_ (Foreign Key: Paciente)  
  &nbsp;&nbsp;&nbsp;&nbsp; cod_projeto: _String_  
  &nbsp;&nbsp;&nbsp;&nbsp; espessura_tc: _Number_  
  &nbsp;&nbsp;&nbsp;&nbsp; dicom: _Blob_  

* **Casos** :    
  &nbsp;&nbsp;&nbsp;&nbsp; id: _Number_ (Primary key)   
  &nbsp;&nbsp;&nbsp;&nbsp; id_doutor: _Number_ (Foreign Key: Doutor)  
  &nbsp;&nbsp;&nbsp;&nbsp; id_paciente: _Number_ (Foreign Key: Paciente)  
  &nbsp;&nbsp;&nbsp;&nbsp; id_status: _Number_ (Foreign Key: Status)  
  &nbsp;&nbsp;&nbsp;&nbsp; id_tomografia: _Number_ (Foreign Key: Tomografia)  
  &nbsp;&nbsp;&nbsp;&nbsp; data_cirurgia: _Date_  
  
![modelagem proposta para a clínica](https://i.imgur.com/ABPTXkG.jpeg)

## Simulação das chamadas de dados persistidos  
### Pacientes
![Chamada de todos os pacientes na base de dados](https://i.imgur.com/oEHN5dt.png)

### Doutores
![Chamada de todos os pacientes na base de dados](https://imgur.com/8qoBu2z.png)

### Tomografias
![Chamada de todos os pacientes na base de dados](https://imgur.com/doSNkCL.png)

### Casos
![Chamada de todos os pacientes na base de dados](https://imgur.com/ev1sMLf.png)

### Status
![Chamada de todos os pacientes na base de dados](https://imgur.com/iKi6YSM.png)

