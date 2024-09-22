import javax.swing.*; //Contains graphic elements. 
import java.awt.*; 
import java.awt.event.*; //Allows graphic elements to work. 
import java.io.*; //File
import java.util.Random; 

/**
*  RPSGUIFile - extends JFrame; creates a JFrame that allows the user
*               to play Rock-Paper-Scissors with a computer.
*  @author Monico Luis
*/
public class RPSGUIFile extends JFrame {
   private JLabel headLabel = new JLabel("Rock-Paper-Scissors", JLabel.CENTER);
   private JLabel subLabel = new JLabel("Against a Computer!", JLabel.CENTER);
   private JLabel compChoiceLabel = new JLabel("", JLabel.CENTER);
   private JLabel compCount = new JLabel("Computer Score: ");
   private JLabel playerLabel = new JLabel("Click to play:");
   private JLabel playerCount = new JLabel("Player Score: ");
   private JLabel playerChoiceLabel = new JLabel("", JLabel.CENTER); 
   private JLabel tieCount = new JLabel("Ties: ");  
   private JLabel roundResult = new JLabel("", JLabel.CENTER);
   private JLabel spacingLabel = new JLabel(" ================================ ");
   private JButton buttonRock = new JButton("Rock");
   private JButton buttonPaper = new JButton("Paper");
   private JButton buttonScissor = new JButton("Scissor");
   private JButton buttonInstruction = new JButton("Instructions");
   private JButton buttonEnd = new JButton("Finish");
   private JButton buttonPlay = new JButton("Play Again");
   private int compScore = 0;
   private int playerScore = 0;
   private int tieScore = 0;
   private final int WIDTH = 900;
   private final int HEIGHT = 400;
   
    /**
    *  RPSGUIFile; RPSGUI constructor.
    */
   public RPSGUIFile() {
      this.setSize(WIDTH, HEIGHT);
      this.setTitle("Rock-Paper-Scissors");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
      this.setResizable(false);
   }
    
    /**
    *  initializeGUI; creates the JFrame with it's elements.
    *                   Adds listeners to the buttons. 
    */
   public void initializeGUI() {
      setLayout(new BorderLayout()); //Sets the JFrame to border layout.
      Font labelFont = new Font("Monospaced", Font.BOLD, 18);
      Color buttonColor = new Color(125, 214, 111);
      
      //Adds listeners to the buttons. 
      ActionListener ears = new MyListener();
      buttonRock.addActionListener(ears);
      buttonPaper.addActionListener(ears);
      buttonScissor.addActionListener(ears);
      buttonInstruction.addActionListener(ears);
      buttonEnd.addActionListener(ears);
      buttonPlay.addActionListener(ears);
      
      //Constructs the top panel and its elements.
      JPanel topPanel = new JPanel();
      JPanel topSubPanel = new JPanel(); 
      topPanel.setLayout(new BorderLayout()); 
      headLabel.setFont(new Font("Monospaced", Font.BOLD, 30));
      subLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
      buttonInstruction.setBackground(buttonColor);
      topSubPanel.add(buttonInstruction); 
      topPanel.add("Center", headLabel);
      topPanel.add("South", subLabel); 
      topPanel.add("East", topSubPanel); 
      add("North", topPanel);
      
      //Constructs the center panel and its elements.  
      JPanel centerPanel = new JPanel();
      centerPanel.setLayout (new BorderLayout()); 
        //Creates player panel and its elements. 
      JPanel playerPanel = new JPanel();
      playerPanel.setPreferredSize(new Dimension(200, 100));
          //Modifies rock button.
      buttonRock.setPreferredSize(new Dimension(150, 40));          
      buttonRock.setBackground(buttonColor);
      buttonRock.setFont(labelFont);
          //Modifies paper button.
      buttonPaper.setPreferredSize(new Dimension(150, 40));       
      buttonPaper.setBackground(buttonColor);
      buttonPaper.setFont(labelFont);
          //Modifies scissor button. 
      buttonScissor.setPreferredSize(new Dimension(150, 40));      
      buttonScissor.setBackground(buttonColor);
      buttonScissor.setFont(labelFont);
      playerLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
          //Adds elements to player sub panel. 
      playerPanel.add(playerLabel); 
      playerPanel.add(buttonRock);
      playerPanel.add(buttonPaper);
      playerPanel.add(buttonScissor);
        //Creates computer sub panel and its elements.
      JPanel compPanel = new JPanel();
      compPanel.setPreferredSize(new Dimension(200, 100));
      compPanel.setLayout(new GridLayout(3, 1));
      compChoiceLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
      playerChoiceLabel.setFont(new Font("Monospaced", Font.PLAIN, 20)); 
      roundResult.setFont(new Font("Monospaced", Font.BOLD, 35));
          //Adds elements to computer sub panel.
      compPanel.add(playerChoiceLabel); 
      compPanel.add(compChoiceLabel);
      compPanel.add(roundResult); 
        //Creates a score sub panel.
      JPanel scorePanel = new JPanel();
      scorePanel.setPreferredSize(new Dimension(200, 100));
      scorePanel.setLayout(new GridLayout(3, 1));
      playerCount.setFont(labelFont);
      compCount.setFont(labelFont);
      tieCount.setFont(labelFont);
          //Adds elements to score sub panel.
      scorePanel.add(playerCount);
      scorePanel.add(compCount);
      scorePanel.add(tieCount); 
        //Adds panels to main center panel. 
      centerPanel.add("West", playerPanel);
      centerPanel.add("Center", compPanel);
      centerPanel.add("East", scorePanel); 
      add("Center", centerPanel); 
      
      //Constructs the bottom panel and its elements.
      JPanel bottomPanel = new JPanel(); 
        //Modifies the play again button.
      buttonPlay.setPreferredSize(new Dimension(150, 40));          
      buttonPlay.setBackground(buttonColor);
      buttonPlay.setFont(labelFont);
        //Modifies the end button.
      buttonEnd.setPreferredSize(new Dimension(150, 40));          
      buttonEnd.setBackground(buttonColor);
      buttonEnd.setFont(labelFont);
        //Adds elemnts to bottom panel.
      bottomPanel.add(buttonPlay);
      bottomPanel.add(spacingLabel); 
      bottomPanel.add(buttonEnd); 
      add("South", bottomPanel);
      
   }
   
