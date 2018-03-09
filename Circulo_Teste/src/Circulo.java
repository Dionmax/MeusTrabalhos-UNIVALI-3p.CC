public class Circulo
{
    private double raio = 1.0;
    private String cor = "red";
    
    public Circulo()
    {
        raio = 1.0;
        cor = "red";
    }
    
    public Circulo(double r)
    {
        raio = r;
    }
    
    public Circulo(String c)
    {
        if(verificarCorValida(c))
            cor = c;
    }
    
    public Circulo(double r, String c)
    {
        raio = r;
        
        if(verificarCorValida(c))
            cor = c;
    }
    
    private Boolean verificarCorValida(String c)
    {
        Boolean verificacao = false;
        
        if(c.equalsIgnoreCase("red")|| c.equalsIgnoreCase("blue") || c.equalsIgnoreCase("green"))
            verificacao = true;
        
        return verificacao;
    }
    
    public double getArea(double r)   
    {
        return r * r * Math.PI;
    }    
}

class Programa
{
    public static void main()
    {
        
    }
}
