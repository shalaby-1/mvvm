# mvvm
the pattern of mvvm  
Steps of MVVM  
1- view asks view model about the data  
2- view model gets the data from model / database  
3- view model sets the value of mutablelivedata to the data  
4- view model notifies that the data has changed  
5- view listens for the changes in mutablelivedata and get the value of it  
