import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.BLUE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		/**
		 * Changing up images to match detox slideshow concept
		 */
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/7-Day-Detox-Retreat-on-an-Organic-Farm-in-Eugene-Oregon-USA.jpg") + "'</body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/3-Day Yoga Glow Juicing Retreat in Sedona, Arizona (USA).jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/amangiri-wellness-spa-retreats.jpg") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/sedona-wellness-spa-retreats.jpg") + "'</body></html>";
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/malibu-wellness-retreats.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
		/**
		 * Giving each detox image its own feed to make it pretty
		 */
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>#1 Eugene, Oregon (USA).</font> <br>Nature, nutrition, and nurturing. This one’s ideal for first-timers and longtime wellness warriors alike. It’s giving total Portlandia vibes, and we are here for it! Sober Curator Pro Tip: They have a 5-Day option as well. </body></html>";
		} else if (i==2){
			text = "<html><body><font size='5'>#2 Top Destination.</font><br> Sedona’s healing vortexes + fresh juices = a perfect long weekend to reset your body and mind. Plus, hello Instagrammers, desert heaven!</body></html>";
		} else if (i==3){
			text = "<html><body><font size='5'>#3 Mii Amo Spa – Sedona, Arizona</font><br>Simplicity is key at the Mii Amo Spa located in the spiritual city of Sedona. Treatments sourced from natural ingredients and ancient knowledge are prepared with the stunning backdrop of the Arizona desert. A clay wrap will draw out all your toxins while psychic massages and even hypnosis tap into the subconscious of open-minded guests. </body></html>";
		} else if (i==4){
			text = "<html><body><font size='5'>#4 The Ranch – Malibu, California</font><br>Well-known for its celebrity clientele, The Ranch is the perfect place to detox and clear your mind of bad habits during an up to ten-day stay. Fitness classes and hikes keep you active while a specialized meal plan and medical testing ensure that the rejuvenation process is unfolding. The sprawling accommodations are nestled amongst 200 acres of beautiful Southern California wilderness, with no room for distractions. </body></html>";
		} else if (i==5){
			text = "<html><body><font size='5'>#5 Red Mountain Resort – Ivins, Utah </font><br> A more adventurous detox vacation at Red Mountain might be for you if activities like hiking and kayaking sound like a peaceful escape. Enjoy thrilling expeditions, cutting-edge spa treatments, and unparalleled scenery with Zion National Park less than a quarter mile down the road. The ancient health and beauty rituals offered are blended from indigenous desert botanicals, local honey and mineral rich muds, clays, and salts, and praised for their tangible restorative power, while the precision massages are the perfect thing to soothe sore muscles after a long day of hiking. </body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}