    /**
    * MyListener; creates an ActionListener. Holds the bulk of the 
    *                 Rock-Paper-Scissors game.
    */
   private class MyListener implements ActionListener {
      /**
      * actionPerformed; tells what to do when an element is clicked.
      * @param event - listens for the user's actions for each element. 
      */
      public void actionPerformed(ActionEvent event) {
         File scoreFile = new File("scores.txt"); //Creates score.txt file or if it exists, will overwrite it.
         int userChoice = 0;
         int compChoice = 0;
         Random rand = new Random(); //Random, randomizes the computer's choice. 
         
         try{
            FileWriter fw = new FileWriter(scoreFile, true); //Allows for the file to be written on. 
            PrintWriter pw = new PrintWriter(fw);
            compChoice = rand.nextInt(3 - 1 + 1) + 1; //Randomly chooses an int between 1 and 3.
            
            //If the user chooses rock. 
            if (event.getSource() == buttonRock) {
               userChoice = 1;
               playerChoiceLabel.setText("You chose rock!");  //Sets text on GUI.
               pw.println("You chose rock!"); //Writes to file.
               //Disables the buttons.
               buttonRock.setEnabled(false);
               buttonPaper.setEnabled(false);
               buttonScissor.setEnabled(false);
               
               //If the computer choses rock.  
               if (compChoice == 1) {
                  compChoiceLabel.setText("Computer chose rock!"); 
                  roundResult.setText("Its a tie!"); 
                  pw.println("Computer chose rock!");
                  pw.println("It's a tie!\n");
                  tieScore++; //Increments the tie score by 1. 
                  tieCount.setText("Ties: " + tieScore); //Updates score. 
               }
               
               //If the computer chose paper. 
               else if (compChoice == 2) {
                  compChoiceLabel.setText("Computer chose paper!");
                  roundResult.setText("You lost! Try again!");
                  pw.println("Computer chose paper!");
                  pw.println("You lost!\n");
                  compScore++; 
                  compCount.setText("Computer Score: " + compScore); //Updates score. 
               }
               
               //If computer chose scissors. 
               else {
                  compChoiceLabel.setText("Computer chose scissors!");
                  roundResult.setText("You win!");
                  pw.println("Computer chose scissors!");
                  pw.println("You win!\n");
                  playerScore++;
                  playerCount.setText("Player Score: " + playerScore); //Updates score. 
               }
            }
            
            //If the user chooses paper.
            if (event.getSource() == buttonPaper) {
               userChoice = 2; 
               playerChoiceLabel.setText("You chose paper!");
               pw.println("You chose paper!");
               buttonRock.setEnabled(false);
               buttonPaper.setEnabled(false);
               buttonScissor.setEnabled(false);
               
               //If computer chose rock. 
               if (compChoice == 1) {
                  compChoiceLabel.setText("Computer chose rock!");
                  roundResult.setText("You win!");
                  pw.println("Computer chose rock!");
                  pw.println("You win!\n");
                  playerScore++;
                  playerCount.setText("Player Score " + playerScore);
               }
               
               //If computer chose paper. 
               else if (compChoice == 2) {
                  compChoiceLabel.setText("Computer chose paper!");
                  roundResult.setText("Its a tie!");
                  pw.println("Computer chose paper!");
                  pw.println("It's a tie!\n");
                  tieScore++;
                  tieCount.setText("Ties: " + tieScore);
               }
               
               //If computer chose scissors. 
               else {
                  compChoiceLabel.setText("Computer chose scissors!");
                  roundResult.setText("You lost! Try again!");
                  pw.println("Computer chose scissors!");
                  pw.println("You lost!\n");
                  compScore++;
                  compCount.setText("Computer Score: " + compScore);
               } 
            } 
            
            //If user chooses scissors. 
            if (event.getSource() == buttonScissor) {
               userChoice = 3; 
               playerChoiceLabel.setText("You chose scissors!"); 
               pw.println("You chose scissors!");
               buttonRock.setEnabled(false);
               buttonPaper.setEnabled(false);
               buttonScissor.setEnabled(false);
               
               //If computer chose rock. 
               if (compChoice == 1) {
                  compChoiceLabel.setText("Computer chose rock!");
                  roundResult.setText("You lost! Try again!");
                  pw.println("Computer chose rock!");
                  pw.println("You lost!\n");
                  compScore++;
                  compCount.setText("Computer Score: " + compScore);
               }
               
               //If computer chose paper. 
               else if (compChoice == 2) {
                  compChoiceLabel.setText("Computer chose paper!");
                  roundResult.setText("You win!");
                  pw.println("Computer chose paper!");
                  pw.println("You win!\n");
                  playerScore++;
                  playerCount.setText("Player Score " + playerScore);
               }
               
               //If computer chose scissors 
               else {
                  compChoiceLabel.setText("Computer chose scissors!");
                  roundResult.setText("Its a tie!");
                  pw.println("Computer chose scissors!");
                  pw.println("It's a tie!\n");
                  tieScore++;
                  tieCount.setText("Ties: " + tieScore);
               }
            }
            
            //Enables the buttons so that user will be able to play again. 
            if (event.getSource() == buttonPlay) {
               userChoice = 0;
               compChoice = 0;
               buttonRock.setEnabled(true);
               buttonPaper.setEnabled(true);
               buttonScissor.setEnabled(true);
            }
            
            //Creates and displays instruction pop-up when button is pressed. 
            if (event.getSource() == buttonInstruction) {
               JOptionPane.showMessageDialog(new JFrame(), "Rock-Paper-Scissors is a game played between two people." +
                  " \nThe object of the game is to win by preemptively choosing the item that you think will beat the other person's item.\n" +
                  " \nRock beats scissors, paper beats rock, and scissors beats paper.\n" +
                  " \nTo play, click one of the options (Rock/Paper/Scissors) and you'll see if you won against the computer!" +
                  " \nPress play again to start another round." +
                  " \nPress finish to reset and save the game to a text doc called 'scores' in the same folder as this program!", 
                  "Instructions", JOptionPane.PLAIN_MESSAGE); 
            }
            
            //Resets the labels and scores and creates pop-up when button is pressed.
            if (event.getSource() == buttonEnd) {
               //Prints the final score to score.txt. 
               pw.println("Final score is-- Player: " + playerScore + " / Computer: " + compScore + " / Ties: " + tieScore);
               pw.println("===================================\n"); 
               JOptionPane.showMessageDialog(new JFrame(), "Thank you for playing!\n " //Creates pop-up.
                  + "The game will be saved in scores.txt in the same folder as this program!", "Finish Game!", JOptionPane.PLAIN_MESSAGE);
               //Resets labels and scores for a clean slate. 
               compChoiceLabel.setText("");
               playerChoiceLabel.setText("");
               compCount.setText("Computer Score: ");
               playerCount.setText("Player Score: ");
               tieCount.setText("Ties: ");
               roundResult.setText("");
               compScore = 0;
               playerScore = 0;
               tieScore = 0;
            }
            
            pw.close(); //Closes printwriter. 
         }
         //Catches an IOException. 
         catch (IOException ioe) {
            JOptionPane.showMessageDialog(new JFrame(), "An error has occured, try again.",
               "I/O Exception", JOptionPane.ERROR_MESSAGE); 
         }
      
      
      } 
   
   } 

} 
   
