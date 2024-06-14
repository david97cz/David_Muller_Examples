David Müller

## Code Structure

The code is consisted of 4 classes. The main class is Main_menu where all initial parameters can be set – size of board, ship deployment or scoring system. Other classes – ShipDeployment, Game and Scoring System are somehow connected to the main class.
 
In Main_Menu class are first imported all packages, then are defined all variables
In method Main_menu all buttons, labels and function of buttons are adjusted, and they are added to the main frame:
 
If the The authorButton button is used, window with information about the author (me) pop up:
 
Buttons highScoreButton and rulesButton has function based on similar principle.
The exitButton will close the Main method:
 
Buttons highScoreButton and rulesButton has function based on similar principle.
The main function in Main_menu is used only launch main menu GUI:
  
The shipDeploymentButton calls the ShipDeplyment class and open 2 windows, where players can deploy their ship via GUI:
 
In the Battleship deployment window, player must place all the ships and save the deployment. The ship can be placed horizontally (left side of the ship will be placed in the button) or vertically (top side of the ship will be placed in the button). There is also reset button, that clears the field from ship and player can deploys ship again.
In the ShipDeployment class are first defined all the variables similarly as in in Main_Menu class.  ShipDeplyment class contains methods:
•	deployShipCanvas, that generates grid of buttons
•	addCoordinates, that saves coordinates of deployed ships
•	ship, that is used for generating any ship and consists of variables
o	numberOfMoves, that is used to decide in which order will the ship be deployed
o	coordA and coordB, that set first coordinates (x and y) in the grid
o	lengthOfShip, that set length of the ship
o	type, that assigns type of ship
•	deployShip, that generate specific ship in specic order of deployment
 

If all the ships are deployed, the game can be launched
 
Class for game itself is Game. In Game class are first defined all variables. Class Game consists of methods playerXBattlefield, playerXMove, scoreXAdd  for each player (X = 1 or 2), player ,setTurn and getHighScore. In method player is set the GUI of the game. The method player is launched by the play method. Methods player1Battlefield and player2Battlefield set grid into GUI. Methods Player1Move and Player2Move compare saved coordinates from class ShipDeployment with coordinates obtained by clicking on arbitrary button in grid. If they are same the button changes its colour to red and add score to opposite player.
 
Methods scoreAdd and move are used for adding score and number of turn.
Method play is used to launch the Game window and it is used in Main_Menu in button startGameButton.
 
Method setTurn allows switching game between Player 1 and Player 2 after a turn is played.
Method getHighScore returns hight score.
Game will ends when player reveals all opposing ships 
Last class ScoringSystem is for choosing scoring system.
In first case is scoring system equals for both players. In second case the points-per-hit are different for each player in order to compensate the player going second.
