# -*- coding: utf-8 -*-
"""
Created on Sun Jan 28 23:26:19 2018

@author: 45336
"""

#######
#read maze
#######

Maze = []
with open('maze.txt','r') as f:
    for line in f.readlines():
        Maze.append(line.strip().split(' '))

#######
#find path
#######



def find_path(xstart, ystart, xgoal, ygoal, maze):
    
        
    
    '''
    if (x,y outside maze) return false
    if (x,y is goal) return true
    if (x,y not open) return false
    mark x,y as part of solution path
    if (FIND-PATH(North of x,y) == true) return true
    if (FIND-PATH(East of x,y) == true) return true
    if (FIND-PATH(South of x,y) == true) return true
    if (FIND-PATH(West of x,y) == true) return true
    unmark x,y as part of solution path
    return false
    '''
    
    #maze = [l[:] for l in original_maze]
    #maze = original_maze
    
    if xstart < 0 or ystart <0 or xstart > 80 or ystart > 80:
        return False
    if xstart == xgoal and ystart == ygoal:
        return True
    if maze[xstart][ystart] != '0':
        return False
    maze[xstart][ystart] = '+'
    if find_path(xstart, ystart-1, xgoal, ygoal, maze) == True:
        return True
    if find_path(xstart+1, ystart, xgoal, ygoal, maze) == True:
        return True
    if find_path(xstart, ystart+1, xgoal, ygoal, maze) == True:
        return True
    if find_path(xstart-1, ystart, xgoal, ygoal, maze) == True:
        return True
    maze[xstart][ystart] = '-'
    return False


#print(find_path(1,34,15,47,Maze))
#print(find_path(1,2,3,39,Maze))
#print(find_path(0,0,3,77,Maze))
#print(find_path(1,75,8,79,Maze))
print(find_path(1,75,39,40,Maze))



