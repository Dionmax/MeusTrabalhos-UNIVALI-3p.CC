public class Circulo
{
    private double raio = 1.0;
    private String cor = "red";
    
    public Circulo()
    {
        raio = 1.0;
        cor = "red";
    }
    
    public Circulo(double raio)
    {
        this.raio = raio;
    }
    
    public Circulo(String cor)
    {
        if(verificarCorValida(cor))
            this.cor = cor;
    }
    
    public Circulo(double raio, String cor)
    {
        this.raio = raio;
        
        if(verificarCorValida(cor))
            this.cor = cor;
    }
    
    private Boolean verificarCorValida(String cor)
    {
        Boolean verificacao = false;
        
        if(cor.equalsIgnoreCase("red")|| cor.equalsIgnoreCase("blue") || cor.equalsIgnoreCase("green"))
            verificacao = true;
        
        return verificacao;
    }
    
    public double getArea(double raio)   
    {
        return raio * raio * Math.PI;
    }    
}

class Programa
{
    public static void main()
    {
        
    }
}
