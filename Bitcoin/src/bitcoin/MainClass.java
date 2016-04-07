/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitcoin;

import bitcoin.gui.UserInfo;
import bitcoin.pn.MulticastPeer;

/**
 *
 * @author digo1
 */
public class MainClass {
    
    
    public static void main(String[] args) {
        
        BitCoin b = new BitCoin();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
 
            public void run() {
                UserInfo tela_login = new UserInfo(b);
            }
        });
        
      
       
    }
}
