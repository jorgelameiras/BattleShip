import java.awt.*;
import javax.swing.JFrame;

public class Screen {
	private GraphicsDevice vc;		// This give us a interface to our graphics card
	
	public Screen() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();	// This is just getting our local graphics environment
		vc = env.getDefaultScreenDevice();	// This gives us access to the entire computer screen
		
	}
	
	public void setFullScreen(DisplayMode dm, JFrame window) {
		window.setUndecorated(true);	// Gets rid of every on the screen. So its FullScreen
		window.setResizable(false);
		vc.setFullScreenWindow(window);
		
		if(dm != null && vc.isDisplayChangeSupported()) {		// Making sure the display can use your settings 
			try {
				vc.setDisplayMode(dm);
			}catch(Exception ex) {}
		}
	}
	
	public Window getFullScreenWindow() {
		return vc.getFullScreenWindow();
	}
	
	public void restoreScreen() {
		Window w = vc.getFullScreenWindow();
		if(w != null) {
			w.dispose();		// Freeze resources before you delete them
		}
		vc.setFullScreenWindow(null);
	}
}
