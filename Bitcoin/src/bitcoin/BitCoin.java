package bitcoin;
import bitcoin.gui.UserInfo;
import bitcoin.pn.MulticastPeer;
import java.io.Serializable;

public class BitCoin implements Serializable {
    
    public  float carteira;
    public String nome;
    public  int n_usuarios;
    public UserInfo tela_login;
    public MulticastPeer conexao;
    
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