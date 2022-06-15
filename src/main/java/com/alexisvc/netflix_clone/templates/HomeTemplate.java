package com.alexisvc.netflix_clone.templates;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class HomeTemplate extends JFrame {
	
	private JPanel panelUP,
	panelCenter,
	panelPrincipal,
	panelSectionOne,
	panelSectionTwo,
	panelSectionThree,
	panelSectionFour,
	panelSectionFive,
	panelSectionSix;
	
	// Components for panelUP:
	private JLabel imageLogo;
	private JButton buttonLogin;
	private final ImageIcon IMAGE_LOGO  = new ImageIcon(getClass().getResource("./../resources/images/home/logo_netflix.png"));
	private final ImageIcon IMAGE_BUTTON_LOGIN = new ImageIcon(getClass().getResource("./../resources/images/home/iniciar_sesion.png"));
	private final ImageIcon IMAGE_BUTTON_LOGIN_MOUSE = new ImageIcon(getClass().getResource("./../resources/images/home/iniciar_sesion_mouse.png"));
	
	// Components for panelCenter
	private JScrollPane scrollPanel;
	private GridBagConstraints gridConstraint;
	
	// Components for section 1:
	private JLabel labelPrincipalTitle, labelSubtitle;
	private JButton buttonStart;
	private GridBagConstraints gridConstraintSection1;
	//private final ImageIcon IMAGE_BACKGROUND = new ImageIcon(getClass().getResource("./../resources/images/home/background_oscuro.png"));
	private final ImageIcon IMAGE_BUTTON_START = new ImageIcon(getClass().getResource("./../resources/images/home/comenzar.png"));
	private final ImageIcon IMAGE_BUTTON_START_MOUSE = new ImageIcon(getClass().getResource("./../resources/images/home/comenzar_mouse.png"));
	
	// Components for section 2:
	private JLabel labelPrincipalTitle2, labelSubtitle2, labelAnimationTV;
	private final ImageIcon IMAGE_ANIMATION_TV = new ImageIcon(getClass().getResource("./../resources/images/home/tv_netflix.gif"));
	private final ImageIcon IMAGE_ANIMATION_TV_440 = new ImageIcon(getClass().getResource("./../resources/images/home/tv_netflix_440.gif"));
	
	// Components for section 3:
	private JLabel labelPrincipalTitle3, labelSubtitle3, labelAnimationPhoneDownload;
	private final ImageIcon IMAGE_ANIMATION_PHONE = new ImageIcon(getClass().getResource("./../resources/images/home/phone_netflix.png"));
	private final ImageIcon IMAGE_ANIMATION_PHONE_440 = new ImageIcon(getClass().getResource("./../resources/images/home/phone_netflix_440.png"));
	
	// Components for section 4:
	private JLabel labelPrincipalTitle4, labelSubtitle4, labelAnimationComputer;
	private final ImageIcon IMAGE_ANIMATION_COMPUTER = new ImageIcon(getClass().getResource("./../resources/images/home/computer_netflix.png"));
	private final ImageIcon IMAGE_ANIMATION_COMPUTER_440 = new ImageIcon(getClass().getResource("./../resources/images/home/computer_netflix_440.png"));
	
	// Components for section 5:
	private JLabel labelPrincipalTitle5, labelSubtitle5, labelImageKids;
	private final ImageIcon IMAGE_ANIMATION_KIDS = new ImageIcon(getClass().getResource("./../resources/images/home/kids_netflix.png"));
	private final ImageIcon IMAGE_ANIMATION_KIDS_440 = new ImageIcon(getClass().getResource("./../resources/images/home/kids_netflix_440.png"));
	
	// Components for section 6 (Frequent Questions):
	private JLabel labelPrincipalTitle6;
	private JPanel panelQuestion1, panelQuestion2, panelQuestion3, panelQuestion4, panelQuestion5,panelQuestion6;
	private JPanel panelResponse1, panelResponse2, panelResponse3, panelResponse4, panelResponse5, panelResponse6;
	private final ImageIcon IMAGE_X_OPEN = new ImageIcon(getClass().getResource("./../resources/images/home/x_open.png"));
	private final ImageIcon IMAGE_X_CLOSE = new ImageIcon(getClass().getResource("./../resources/images/home/x_close.png"));
	private JButton buttonStartTwo;
	
	private JPanel[] panelsQuestions = null;
	private JPanel[] panelsResponses = null;
	
	// Constants
	private final Color COLOR_RED = new Color(229, 9, 20);
	private final Color COLOR_SUBTITLE = new Color(255,255,255);
	private final Color COLOR_GRAY = new Color(48, 48, 48);
	private final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
	
	//Response opened
	private JPanel panelOpened = null;
	
	public HomeTemplate(){
		
		this.setTitle("Netflix");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setMinimumSize(new Dimension(880, 515));
		
		this.addComponentListener(setResponsiveWindow(this));
		
		initComponents();
	}
	
	private void initComponents(){
		initLookAndFeel();
		
		gridConstraint = new GridBagConstraints();
		gridConstraintSection1 = new GridBagConstraints();
		
		initPanels();
		
		initComponetsPanelUP();
		initComponetsSection1();
		initComponetsSection2();
		initComponetsSection3();
		initComponetsSection4();
		initComponetsSection5();
		initComponetsSection6();
		
	}
	
	private void initLookAndFeel(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	private void initPanels(){
		//Panel principal
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(34, 34, 34));
		panelPrincipal.setLayout(new BorderLayout());
		
		//Panel UP
		panelUP = new JPanel();
		panelUP.setBackground(Color.WHITE);
		// Padding
		panelUP.setBorder(new EmptyBorder(15, 20, 10, 10));
		panelUP.setLayout(new BorderLayout());
		
		// Panel Center
		panelCenter = new JPanel();
		panelCenter.setBackground(new Color(34, 34, 34));
		panelCenter.setLayout(new GridBagLayout());
		scrollPanel = new JScrollPane(panelCenter, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
		
		// Panel Section 1
		panelSectionOne = new JPanel(){
			// load image into memory for improve performance.
			BufferedImage background = loadImage();
			
			private BufferedImage loadImage(){
				URL imagePath = getClass().getResource("./../resources/images/home/background_oscuro.png");
				BufferedImage result = null;
				
				try {
					result = ImageIO.read(imagePath);
				} catch (IOException e) {
					System.err.println("Error: " + e.getMessage());
				}
				
				return result;
			}
			
		    @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        //ImageIcon image = serviceImages.resizableImage(IMAGE_BACKGROUND, this.getWidth(), this.getHeight());
		        Dimension size = getSize();
		        //Resize background depending on panel size.
		        g.drawImage(background, 0, 0, size.width, size.height, 0, 0, background.getWidth(), background.getHeight(), null);           
		    }
		};
		panelSectionOne.setLayout(new GridBagLayout());
		panelSectionOne.setBackground(Color.BLACK);
		panelSectionOne.setBorder(new EmptyBorder(100, 20, 100, 20));
		
		// Panel Section 2
		panelSectionTwo = new JPanel();
		panelSectionTwo.setBackground(Color.BLACK);
		panelSectionTwo.setLayout(new GridBagLayout());
		
		// Panel Section 3
		panelSectionThree = new JPanel();
		panelSectionThree.setBackground(Color.BLACK);
		panelSectionThree.setLayout(new GridBagLayout());
		
		// Panel Section 4
		panelSectionFour = new JPanel();
		panelSectionFour.setBackground(Color.BLACK);
		panelSectionFour.setLayout(new GridBagLayout());
		
		// Panel Section 5
		panelSectionFive = new JPanel();
		panelSectionFive.setBackground(Color.BLACK);
		panelSectionFive.setLayout(new GridBagLayout());
		
		// Panel Section 6
		panelSectionSix = new JPanel();
		panelSectionSix.setBackground(Color.BLACK);
		panelSectionSix.setLayout(new GridBagLayout());
		panelSectionSix.setBorder(new EmptyBorder(80, 80, 0, 80));
		
		panelCenter.add(panelSectionOne, addComponentGrid(0, 0, 1));
		panelCenter.add(panelSectionTwo, addComponentGrid(1, 0, 1));
		panelCenter.add(panelSectionThree, addComponentGrid(2, 0, 1));
		panelCenter.add(panelSectionFour, addComponentGrid(3, 0, 1));
		panelCenter.add(panelSectionFive, addComponentGrid(4, 0, 1));
		panelCenter.add(panelSectionSix, addComponentGrid(5, 0, 1));
		
		panelPrincipal.add(scrollPanel, BorderLayout.CENTER);
		panelPrincipal.add(panelUP, BorderLayout.NORTH);
		
		getContentPane().add(panelPrincipal);
		
		
	}
	
	private void initComponetsPanelUP(){
		//Labels
		imageLogo = new JLabel();
		imageLogo.setOpaque(false);
		imageLogo.setIcon(resizableImage(IMAGE_LOGO, 100, 20));
		
		//Buttons
		buttonLogin = new JButton();
		buttonLogin.setCursor(CURSOR_HAND);
		buttonLogin.setFocusable(false);
		buttonLogin.setContentAreaFilled(false);
		buttonLogin.setIcon(IMAGE_BUTTON_LOGIN);
		buttonLogin.setRolloverIcon(IMAGE_BUTTON_LOGIN_MOUSE);
		buttonLogin.setBorder(null);
		
		panelUP.add(imageLogo, BorderLayout.WEST);
		panelUP.add(buttonLogin, BorderLayout.EAST);
	}
	
	private void initComponetsSection1(){
		
		labelPrincipalTitle = new JLabel("<html><div style='text-align: center;'>" + "Películas y series ilimitadas<br> y mucho más." + "</div></html>");
		labelPrincipalTitle.setForeground(Color.WHITE);
		labelPrincipalTitle.setFont(new Font("Arial", Font.BOLD, 54));
		labelPrincipalTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		labelSubtitle = new JLabel("Disfruta donde quieras. Cancela cuando quieras.");
		labelSubtitle.setForeground(Color.WHITE);
		labelSubtitle.setFont(new Font("Arial", Font.PLAIN, 24));
		labelSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		buttonStart = new JButton();
		buttonStart.setFocusable(false);
		buttonStart.setContentAreaFilled(false);
		buttonStart.setBorder(null);
		buttonStart.setIcon(IMAGE_BUTTON_START);
		buttonStart.setRolloverIcon(IMAGE_BUTTON_START_MOUSE);
		buttonStart.setCursor(CURSOR_HAND);
		
		panelSectionOne.add(labelPrincipalTitle, addComponentGrid2(0, 0, 40, 40, 10, 40));
		panelSectionOne.add(labelSubtitle, addComponentGrid2(1, 0, 10, 40, 10, 40 ));
		panelSectionOne.add(buttonStart,addComponentGrid2(2, 0, 10, 0, 40, 0));
		
	}
	
	private void initComponetsSection2(){
		labelPrincipalTitle2 = new JLabel("Disfruta en tu TV.");
		setFormatLabelPrincipal(labelPrincipalTitle2);
		
		labelSubtitle2 = new JLabel();
		String text = "Ve en smart TV, PlayStation, Xbox, Chromecast, Apple TV, reproductores de Blu-ray y <br>más.";
		setFormatSubtitles(labelSubtitle2, text);
		
		labelAnimationTV = new JLabel();
		labelAnimationTV.setIcon(IMAGE_ANIMATION_TV);
		
		panelSectionTwo.add(labelPrincipalTitle2, addComponentGrid2(0, 0, 60, 20, 20, 20));
		panelSectionTwo.add(labelSubtitle2, addComponentGrid2(1, 0, 0, 20, 0, 20));
		panelSectionTwo.add(labelAnimationTV, addComponentGrid2(2, 0, 0, 20, 20, 20));
	}
	
	private void initComponetsSection3(){
		
		labelPrincipalTitle3 = new JLabel("Descarga tus series para verlas offline.");
		setFormatLabelPrincipal(labelPrincipalTitle3);
		
		labelSubtitle3 = new JLabel();
		String text = "Guarda tu contenido favorito y tendrás siempre algo para ver.";
		setFormatSubtitles(labelSubtitle3, text);
		
		labelAnimationPhoneDownload = new JLabel();
		labelAnimationPhoneDownload.setIcon(IMAGE_ANIMATION_PHONE);
		
		panelSectionThree.add(labelPrincipalTitle3, addComponentGrid2(0, 0, 60, 20, 20, 20));
		panelSectionThree.add(labelSubtitle3, addComponentGrid2(1, 0, 0, 20, 0, 20));
		panelSectionThree.add(labelAnimationPhoneDownload, addComponentGrid2(2, 0, 0, 20, 20, 20));
		
		
	}
	
	private void initComponetsSection4(){
		
		labelPrincipalTitle4 = new JLabel("Disfruta donde quieras.");
		setFormatLabelPrincipal(labelPrincipalTitle4);
		
		labelSubtitle4 = new JLabel();
		String text = "Películas y series ilimitadas en tu teléfono, tablet, computadora y TV sin costo extra.";
		setFormatSubtitles(labelSubtitle4, text);
		
		labelAnimationComputer = new JLabel();
		labelAnimationComputer.setIcon(IMAGE_ANIMATION_COMPUTER);
		
		panelSectionFour.add(labelPrincipalTitle4, addComponentGrid2(0, 0, 60, 20, 20, 20));
		panelSectionFour.add(labelSubtitle4, addComponentGrid2(1, 0, 0, 20, 0, 20));
		panelSectionFour.add(labelAnimationComputer, addComponentGrid2(2, 0, 0, 20, 20, 20));
		
		
	}
	private void initComponetsSection5(){
		
		labelPrincipalTitle5 = new JLabel("Crea perfiles para niños.");
		setFormatLabelPrincipal(labelPrincipalTitle5);
		
		labelSubtitle5 = new JLabel();
		String text = "Los niños vivirán aventuras con sus personajes favoritos en un espacio diseñado<br> exclusivamente para ellos, sin costo con tu membresía.";
		setFormatSubtitles(labelSubtitle5, text);
		
		labelImageKids = new JLabel();
		labelImageKids.setIcon(IMAGE_ANIMATION_KIDS);
		
		panelSectionFive.add(labelPrincipalTitle5, addComponentGrid2(0, 0, 60, 20, 20, 20));
		panelSectionFive.add(labelSubtitle5, addComponentGrid2(1, 0, 0, 20, 0, 20));
		panelSectionFive.add(labelImageKids, addComponentGrid2(2, 0, 0, 20, 20, 20));
		
	}
	
	private void initComponetsSection6(){
		
		labelPrincipalTitle6 = new JLabel("Preguntas frecuentes");
		setFormatLabelPrincipal(labelPrincipalTitle6);
		
		// Init response 1
		String responseOneText = "Netflix es un servicio de streaming que ofrece una gran variedad de<br> películas,"
				+ " series y documentales premiados en casi cualquier pantalla<br> conectada a internet. "
				+ "<br><br>Todo lo que quieras ver, sin límites ni comerciales, a un costo muy<br> accesible. "
				+ "Siempre hay algo nuevo por descubrir, ¡y todas las semanas se<br> agregan más películas y series!";
		JLabel labelResponse1 = new JLabel();
		setFormatResponse(responseOneText, labelResponse1);
		
		panelResponse1 = new JPanel();
		panelResponse1.setBackground(COLOR_GRAY);
		panelResponse1.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelResponse1.setVisible(false);
		
		panelResponse1.add(labelResponse1);
		
		//Init panelQuestion1
		String questionOneText = "¿Qué es Netflix?";
		
		JLabel labelQuestionOne = new JLabel();
		setFormatQuestion(questionOneText, labelQuestionOne);
		
		JButton buttonQuestionOne = new JButton();
		buttonQuestionOne.addMouseListener(showResponseEvent(panelResponse1));
		setIconButtonQuestion(buttonQuestionOne);
		
		panelQuestion1 = new JPanel();
		panelQuestion1.setBackground(COLOR_GRAY);
		panelQuestion1.setCursor(CURSOR_HAND);
		panelQuestion1.setLayout(new BorderLayout());
		panelQuestion1.setBorder(new EmptyBorder(18, 18, 18, 18));
		panelQuestion1.addMouseListener(showResponseEvent(panelResponse1));
		
		panelQuestion1.add(labelQuestionOne, BorderLayout.WEST);
		panelQuestion1.add(buttonQuestionOne, BorderLayout.EAST);
		
		// Init response 2
		String responseTwoText = "Disfruta Netflix en tu smartphone, tablet, smart TV, laptop o dispositivo de<br> streaming, "
				+ "todo por una tarifa plana mensual. Planes desde $139 hasta<br> $299 al mes. Sin costos adicionales ni contratos.";
		JLabel labelResponse2 = new JLabel();
		setFormatResponse(responseTwoText, labelResponse2);
		
		panelResponse2 = new JPanel();
		panelResponse2.setBackground(COLOR_GRAY);
		panelResponse2.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelResponse2.setVisible(false);
		
		panelResponse2.add(labelResponse2);
		
		//Init panelQuestion 2
		String questionTwoText = "¿Cuánto cuesta Netflix?";
		
		JLabel labelQuestionTwo = new JLabel();
		setFormatQuestion(questionTwoText, labelQuestionTwo);
		
		JButton buttonQuestionTwo = new JButton();
		buttonQuestionTwo.addMouseListener(showResponseEvent(panelResponse2));
		setIconButtonQuestion(buttonQuestionTwo);
		
		panelQuestion2 = new JPanel();
		panelQuestion2.setBackground(COLOR_GRAY);
		panelQuestion2.setCursor(CURSOR_HAND);
		panelQuestion2.setLayout(new BorderLayout());
		panelQuestion2.setBorder(new EmptyBorder(18, 18, 18, 18));
		panelQuestion2.addMouseListener(showResponseEvent(panelResponse2));
		
		panelQuestion2.add(labelQuestionTwo, BorderLayout.WEST);
		panelQuestion2.add(buttonQuestionTwo, BorderLayout.EAST);
		
		// Init response 3
		String responseThreeText = "Disfruta donde quieras, cuando quieras. Inicia sesión en tu cuenta de<br> Netflix "
				+ "para ver contenido al instante a través de netflix.com desde tu<br> computadora personal o en "
				+ "cualquier dispositivo con conexión a internet<br> que cuente con la app de Netflix, como smart TV, "
				+ "smartphones, tablets,<br> reproductores multimedia y consolas de juegos."
				+ "<br><br>Además, puedes descargar tus series favoritas con iOS, Android o la app<br> para Windows 10."
				+ " Con la función de descarga, puedes ver donde vayas y<br> sin conexión a internet. "
				+ "Lleva Netflix contigo adonde sea.";
		JLabel labelResponse3 = new JLabel(responseThreeText);
		setFormatResponse(responseThreeText, labelResponse3);
		
		panelResponse3 = new JPanel();
		panelResponse3.setBackground(COLOR_GRAY);
		panelResponse3.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelResponse3.setVisible(false);
		
		panelResponse3.add(labelResponse3);
		
		//Init panelQuestion3
		String questionThreeText = "¿Dónde puedo ver Netflix?";
		
		JLabel labelQuestionThree = new JLabel();
		setFormatQuestion(questionThreeText, labelQuestionThree);
		
		JButton buttonQuestionThree = new JButton();
		buttonQuestionThree.addMouseListener(showResponseEvent(panelResponse3));
		setIconButtonQuestion(buttonQuestionThree);
		
		panelQuestion3 = new JPanel();
		panelQuestion3.setBackground(COLOR_GRAY);
		panelQuestion3.setCursor(CURSOR_HAND);
		panelQuestion3.setLayout(new BorderLayout());
		panelQuestion3.setBorder(new EmptyBorder(18, 18, 18, 18));
		panelQuestion3.addMouseListener(showResponseEvent(panelResponse3));
		
		panelQuestion3.add(labelQuestionThree, BorderLayout.WEST);
		panelQuestion3.add(buttonQuestionThree, BorderLayout.EAST);
		
		// Init response 4
		String responseFourText = "Netflix es flexible. Sin contratos molestos ni compromisos. "
				+ "Cancela la<br> membresía online con solo dos clics. No hay cargos por cancelación.<br> "
				+ "Empieza y termina cuando quieras.";
		JLabel labelResponse4 = new JLabel();
		setFormatResponse(responseFourText, labelResponse4);
		
		panelResponse4 = new JPanel();
		panelResponse4.setBackground(COLOR_GRAY);
		panelResponse4.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelResponse4.setVisible(false);
		
		panelResponse4.add(labelResponse4);
		
		//Init panelQuestion 4
		String questionFourText = "¿Cómo cancelo?";
		
		JLabel labelQuestionFour = new JLabel();
		setFormatQuestion(questionFourText, labelQuestionFour);
		
		JButton buttonQuestionFour = new JButton();
		buttonQuestionFour.addMouseListener(showResponseEvent(panelResponse4));
		setIconButtonQuestion(buttonQuestionFour);
		
		panelQuestion4 = new JPanel();
		panelQuestion4.setBackground(COLOR_GRAY);
		panelQuestion4.setCursor(CURSOR_HAND);
		panelQuestion4.setLayout(new BorderLayout());
		panelQuestion4.setBorder(new EmptyBorder(18, 18, 18, 18));
		panelQuestion4.addMouseListener(showResponseEvent(panelResponse4));
		
		panelQuestion4.add(labelQuestionFour, BorderLayout.WEST);
		panelQuestion4.add(buttonQuestionFour, BorderLayout.EAST);
		
		// Init response 5
		String responseFiveText = "Netflix tiene un amplio catálogo de películas, series, documentales,<br> animes, "
				+ "originales premiados y más. Todo lo que quieras ver, cuando<br> quieras.";
		JLabel labelResponse5 = new JLabel();
		setFormatResponse(responseFiveText, labelResponse5);
		
		panelResponse5 = new JPanel();
		panelResponse5.setBackground(COLOR_GRAY);
		panelResponse5.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelResponse5.setVisible(false);
		
		panelResponse5.add(labelResponse5);
		
		//Init panelQuestion5
		String questionFiveText = "¿Qué puedo ver en Netflix?";
		
		JLabel labelQuestionFive = new JLabel();
		setFormatQuestion(questionFiveText, labelQuestionFive);
		
		JButton buttonQuestionFive = new JButton();
		buttonQuestionFive.addMouseListener(showResponseEvent(panelResponse5));
		setIconButtonQuestion(buttonQuestionFive);
		
		panelQuestion5 = new JPanel();
		panelQuestion5.setBackground(COLOR_GRAY);
		panelQuestion5.setCursor(CURSOR_HAND);
		panelQuestion5.setLayout(new BorderLayout());
		panelQuestion5.setBorder(new EmptyBorder(18, 18, 18, 18));
		panelQuestion5.addMouseListener(showResponseEvent(panelResponse5));
		
		panelQuestion5.add(labelQuestionFive, BorderLayout.WEST);
		panelQuestion5.add(buttonQuestionFive, BorderLayout.EAST);
		
		// Init response 6
		String responseSixText = "La experiencia de Netflix para niños está incluida en la membresía"
				+ " para<br> que los padres tengan el control mientras los peques disfrutan series y<br>"
				+ " películas familiares en su propio espacio."
				+ "<br><br>Los perfiles para niños incluyen controles parentales protegidos por PIN<br> que te "
				+ "permiten restringir el contenido que pueden ver los niños en<br> función de la clasificación "
				+ "por edad y bloquear determinados títulos que<br> no quieras que los niños vean.";
		JLabel labelResponse6 = new JLabel();
		setFormatResponse(responseSixText, labelResponse6);
		
		panelResponse6 = new JPanel();
		panelResponse6.setBackground(COLOR_GRAY);
		panelResponse6.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelResponse6.setVisible(false);
		
		panelResponse6.add(labelResponse6);
		
		//Init panelQuestion6
		String questionSixText = "¿Es bueno Netflix para los niños?";
		
		JLabel labelQuestionSix = new JLabel();
		setFormatQuestion(questionSixText, labelQuestionSix);
		
		JButton buttonQuestionSix = new JButton();
		buttonQuestionSix.addMouseListener(showResponseEvent(panelResponse6));
		setIconButtonQuestion(buttonQuestionSix);
		
		panelQuestion6 = new JPanel();
		panelQuestion6.setBackground(COLOR_GRAY);
		panelQuestion6.setCursor(CURSOR_HAND);
		panelQuestion6.setLayout(new BorderLayout());
		panelQuestion6.setBorder(new EmptyBorder(18, 18, 18, 18));
		panelQuestion6.addMouseListener(showResponseEvent(panelResponse6));
		
		panelQuestion6.add(labelQuestionSix, BorderLayout.WEST);
		panelQuestion6.add(buttonQuestionSix, BorderLayout.EAST);
		
		panelsQuestions = new JPanel[]{
			panelQuestion1,
			panelQuestion2,
			panelQuestion3,
			panelQuestion4,
			panelQuestion5,
			panelQuestion6};
		
		panelsResponses = new JPanel[]{
				panelResponse1,
				panelResponse2,
				panelResponse3,
				panelResponse4,
				panelResponse5,
				panelResponse6};
		
		// Button start
		buttonStartTwo = new JButton();
		buttonStartTwo.setBorder(null);
		buttonStartTwo.setCursor(CURSOR_HAND);
		buttonStartTwo.setContentAreaFilled(false);
		buttonStartTwo.setIcon(IMAGE_BUTTON_START);
		buttonStartTwo.setRolloverIcon(IMAGE_BUTTON_START_MOUSE);
		buttonStartTwo.setFocusable(false);
		
		panelSectionSix.add(labelPrincipalTitle6 , addComponentGrid(0, 0, 0));
		panelSectionSix.add(panelQuestion1, addComponentGrid(1, 0, 0));
		panelSectionSix.add(panelQuestion2, addComponentGrid(2, 0, 0));
		panelSectionSix.add(panelQuestion3, addComponentGrid(3, 0, 0));
		panelSectionSix.add(panelQuestion4, addComponentGrid(4, 0, 0));
		panelSectionSix.add(panelQuestion5, addComponentGrid(5, 0, 0));
		panelSectionSix.add(panelQuestion6, addComponentGrid(6, 0, 0));
		
		//Personalize constraint
		GridBagConstraints buttonConstraint = addComponentGrid(7, 0, 0);
		buttonConstraint.fill = 0;
		panelSectionSix.add(buttonStartTwo, buttonConstraint);
		
	}
	
	private GridBagConstraints addComponentGrid(int row, int column, int height){
		gridConstraint.gridx = column;
		gridConstraint.gridy = row;
		//gridConstraint.gridheight = height;
		
		gridConstraint.fill = GridBagConstraints.BOTH;
		gridConstraint.weightx = 1;
		gridConstraint.weighty = 1;
		gridConstraint.insets.bottom = 10;
		
		return gridConstraint;
		
	}
	
	private GridBagConstraints addComponentGrid2(int row, int column, int paddingTop, int paddingLeft, int paddintBottom, int paddingRight){
		
		gridConstraintSection1.gridx = column;
		gridConstraintSection1.gridy = row;
		gridConstraintSection1.insets = new Insets(paddingTop, paddingLeft, paddintBottom, paddingRight);
		
		return gridConstraintSection1;
	}
	
	private void setFormatLabelPrincipal(JLabel label){
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 40));
		label.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	private void setFormatSubtitles(JLabel subtitleLabel, String text){
		subtitleLabel.setText("<html><div style='text-align: center;'>"+ text + "</div></html>");
		subtitleLabel.setForeground(COLOR_SUBTITLE);
		subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	private void setFormatQuestion(String question, JLabel labelQuestion) {
		labelQuestion.setText("<html><body>" + question + "</body></html>");
		labelQuestion.setForeground(Color.WHITE);
		labelQuestion.setFont(new Font("Arial", Font.PLAIN, 20));
		labelQuestion.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	private void setFormatResponse(String response, JLabel labelResponse){
		labelResponse.setText("<html><body>" + response + "</body></html>");
		labelResponse.setForeground(Color.WHITE);
		labelResponse.setFont(new Font("Arial", Font.PLAIN, 20));
		labelResponse.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	private void setIconButtonQuestion(JButton button){
		button.setIcon(IMAGE_X_OPEN);
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		button.setBorder(null);
	}
	
	private ImageIcon resizableImage(ImageIcon image, int width, int height){
		return new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		
	}
	
	private MouseListener showResponseEvent(JPanel response){
		return new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
			
				if(panelOpened == null) {
					panelOpened = response;
					response.setVisible(true);
				}else if(panelOpened == response){
					response.setVisible(false);
					panelOpened = null;
				}else{
					panelOpened.setVisible(false);
					panelOpened = response;
					response.setVisible(true);
				}
				
				// Found the row of the response.
				int row = 0;
				for(int i = 0; i < panelsResponses.length; i++){
					if(response.isVisible() && panelsResponses[i] == response){
						row = i;
						break;
					}
				}

				// Show the response in the correct row.
				int j = 1;
				for(int i = 0; i < panelsQuestions.length; i++){
					
					panelSectionSix.add(panelsQuestions[i], addComponentGrid(j, 0, 0));
					JButton button = (JButton)panelsQuestions[i].getComponent(1);
					setIconButtonQuestion(button);
					
					if(response.isVisible() && i == row){
						j++;
						panelSectionSix.add(panelsResponses[i], addComponentGrid(j, 0, 0));
						button.setIcon(IMAGE_X_CLOSE);
						panelSectionSix.add(buttonStartTwo, addComponentGrid(8, 0, 0));
					}
					j++;
				}
				panelSectionSix.updateUI();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
	}
	

	
	private ComponentListener setResponsiveWindow(JFrame window){
		
		return new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				
				if(window.getWidth() >= 1250){
					
					//Images
					labelAnimationTV.setIcon(IMAGE_ANIMATION_TV_440);
					labelAnimationPhoneDownload.setIcon(IMAGE_ANIMATION_PHONE_440);
					labelAnimationComputer.setIcon(IMAGE_ANIMATION_COMPUTER_440);
					labelImageKids.setIcon(IMAGE_ANIMATION_KIDS_440);
					
					panelSectionTwo.add(labelAnimationTV, addComponentGrid2(1, 1, 0, 20, 20, 20));
					panelSectionThree.add(labelAnimationPhoneDownload, addComponentGrid2(1, 1, 0, 20, 20, 20));
					panelSectionFour.add(labelAnimationComputer, addComponentGrid2(1, 1, 0, 20, 20, 20));
					panelSectionFive.add(labelImageKids, addComponentGrid2(1, 1, 0, 20, 20, 20));
					
				}else {
					//Images
					labelAnimationTV.setIcon(IMAGE_ANIMATION_TV);
					labelAnimationPhoneDownload.setIcon(IMAGE_ANIMATION_PHONE);
					labelAnimationComputer.setIcon(IMAGE_ANIMATION_COMPUTER);
					labelImageKids.setIcon(IMAGE_ANIMATION_KIDS);
					
					panelSectionTwo.add(labelAnimationTV, addComponentGrid2(2, 0, 0, 20, 20, 20));
					panelSectionThree.add(labelAnimationPhoneDownload, addComponentGrid2(2, 0, 0, 20, 20, 20));
					panelSectionFour.add(labelAnimationComputer, addComponentGrid2(2, 0, 0, 20, 20, 20));
					panelSectionFive.add(labelImageKids, addComponentGrid2(2, 0, 0, 20, 20, 20));

				}
				
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
