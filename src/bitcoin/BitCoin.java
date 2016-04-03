package bitcoin;

public class BitCoin {
    
    private  float carteira;
    private String nome;
    private int n_usuarios;
    
    
    public BitCoin(){
        
        UserInfo tela_login = new UserInfo(this);            
        new MulticastPeer();
    }
    
    public static void main(String[] args) {
              
        new BitCoin();
        
    }

    public float getCarteira() {
        return carteira;
    }

    public void setCarteira(float carteira) {
        this.carteira = carteira;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getN_usuarios() {
        return n_usuarios;
    }

    public void setN_usuarios(int n_usuarios) {
        this.n_usuarios = n_usuarios;
    }
    
}
