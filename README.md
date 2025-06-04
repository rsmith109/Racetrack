# Racetrack
Project that displays the use graph traversal algorithms and using graphs to solve problems

The basics of the game trying to be solved can be explained using this link:
https://en.wikipedia.org/wiki/Racetrack_(game)

The goal is to find the shortest path to the end of the racetrack and beat your opponent

GraphCreation:
This folder contains the file that creates a graph of all the possible vertices the race car can travel to. This file creates the model that the search algorithm will use to find the shortest paths

graphs:
Contatins the data structure graphs and search algorithms that will be used for the project

Main:
This is where 3 different racetracks are represented using an array of 1s and 0s (0s being the track and 1s being out of bounds).A graph model is created using the GraphCreation class and searched through using BFS to find the shortest amount of moves to reach one of the end verticies
