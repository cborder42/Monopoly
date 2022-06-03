# Monopoly

## Overview

This is the final AP CS project for 2021-2022 at the Overlake School. Team members are:
- Anya N
- Brian H
- Kaustav M
- Rishi M

## Running

We have put the main in Game.java which will start the game.
1. The game will paint the board and ask for the number of players (2-4).
2. When a player lands on a property that can be purchased, an option to "Buy"/"Build" is presented along with "Skip" and "Auto".
3. If the player selects "Auto", the computer will take over the plays for that user.
4. Other keystrokes in "Auto" mode:
  - Press "q" to quit the game.
  - Press "+" to speed up the game in "auto" mode.
  - Press "-" to slow down in "auto" mode.

## Implementation

The main components are Board with 40 Property instances, DisplayGraphics for the user interface, and ChanceCards with individual Chance and Community Chest cards. Game class calls into these classes to run the game until only one player is remaining and all others are bankrupt. Player class has most of the logic for making each move.

## Rules

We have implemented many of the [Official Monopoly rules](https://www.officialgamerules.org/monopoly). The text below is borrowed from the site.

### Preparation

- Chance and Community Chest cards are sorted randomly.
- Each player gets $1500
- Each player rolls the dice and the highest one starts.

### Go

- Each time a player's token lands on or passes over GO, whether by throwing the dice or drawing a card, the Banker pays that player a $200 salary.
- However, if a player passing GO on the throw of the dice lands 2 spaces beyond it on Community Chest, or 7 spaces beyond it on Chance, and draws the "Advance to GO" card, they collect $200 for passing GO the first time, and another $200 for Advancing to it the second time by the instructions on the card.

### Buying Property

- Whenever you land on an unowned property you may buy that property from the Bank at its printed price.
- *Not implemented:* Any player, including the one who declined the option to buy it at the printed price, may bid. Bidding may start at any price.

### Paying Rent

- When you land on a property that is owned by another player, the owner collects rent from you in accordance with the list printed on its Title Deed card.
- *Not implemented:* Mortaging a property.

### Chance and Community Chest

- When you land on either of these spaces, take the top card from the deck indicated, follow the instructions and return the card face down to the bottom of the deck. 
- *Not implemented:* The "Get Out of Jail Free" card is held until used and then returned to the bottom of the deck.

### Income Tax

- If you land here you have two options: You may estimate your tax at $200 and pay the Bank, or you may pay 10% of your total worth to the Bank.
- *Not implemented:* 10% of your total worth calculation.

### Jail

You land in Jail when...
1. Your token lands on the space marked "Go to Jail",
2. You draw a card marked "Go to Jail" or
3. You throw doubles three times in succession.

A player gets out of Jail by...
1. Throwing doubles on any of your next three turns, if you succeed in doing this you immediately move forward the number of spaces shown by your doubles throw. Even though you had thrown doubles, you do not take another turn.
2. *Not implemented:* Using the "Get Out of Jail Free Card"
3. *Not implemented:* Purchasing the "Get Out of Jail Free Card" from another player and playing it.
4. Paying a fine of $50 before you roll the dice on either of your next two turns. If you do not throw doubles by your third turn, you must pay the $50 fine. 

### Free Parking

A player landing on this place does not receive any money, property or reward of any kind.
This is just a "free" resting-place.

### Houses and Hotels

1. *Not implemented fully, player allowed to build house on owned property:* When a player owns all the properties in a colour-group they may buy houses from the Bank and erect them on those properties.
2. *Not implemented colour-group:* The owner still collects double rent from an opponent who lands on the unimproved properties of there complete colour-group.
3. *Not implemented colour group:* When a player has four houses on each property of a complete colour-group, they may buy a hotel from the Bank and erect it on any property of the colour-group. 

### Selling

1. Houses and Hotels may be sold back to the Bank at any time for one-half the price paid for them.
2. *Not implemented:* However, no property can be sold to another player if buildings are standing on any properties of that colour-group. Any buildings so located must be sold back to the Bank before the owner can sell any property of that colour-group.
3. Computer automatically sells enough properties when rent or fine is due.

### Mortgages

Not implemented

