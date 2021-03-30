package model.bean;

public class produto {
    
    private int id;
    private String nome_cliente;
    private String logradouro;
    private float CC;
    private float CPF;
    private int numero_logra;

    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }
    
     public void setNome_cliente(String nome_cliente){
        this.nome_cliente = nome_cliente;
    }


    public String getLogradouro() {
        return logradouro;
    }
    
    public void setLogradouro(String logradouro){
        this.logradouro = logradouro;
    }


    public float getCC() {
        return CC;
    }
    
     public void setCC(float CC){
        this.CC = CC;
    }

    public float getCPF() {
        return CPF;
    }
    
     public void setCPF(float CPF){
        this.CPF = CPF;
    }

    public int getNumero_logra() {
        return numero_logra;
    }
    
     public void setNumero_Logra(int numero_logra){
        this.numero_logra = numero_logra;
    }
}
