/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plugin;

import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin implements Listener{    

    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(this, this);
    }
 
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }
       
    public static String scramble(String word) {
	String newword = "";
	int rndnum;
	Random randGen = new Random();
	boolean letter[] = new boolean[word.length()];
	do {
		rndnum = randGen.nextInt(word.length());
		if (letter[rndnum] == false) {
			newword = newword + word.charAt(rndnum);
			letter[rndnum] = true;
		}
	} while (newword.length() < word.length());
	return newword;
        
        
}
    @EventHandler (priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
       Player player = event.getPlayer();
       String msg = event.getMessage();
       
	for (PotionEffect pe : player.getActivePotionEffects()) {
            
        if (pe.getType() == PotionEffectType.POISON) {
        msg = scramble(msg);
        event.setMessage(msg);
        }
        
        if (pe.getType() == PotionEffectType.WITHER) {
        msg = scramble(msg);
        event.setMessage(msg);
        }
        
       
        
        int ft = player.getFireTicks();
        if (ft > 0) { 
        msg = scramble(msg);       
        event.setMessage(msg);}
        
        event.setMessage(msg); 
        }    
        
    }   
         
    }
   
 