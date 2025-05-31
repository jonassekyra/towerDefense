# Tower defense
## 1 Goal of the project
The goal of the tower defence was to create a simple game that is easily scalable and modifiable, with controls that are easy to learn. Users can buy different towers. The game should detect whether the player has lost/won.

## 2 Game description
Tower defence is a game in which the player's goal is to defeat waves of enemies by strategically placing towers.

The game allows one player to buy towers by clicking on its button and placing them on a location the player chose. Program constantly, checks(every 16 ms) if it should spawn new enemy, move enemies, projectiles, shoot from a tower, remove effect from enemy or end game. Game runs in a Jframe window and is controlled by mouse inputs from the user.

### 2.1 Mechanics

**All functions are controlled by users mouse input.**
-
-starting the game

-buying towers

-placing towers

-starting the next wave

-restarting the game after losing

# 3 System requirements

Tower dafense was written in Java 21. To run the game **JDK** *(Java development kit)* is needed. No external libraries were used, everything runs on standard java libraries. Program can be started in console terminal or any development enviroment that supports Java like: ***IntelliJ idea, eclipse or NetBeans***.

## 4 Program structure

This program is object oriented, it's split into a few *main classes* that are communicating with each other. 

### 4.1 Main

Main class is the starting point of the game. It initializes MainFrame. 


### 4.2 MainFrame

MainFrame class controls which panels are shown based on **gameState**.

### 4.3 GamePanel

Main loop of the game. Shows enemies, towers, projectiles, draws them from render class. It also checks where the player clicked and places a tower there if he selected any and has enough coins.

### 4.4 AttackStrategy

An interface used to create different attacks(slow, normal).

#### 4.4.1 Attack()

Method tha  t is overridden in each attack implementation.

### 4.5 AttackUtils

A class with static methods that can be called anywhere in the program but are used in different attacks, so as not to write duplicate code.

#### 4.5.1 getFirstTarget()
```java
for (Enemy e : enemiesInRange) {
            if (e.getProgress() > maxProgress) {
                maxProgress = e.getProgress();
                target = e;
            }
        }
```

This method checks for the enemy that has the biggest progress.

### 4.6 Projectile

This class represents projectile that is shot from a tower.

#### 4.6.1 update()

This method moves the projectile’s x and y coordinates towards a target, and deactivates it when it gets too close.

### 4.7 Tower

An abstract class tower represents tower in game. Uses factory method to create specific tower.

#### 4.7.1 createTower()

This method uses factory [design pattern](https://refactoring.guru/design-patterns/factory-method) to create specific enemy.

### 4.8 WaveManager

Holds list of waves, loads enemies into wave. It can also decide whether the game has been won or lost and end it.

### 4.9 Movement

Moves the enemy on a set path. It chooses a target for enemy by checking where can he move, then it moves the enemy by a few pixel each move, when it gets to the target it choses a new one.

## 5 Testing

A great way to test this game is to just play it, try different combinations of towers, you can also do nothing and see what happens. You shouldn't be able to break this game, if you are let me know and I'll atTempt to fix it.

## 6 Manual

You control this game entirely by mouse, you click at what tower you want to build and then where you want to build it.

## 7 Last few words

When making this game I learned a lot about how to work with 2D maps, how to draw things by paint methods. I think I should have added more towers, I feel like I did a decent job in prepared the code well enough for me to easily implement more tower, but there just wasn't enough time. I spenT a lot of time on movement of the enemy, I tried like four different versions but at the end it worked out. 

Since this is the first project of this size I made I had some troubles linking different classes together sometimes. Honestly these projects are atlest for me the best way to learn programMing, esspecialLy with some feedback. 

## 8. Resources

Bálint. How do I create a delay or a cooldown timer? Online. HTTPS://STACKEXCHANGE.COM/. Stack exchange. 13.5. Dostupné z: https://gamedev.stackexchange.com/questions/158616/how-do-i-create-a-delay-or-cooldown-timer. [cit. 2025-05-30].
