David Müller

# Class: MainMenu
Overview

The MainMenu class handles the initial setup and user interface of the main menu, including the configuration of buttons, labels, and their respective functions.

## Initialization
Import Packages: All necessary packages are imported.

Define Variables: Essential variables are initialized.

Methods

MainMenu: Configures and adds all buttons, labels, and their functions to the main frame.

Button Functions

Author Button: Displays a window with information about the author.

HighScore Button: Displays the high score information.

Rules Button: Displays the game rules.

Exit Button: Closes the main menu.

ShipDeployment Button: Calls the ShipDeployment class, opening two windows for players to deploy their ships via the GUI.

Main Function: Launches the main menu GUI.

# Class: ShipDeployment

Overview

The ShipDeployment class manages the ship deployment phase of the game, allowing players to place ships on the grid.


## Initialization

Define Variables: Variables are initialized similarly to the MainMenu class.

Methods

deployShipCanvas: Generates a grid of buttons for ship placement.

addCoordinates: Saves the coordinates of deployed ships.

ship: Generates any ship with the following attributes:

numberOfMoves: Determines the deployment order.

coordA and coordB: Set the initial coordinates (x, y) in the grid.

lengthOfShip: Sets the length of the ship.

type: Assigns the type of ship.

deployShip: Generates a specific ship in the defined order of deployment.

Deployment Phase

Players must place all ships and save the deployment. Ships can be placed:

Horizontally: The left side of the ship is placed on the button.

Vertically: The top side of the ship is placed on the button.

Reset Button: Clears the field for re-deployment.

# Class: Game
Overview

The Game class manages the actual gameplay, including player moves and score tracking.

## Initialization

Define Variables: Variables are initialized at the beginning.

Methods

playerXBattlefield (X = 1 or 2): Sets up the grid for each player in the GUI.

playerXMove (X = 1 or 2): Compares saved coordinates from ShipDeployment with coordinates obtained by clicking on a grid button. If they match, the button changes color to red, and the opposite player scores.

scoreXAdd (X = 1 or 2): Adds score for each player.

move: Tracks the number of turns.

play: Launches the game window and is called by the startGameButton in MainMenu.

setTurn: Switches turns between Player 1 and Player 2.

getHighScore: Returns the high score.

## Game End

The game ends when a player reveals all opposing ships.

# Class: ScoringSystem

Overview

The ScoringSystem class allows selection of different scoring systems.

## Scoring Systems

Equal Scoring: Both players have the same points-per-hit.

Compensated Scoring: Points-per-hit differ for each player to compensate for the second player's disadvantage.
