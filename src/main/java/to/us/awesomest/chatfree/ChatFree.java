package to.us.awesomest.chatfree;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatFree extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onChat(AsyncPlayerChatEvent event) {
        try {
            // Try to remove all recipients
            event.getRecipients().clear();
        } catch(UnsupportedOperationException e) {
            // If that fails cancel the event
            event.setCancelled(true);
        }
    }
}
